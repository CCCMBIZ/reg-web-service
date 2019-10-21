package com.cccmbiz.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;


@ApiModel(description = "")
public class MealStatusResponseDTO {

    private Integer familyID = null;

    private List<MealStatusResponseMealPlansDTO> mealPlans = new ArrayList<MealStatusResponseMealPlansDTO>();

    /**
     *
     **/
    @ApiModelProperty(value = "")
    @JsonProperty("familyID")
    public Integer getFamilyID() {
        return familyID;
    }

    public void setFamilyID(Integer familyID) {
        this.familyID = familyID;
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

        sb.append("  familyID: ").append(familyID).append("\n");
        sb.append("  mealPlans: ").append(mealPlans).append("\n");
        sb.append("}\n");
        return sb.toString();
    }
}
