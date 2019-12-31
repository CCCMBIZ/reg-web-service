package com.cccmbiz.dto;

import com.cccmbiz.domain.Meal;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;


@ApiModel(description = "Meal information in conference")
public class MealInfoResponse {

    private List<Meal> meals = new ArrayList<>();

    /**
     *
     **/
    @ApiModelProperty(value = "")
    @JsonProperty("meals")
    public List<Meal> getMeals() {
        return meals;
    }

    public void setMeals(List<Meal> meals) {
        this.meals = meals;
    }

}
