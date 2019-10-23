package com.cccmbiz.controllers;

import com.cccmbiz.domain.Mealplan;
import com.cccmbiz.domain.Product;
import com.cccmbiz.dto.*;
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

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/meal")
@Api(value = "conferenceMealService", description = "Operations pertaining to scan nametag to pick up meals")
public class MealController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MealService mealService;

    @ApiOperation(value = "View a list of available products", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = "application/json")
    public Iterable<Mealplan> list(Model model) {
        Iterable<Mealplan> mealplanList = mealService.listAllMealplan();
        return mealplanList;
    }

    @ApiOperation(value = "Search meal status with an ID", response = Mealplan.class)
    @RequestMapping(value = "/status/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<MealStatusResponseDTO> searchMeal(@PathVariable Integer id, Model model) {

        Integer mealId = mealService.getMealIDByTime(DateTime.now());

        Integer householdId = mealService.getHouseholdIdByPersonID(id);

        MealStatusResponseDTO response =  getMealStatus(householdId, mealId);
        ResponseEntity<MealStatusResponseDTO> responseEntity = null;

        if (response.getFamilyID() != 0) {

            responseEntity = new ResponseEntity<MealStatusResponseDTO>(response, HttpStatus.OK);

        } else {

            responseEntity = new ResponseEntity<MealStatusResponseDTO>(response, HttpStatus.NOT_FOUND);
        }

        return responseEntity;
    }

    @ApiOperation(value = "Search Meal")
    @RequestMapping(value = "/status", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<MealStatusResponseDTO> searchMeal(@RequestBody MealStatusRequestDTO request) {
        logger.info("Check Status Person ID:" + request.getPersonID());

        // Find entire meal plan associated with the household ID
        Integer mealId = 0;

        if (request.getMealId() == null || request.getMealId() == 0) {
            mealId = mealService.getMealIDByTime(DateTime.now());
        } else {
            mealId = request.getMealId();
        }

        Integer householdId = mealService.getHouseholdIdByPersonID(request.getPersonID());

        MealStatusResponseDTO response = getMealStatus(householdId, mealId);

        ResponseEntity<MealStatusResponseDTO> responseEntity = null;

        if (response.getFamilyID() != 0) {

            responseEntity = new ResponseEntity<MealStatusResponseDTO>(response, HttpStatus.OK);

        } else {

            responseEntity = new ResponseEntity<MealStatusResponseDTO>(response, HttpStatus.NOT_FOUND);
        }

        return responseEntity;
    }

    @ApiOperation(value = "Scan Meal")
    @RequestMapping(value = "/scan", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<MealScanResponseDTO> scanMeal(@RequestBody MealScanRequestDTO request) {
        logger.info("Scan Person ID:" + request.getPersonID());

        MealScanResponseDTO response = mealService.scan(request);
        // Find current meal plan associated with household of the scanned person

        // Retrieve meal information how many ordered, and picked up

        // Verify meal ordered, how many has been taken. Check eligible to take new meal

        // If eligible, update scan record and return success message

        return new ResponseEntity(response, HttpStatus.OK);
    }

    private MealStatusResponseDTO getMealStatus(Integer householdId, Integer mealId) {

        MealStatusResponseDTO mailStatus = new MealStatusResponseDTO();

        mailStatus.setFamilyID(householdId);

        if (householdId == 0) {
            return mailStatus; //return empty
        }

        // Retrieve meal information how many ordered, and picked up
        MealStatusResponseMealPlansDTO mealplan = mealService.retrieveMealPlanDetails(householdId, mealId);

        List<MealStatusResponseMealPlansDTO> mealplanList = new ArrayList();
        mealplanList.add(mealplan);
        mailStatus.setMealPlans(mealplanList);

        return mailStatus;
    }
}
