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
    @ApiModelProperty(value = "")
    @JsonProperty("personID")
    public Integer getPersonID() {
        return personId;
    }

    public void setPersonID(Integer personID) {
        this.personId = personId;
    }


    /**
     *
     **/
    @ApiModelProperty(value = "")
    @JsonProperty("familyID")
    public Integer getFamilyID() {
        return familyId;
    }

    public void setFamilyID(Integer familyID) {
        this.familyId = familyId;
    }


    /**
     *
     **/
    @ApiModelProperty(value = "")
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

        sb.append("  personID: ").append(personId).append("\n");
        sb.append("  familyID: ").append(familyId).append("\n");
        sb.append("  MealId: ").append(mealId).append("\n");
        sb.append("}\n");
        return sb.toString();
    }
}
