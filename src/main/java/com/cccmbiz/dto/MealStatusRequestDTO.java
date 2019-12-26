package com.cccmbiz.dto;


import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.*;

import javax.validation.constraints.NotNull;


@ApiModel(description = "")
public class MealStatusRequestDTO {

    private String id = null;
    private Integer mealId = null;

    /**
     *
     **/
    @ApiModelProperty(value = "Scanned ID")
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     *
     **/
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
        sb.append("class MealStatusRequestDTO {\n");

        sb.append("  Scanned Id: ").append(id).append("\n");
        sb.append("  Meal Id: ").append(mealId).append("\n");
        sb.append("}\n");
        return sb.toString();
    }
}
