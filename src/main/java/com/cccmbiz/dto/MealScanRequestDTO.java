package com.cccmbiz.dto;


import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.*;

import javax.validation.constraints.NotNull;


@ApiModel(description = "")
public class MealScanRequestDTO {

    private Integer personId = null;
    private Integer mealId = null ;


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

    @ApiModelProperty(value = "Meal ID")
    @JsonProperty("mealId")
    public Integer getMealId() {
        return mealId;
    }

    public void setMealId(Integer mealId) {
        this.mealId = mealId;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class MealScanRequestDTO {\n");

        sb.append("  personId: ").append(personId).append("\n");
        sb.append("}\n");
        return sb.toString();
    }
}
