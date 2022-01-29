package com.cccmbiz.services;


import com.cccmbiz.domain.Meal;
import com.cccmbiz.domain.MealPlan;
import com.cccmbiz.domain.MealPlanView;
import com.cccmbiz.dto.*;
import com.cccmbiz.exception.MealException;
import com.cccmbiz.repositories.MealPlanProjection;
import org.joda.time.DateTime;

import java.util.List;

public interface MealService {

    public List<MealPlanProjection> listAllMealPlan();

    public List<MealPlanProjection> findMealPlanByHouseholdId(Integer householdId);

    public MealStatusResponseDTO status(MealStatusRequestDTO request);

    public MealScanResponseDTO scan(MealScanRequestDTO request) throws MealException;

    public Integer getHouseholdIdByPersonId(Integer id);
    public Integer getHouseholdIdByUniqueId(String uid);

    public Integer getMealIDByTime(DateTime mealTime);

    public List<Meal> getMealInformation(Integer location);

    public Long getMealPickupCount(Integer mealId);

//    public List<MealStatusResponseMealPlansDTO> retrieveAllMealPlanDetails(Integer id)  throws MealException;
    public List<MealStatusResponseMealPlansDTO> retrieveAllMealPlanDetails(String uid) throws MealException;

    public MealStatusResponseMealPlansDTO retrieveMealPlanDetails(Integer householdId, Integer mealId);

    public List<MealScanResponsePickUpRecordDTO> retrievePickupRecord(Integer householdId, Integer mealId);

    public List<MealScanResponsePickUpRecordDTO> retrievePickupRecordByRegisterId(Integer registerId, Integer mealId);

}
