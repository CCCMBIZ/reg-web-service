package com.cccmbiz.controllers;

import com.cccmbiz.domain.*;
import com.cccmbiz.dto.*;
import com.cccmbiz.exception.MealException;
import com.cccmbiz.repositories.ChurchRepository;
import com.cccmbiz.repositories.MealPlanProjection;
import com.cccmbiz.services.MealService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/meal")
@Api(value = "conferenceMealService", description = "Operations pertaining to scan nametag to pick up meals")
public class MealController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ChurchRepository churchRepository;

    @Autowired
    private MealService mealService;

    @RequestMapping(value = "/churches", method = RequestMethod.GET, produces = {"application/json; charset=UTF-8"})
    public Iterable<Church> churchList() {
        Iterable<Church> churchList = churchRepository.findAll();
        return churchList;
    }

    @GetMapping("/mealplan")
    public ResponseEntity<List<MealPlanView>> listMealPlan(@RequestParam(required = false) Integer householdId) {
        try {
            List<MealPlanProjection> mealPlanProjection = new ArrayList<MealPlanProjection>();

            if (householdId == null) {
                mealPlanProjection = mealService.listAllMealPlan();
            } else {
                mealPlanProjection = mealService.findMealPlanByHouseholdId(householdId);
            }

            if (mealPlanProjection.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            List<MealPlanView> list = mealPlanProjection.stream()
                    .map(this::convertToEntity)
                    .collect(Collectors.toList());

            return new ResponseEntity<>(list, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    @ApiOperation(value = "View a list of available products", response = Iterable.class)
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "Successfully retrieved list"),
//            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
//            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
//            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
//    }
//    )
//    @RequestMapping(value = "/mealplan", method = RequestMethod.GET, produces = "application/json")
//    public Iterable<MealPlanView> listMealPlan((@RequestParam(required = false) Integer mealId) {
//
//        List<MealPlanProjection> mealPlanList = mealService.listAllMealPlan();
//
//        return mealPlanList.stream()
//                .map(this::convertToEntity)
//                .collect(Collectors.toList());
//    }

    @ApiOperation(value = "Search meal status with an ID", response = ResponseEntity.class)
    @RequestMapping(value = "/status/{uid}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<MealStatusResponseDTO> searchMeal(@PathVariable String uid, Model model) {

        try {
            MealStatusResponseDTO response = new MealStatusResponseDTO();
            List<MealStatusResponseMealPlansDTO> mealplanList = mealService.retrieveAllMealPlanDetails(uid);

            Integer registerId = mealService.getHouseholdIdByUniqueId(uid);
            response.setHouseholdId(registerId);
            response.setMealPlans(mealplanList);

            return new ResponseEntity<MealStatusResponseDTO>(response, HttpStatus.OK);

        } catch (NoSuchElementException noSuchElementException) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Registration Not Found", noSuchElementException);
        } catch (MealException mealException) {
            throw new ResponseStatusException(
                    mealException.getStatus(), mealException.getMessage(), mealException);
        }
    }

    @ApiOperation(value = "Search Meal", response = ResponseEntity.class)
    @RequestMapping(value = "/status", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<MealStatusResponseDTO> searchMeal(@RequestBody MealStatusRequestDTO request) {
        logger.info("Check Status of Scanned ID:" + request.getId() + " Meal ID: " + request.getMealId());

        ResponseEntity<MealStatusResponseDTO> responseEntity = null;

        if (request.getId() == null || request.getId().isEmpty()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Empty Input ID", null);
        }
        // Find entire meal plan associated with the household ID
        Integer mealId = 0;

        if (request.getMealId() == null || request.getMealId() == 0) {
            mealId = mealService.getMealIDByTime(DateTime.now());
        } else {
            mealId = request.getMealId();
        }

        Integer householdId = mealService.getHouseholdIdByPersonId(Integer.valueOf(request.getId()));

        MealStatusResponseDTO response = getMealStatus(householdId, mealId);

        if (response.getHouseholdId() != 0) {

            responseEntity = new ResponseEntity<MealStatusResponseDTO>(response, HttpStatus.OK);

        } else {

            responseEntity = new ResponseEntity<MealStatusResponseDTO>(response, HttpStatus.NOT_FOUND);
        }

        return responseEntity;
    }

    @ApiOperation(value = "Scan Meal", response = ResponseEntity.class)
    @RequestMapping(value = "/scan", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<MealScanResponseDTO> scanMeal(@RequestBody MealScanRequestDTO request) {
        logger.info("Scanned ID: " + request.getId() + " Meal ID:" + request.getMealId());
        try {

            MealScanResponseDTO response = mealService.scan(request);
            // Find current meal plan associated with household of the scanned person

            // Retrieve meal information how many ordered, and picked up

            // Verify meal ordered, how many has been taken. Check eligible to take new meal

            // If eligible, update scan record and return success message

            return new ResponseEntity(response, HttpStatus.OK);

        } catch (NoSuchElementException noSuchElementException) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Registration Not Found", noSuchElementException);
        } catch (MealException mealException) {
            throw new ResponseStatusException(
                    mealException.getStatus(), mealException.getMessage(), mealException);
        }

    }


    @ApiOperation(value = "Retrieve Meal Information", response = ResponseEntity.class)
    @RequestMapping(value = "/info/{location}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<MealInfoResponse> info(@PathVariable Integer location, Model model) {

        try {
            MealInfoResponse response = new MealInfoResponse();
            List<Meal> mealList = mealService.getMealInformation(location);
            response.setMeals(mealList);

            return new ResponseEntity<MealInfoResponse>(response, HttpStatus.OK);
        } catch (NoSuchElementException noSuchElementException) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Registration Not Found", noSuchElementException);
        }
    }

    @ApiOperation(value = "Retrieve Meal Information", response = ResponseEntity.class)
    @RequestMapping(value = "/count/{mealId}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<MealCountResponse> count(@PathVariable Integer mealId, Model model) {

        try {
            MealCountResponse response = new MealCountResponse();
            Long count = mealService.getMealPickupCount(mealId);
            response.setCount(count);
            response.setMealId(mealId);
            return new ResponseEntity<MealCountResponse>(response, HttpStatus.OK);

        } catch (NoSuchElementException noSuchElementException) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Registration Not Found", noSuchElementException);
        }
    }

    private MealStatusResponseDTO getMealStatus(Integer householdId, Integer mealId) {

        MealStatusResponseDTO mealStatus = new MealStatusResponseDTO();

        mealStatus.setHouseholdId(householdId);

        if (householdId == 0) {
            return mealStatus; //return empty
        }

        // Retrieve meal information how many ordered, and picked up
        MealStatusResponseMealPlansDTO mealplan = mealService.retrieveMealPlanDetails(householdId, mealId);

        List<MealStatusResponseMealPlansDTO> mealplanList = new ArrayList();
        mealplanList.add(mealplan);
        mealStatus.setMealPlans(mealplanList);

        return mealStatus;
    }

    private MealPlanView convertToEntity(MealPlanProjection view) {
        MealPlanView mp = new MealPlanView();
        mp.setHouseholdId(view.getHouseholdId());
        mp.setBreakfast1(view.getBreakfast1());
        mp.setBreakfast2(view.getBreakfast2());
        mp.setBreakfast3(view.getBreakfast3());
        mp.setDinner1(view.getDinner1());
        mp.setDinner2(view.getDinner2());
        mp.setDinner3(view.getDinner3());
        mp.setLunch1(view.getLunch1());
        mp.setLunch2(view.getLunch2());
        mp.setLunch3(view.getLunch3());
        mp.setBreakfastFee(view.getBreakfastFee());
        mp.setDinnerFee(view.getDinnerFee());
        mp.setLunchFee(view.getLunchFee());
        return mp;
    }
}
