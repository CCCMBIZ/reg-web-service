package com.cccmbiz.dto;


import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.*;

import javax.validation.constraints.NotNull;


@ApiModel(description = "")
public class MealStatusRequestDTO {


    private Integer personId = null;


    private Integer familyId = null;


    private Integer mealId = null;


    /**
     *
     **/
    @ApiModelProperty(value = "Person ID")
    @JsonProperty("personId")
    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }


    /**
     *
     **/
    @ApiModelProperty(value = "Household ID")
    @JsonProperty("familyId")
    public Integer getFamilyId() {
        return familyId;
    }

    public void setFamilyId(Integer familyId) {
        this.familyId = familyId;
    }


    /**
     *
     **/
    @ApiModelProperty(value = "Meal ID")
    @JsonProperty("mealId")
    public Integer getMealId() {
        return mealId;
    }

    public void setMealId(Integer phoneNumber) {
        this.mealId = mealId;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class MealStatusRequestDTO {\n");

        sb.append("  personId: ").append(personId).append("\n");
        sb.append("  familyId: ").append(familyId).append("\n");
        sb.append("  MealId: ").append(mealId).append("\n");
        sb.append("}\n");
        return sb.toString();
    }
}
