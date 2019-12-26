package com.cccmbiz.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;


@ApiModel(description = "")
public class MealStatusResponseDTO {

    private Integer householdId;

    private List<MealStatusResponseMealPlansDTO> mealPlans = new ArrayList<MealStatusResponseMealPlansDTO>();

    /**
     *
     **/
    @ApiModelProperty(value = "")
    @JsonProperty("householdId")
    public Integer getHouseholdId() {
        return householdId;
    }

    public void setHouseholdId(Integer householdId) {
        this.householdId = householdId;
    }

    /**
     *
     **/
    @ApiModelProperty(value = "")
    @JsonProperty("mealPlans")
    public List<MealStatusResponseMealPlansDTO> getMealPlans() {
        return mealPlans;
    }

    public void setMealPlans(List<MealStatusResponseMealPlansDTO> mealPlans) {
        this.mealPlans = mealPlans;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class MealStatusResponseDTO {\n");

        sb.append("  householdId: ").append(householdId).append("\n");
        sb.append("  mealPlans: ").append(mealPlans).append("\n");
        sb.append("}\n");
        return sb.toString();
    }
}
