package com.cccmbiz.services;


import com.cccmbiz.domain.Mealplan;
import com.cccmbiz.dto.*;
import org.joda.time.DateTime;

import java.util.List;

public interface MealService {

    public Iterable<Mealplan> listAllMealplan();

    public Mealplan findMealplanByHouseholdId(Integer householdId) ;

    public MealStatusResponseDTO status(MealStatusRequestDTO request);

    public MealScanResponseDTO scan(MealScanRequestDTO request);

    public Integer getHouseholdIdByPersonID(Integer personId);

    public Integer getMealIDByTime(DateTime mealTime) ;

    public MealStatusResponseMealPlansDTO retrieveMealPlanDetails(Integer householdId, Integer mealId);

    public List<MealScanResponsePickUpRecordDTO> retrievePickupRecord(Integer householdId, Integer mealId);

}
