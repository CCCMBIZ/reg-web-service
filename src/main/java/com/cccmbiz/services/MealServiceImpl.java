package com.cccmbiz.services;

import com.cccmbiz.domain.*;
import com.cccmbiz.dto.*;
import com.cccmbiz.exception.MealException;
import com.cccmbiz.repositories.*;
import org.joda.time.DateTime;
import org.joda.time.Interval;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.*;

@Service
public class MealServiceImpl implements MealService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MealplanRepository mealplanRepository;

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private MealtrackerRepository mealtrackerRepository;

    @Autowired
    private MealRepository mealRepository;

    @Autowired
    private RegisterMealRepository registerMealRepository;

    @Autowired
    private RegisterRepository registerRepository;

    @Autowired
    private RegisterProfileRepository registerProfileRepository;

    public void setMealRepository(MealRepository mealRepository) {
        this.mealRepository = mealRepository;
    }

    @Override
    public Iterable<Mealplan> listAllMealplan() {
        return mealplanRepository.findAll();
    }

    @Override
    public Mealplan findMealplanByHouseholdId(Integer householdId) {
        return mealplanRepository.findById(householdId).orElse(null);
    }

    @Override
    public MealStatusResponseDTO status(MealStatusRequestDTO request) {
        MealStatusResponseDTO response = new MealStatusResponseDTO();
        return response;
    }

    @Override
    public MealScanResponseDTO scan(MealScanRequestDTO request) throws MealException {

        MealScanResponseDTO response = new MealScanResponseDTO();

        response.setMealOrdered(0);
        response.setMealTaken(0);
        response.setMealRemaining(0);

        // Find entire meal plan associated with the household ID
        Integer mealId = 0;
        // Obtain current time
        DateTime now = DateTime.now();

        if (request.getMealId() == null || request.getMealId() == 0) {
            mealId = getMealIDByTime(now);
        } else {
            mealId = request.getMealId();
        }

        response.setMealId(mealId);

        if (mealId != 0) {

            Profile person = profileRepository.findProfileByUid(request.getId());

            if (person == null) {
                MealException exception = new MealException("Scanned ID " + request.getId() + " Not Found");
                exception.setStatus(HttpStatus.NOT_FOUND);
                throw exception;
            }

            Register register = getRegisterByPersonId(person.getId());
            // Retrieve Meal Information
            Meal meal = mealRepository.findById(mealId).get();
            // Obtain meal plan
            RegisterMeal registerMeal = registerMealRepository.findRegisterMealByRegisterByRegisterIdAndMealByMealId(register, meal);

            // Retrieve mealOrdered total
            Integer mealTotal = 0;

            if (registerMeal != null) {
                mealTotal = new Integer(registerMeal.getQty());
            }

            // Start meal tracking
            Mealtracker mt = new Mealtracker();
            mt.setPersonId(person.getId());
            mt.setHouseholdId(person.getHouseholdId());
            mt.setRegisterId(register.getId());
            mt.setMealId(mealId);
            Timestamp ts = new Timestamp(now.getMillis());
            mt.setLastModified(ts);
            // Construct display name
            mt.setRemark(constructFullName(person));
            logger.debug("remark:" + mt.getRemark());


            // Obtain taken record of current scanned registrant
            List<Mealtracker> mealtrackers;
            mealtrackers = mealtrackerRepository.findByRegisterIdAndMealId(mt.getRegisterId(), mealId);

            Integer taken = 0;

            if (mealtrackers != null && !mealtrackers.isEmpty()) {
                taken = mealtrackers.size();
            } else {
                // Empty list
                mealtrackers = new ArrayList<>();
            }
// ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
            if (mealTotal == 0 || mealTotal <= taken) {
                logger.info("Exceed Order Count");
                response.setMealStatus(1);
            } else {
                mealtrackerRepository.save(mt);
                taken++;
                mealtrackers.add(mt);
                response.setMealStatus(0);
            }

            response.setMealOrdered(mealTotal);
            response.setMealTaken(taken);
            response.setMealRemaining(mealTotal - taken);

            Collections.sort(mealtrackers, (Comparator<Mealtracker>) (m1, m2) -> m2.getLastModified().compareTo(m1.getLastModified()));

            List<MealScanResponsePickUpRecordDTO> mealScanResponsePickUpRecordDTOs = new ArrayList<>();

            for (Mealtracker mto : mealtrackers) {

                MealScanResponsePickUpRecordDTO pur = new MealScanResponsePickUpRecordDTO();
                pur.setName(mto.getRemark());
                pur.setPersonId(mto.getPersonId());

                pur.setPickUpDate(new DateTime(mto.getLastModified()).toString());

                mealScanResponsePickUpRecordDTOs.add(pur);
            }

            response.setPickUpRecord(mealScanResponsePickUpRecordDTOs);
        }

        return response;
    }

    public List<MealStatusResponseMealPlansDTO> retrieveAllMealPlanDetails(String id) throws MealException {

        Profile person = profileRepository.findProfileByUid(id);

        if (person == null) {
            MealException exception = new MealException("Scanned ID " + id + " Not Found");
            exception.setStatus(HttpStatus.NOT_FOUND);
            throw exception;
        }

        Register register = getRegisterByPersonId(person.getId());
        // Obtain meal plan
        List<RegisterMeal> registerMealList = registerMealRepository.findByRegisterByRegisterId(register);

        List<MealStatusResponseMealPlansDTO> mealplanList = new ArrayList();

        for (RegisterMeal registerMeal : registerMealList) {
            Integer mealId = registerMeal.getMealByMealId().getId();
            MealStatusResponseMealPlansDTO mealplan = new MealStatusResponseMealPlansDTO();
            mealplan.setMealId(mealId);
            // Retrieve quantity of meal in this plan
            mealplan.setMealOrdered(new Integer(registerMeal.getQty()));

            // Obtain taken record of current scanned registrant
            List<MealScanResponsePickUpRecordDTO> pickupRecords = retrievePickupRecordByRegisterId(registerMeal.getRegisterByRegisterId().getId(), mealId);
            if (pickupRecords != null && !pickupRecords.isEmpty()) {
                mealplan.setMealTaken(pickupRecords.size());
                mealplan.setMealRemaining(mealplan.getMealOrdered() - mealplan.getMealTaken());
            } else {
                // No records yet
                mealplan.setMealTaken(0);
                mealplan.setMealRemaining(0);
            }
            mealplan.setPickUpRecord(pickupRecords);
            Optional<Meal> optionalMeal = mealRepository.findById(mealId);
            if (optionalMeal.isPresent()) {
                Meal meal = optionalMeal.get();
                String mealType = "" ;
                Integer type = new Integer(meal.getType());
                if (type == 1) { mealType = "BREAKFAST"; }
                else if (type == 2) { mealType = "LUNCH"; }
                else if (type == 3) { mealType = "DINNER"; }
                mealplan.setDescription(mealType + " ON " + meal.getDate().toString() + " AT " + meal.getStartTime().toString());
            }

            mealplanList.add(mealplan);
        }
        return mealplanList;
    }

    @Override
    public MealStatusResponseMealPlansDTO retrieveMealPlanDetails(Integer householdId, Integer mealId) {

        MealStatusResponseMealPlansDTO mealStatus = new MealStatusResponseMealPlansDTO();
        mealStatus.setMealId(mealId);

        // Verify Mealplan
        Optional<Meal> optionalMeal = mealRepository.findById(mealId);

        Register register = null;

        if (optionalMeal.isPresent() && (register = registerRepository.findByHouseholdId(householdId)) != null) {
            Meal meal = optionalMeal.get();
            // Setup meal description
            mealStatus.setDescription(meal.getFood() + " on " + meal.getDate() + " " + meal.getStartTime() + " $" + meal.getPrice());
            // Check and retrieve if there is meal plan associate with the household
            RegisterMeal registerMeal = registerMealRepository.findRegisterMealByRegisterByRegisterIdAndMealByMealId(register, meal);

            if (registerMeal != null) {
                // Retrieve quantity of meal in this plan
                mealStatus.setMealOrdered(new Integer(registerMeal.getQty()));
                // Obtain taken record of current scanned registrant
                List<MealScanResponsePickUpRecordDTO> pickupRecords = retrievePickupRecord(householdId, mealId);
                if (pickupRecords != null && !pickupRecords.isEmpty()) {
                    mealStatus.setMealTaken(pickupRecords.size());
                    mealStatus.setMealRemaining(mealStatus.getMealOrdered() - mealStatus.getMealTaken());
                } else {
                    // No records yet
                    mealStatus.setMealTaken(0);
                    mealStatus.setMealRemaining(0);
                }
                mealStatus.setPickUpRecord(pickupRecords);
            }
        }
        return mealStatus;
    }

    @Override
    public List<MealScanResponsePickUpRecordDTO> retrievePickupRecordByRegisterId(Integer registerId, Integer mealId) {

        List<MealScanResponsePickUpRecordDTO> pickupRecords = new ArrayList<>();
        List<Mealtracker> mealtrackerList = mealtrackerRepository.findByRegisterIdAndMealId(registerId, mealId);

        for (Mealtracker mealtracker : mealtrackerList) {
            MealScanResponsePickUpRecordDTO mealPickupRecord = new MealScanResponsePickUpRecordDTO();
            mealPickupRecord.setPersonId(mealtracker.getPersonId());
            mealPickupRecord.setPickUpDate(new DateTime(mealtracker.getLastModified()).toString());
            mealPickupRecord.setName(mealtracker.getRemark());

            pickupRecords.add(mealPickupRecord);
        }

        return pickupRecords;
    }

    @Override
    public List<MealScanResponsePickUpRecordDTO> retrievePickupRecord(Integer householdId, Integer mealId) {

        List<MealScanResponsePickUpRecordDTO> pickupRecords = new ArrayList<>();
        List<Mealtracker> mealtrackerList = mealtrackerRepository.findByHouseholdIdAndMealId(householdId, mealId);

        for (Mealtracker mealtracker : mealtrackerList) {
            MealScanResponsePickUpRecordDTO mealPickupRecord = new MealScanResponsePickUpRecordDTO();
            mealPickupRecord.setPersonId(mealtracker.getPersonId());
            mealPickupRecord.setPickUpDate(new DateTime(mealtracker.getLastModified()).toString());
            mealPickupRecord.setName(mealtracker.getRemark());

            pickupRecords.add(mealPickupRecord);
        }

        return pickupRecords;
    }

    @Override
    public Integer getMealIDByTime(DateTime mealTime) {

        List<Meal> meals = mealRepository.findByLocation((byte) 2);

        for (Meal m : meals) {
            LocalDate ld = LocalDate.fromDateFields(m.getDate());
            LocalTime st = new LocalTime(m.getStartTime());
            LocalTime et = new LocalTime(m.getEndTime());

//            logger.info("Meal ID:" + m.getId());
            Interval interval = new Interval(ld.toDateTime(st), ld.toDateTime(et));

            if (interval.contains(mealTime) || interval.getEnd().isEqual(mealTime)) {
                logger.info("Found Meal ID : " + m.getId());
                return m.getId();
            }
        }

        return 0;
    }

    @Override
    public Integer getHouseholdIdByPersonId(String sid) {

        Profile profile = profileRepository.findProfileByUid(sid);

        if (profile != null) {
            return profile.getHouseholdId();
        } else { // Should throw NotFound exception?
            return 0;
        }
    }

    private Register getRegisterByPersonId(Integer personId) throws MealException {

        // Obtain registration ID based on person ID
        Optional<RegisterProfile> op = registerProfileRepository.findById(personId);

        if (!op.isPresent()) {
            MealException exception = new MealException("Registration ID for " + personId + " Not Found");
            exception.setStatus(HttpStatus.NOT_FOUND);
            throw exception;
        }

        RegisterProfile registerProfile = op.get();

        // Retrieve Register Information
        Optional<Register> optionalRegister = registerRepository.findById(registerProfile.getRegisterId());
        Register register = optionalRegister.get();

        return register;
    }

    private String constructFullName(Profile person) {

        String name = null;

        if (person.getCnName() != null && !person.getCnName().isEmpty()) {
            name = person.getCnName();
        }
        if (person.getFirstName() != null && !person.getFirstName().isEmpty()) {
            if (name == null) {
                name = person.getFirstName();

            } else {
                name += " ";
                name += person.getFirstName();
            }
        }
        if (person.getLastName() != null && !person.getLastName().isEmpty()) {
            if (name == null) {
                name = person.getLastName();

            } else {
                name += " ";
                name += person.getLastName();
            }
        }

        return name;
    }

    private Integer getMealOrderedQuantity(Integer householdId, Integer mealId) {
        return 0;
    }
}
