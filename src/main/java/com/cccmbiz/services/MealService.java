package com.cccmbiz.services;


import com.cccmbiz.domain.Mealplan;
import com.cccmbiz.dto.*;
import com.cccmbiz.exception.MealException;
import org.joda.time.DateTime;

import java.util.List;

public interface MealService {

    public Iterable<Mealplan> listAllMealplan();

    public Mealplan findMealplanByHouseholdId(Integer householdId) ;

    public MealStatusResponseDTO status(MealStatusRequestDTO request);

    public MealScanResponseDTO scan(MealScanRequestDTO request) throws MealException;

    public Integer getHouseholdIdByPersonId(String sid) ;

    public Integer getMealIDByTime(DateTime mealTime);

    public List<MealStatusResponseMealPlansDTO> retrieveAllMealPlanDetails(String id)  throws MealException;

    public MealStatusResponseMealPlansDTO retrieveMealPlanDetails(Integer householdId, Integer mealId);

    public List<MealScanResponsePickUpRecordDTO> retrievePickupRecord(Integer householdId, Integer mealId);

    public List<MealScanResponsePickUpRecordDTO> retrievePickupRecordByRegisterId(Integer registerId, Integer mealId);

}
