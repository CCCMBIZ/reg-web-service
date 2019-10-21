package com.cccmbiz.dto;


import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.*;

import javax.validation.constraints.NotNull;


@ApiModel(description = "")
public class MealScanRequestDTO {


    private Integer personID = null;


    /**
     *
     **/
    @ApiModelProperty(value = "")
    @JsonProperty("personID")
    public Integer getPersonID() {
        return personID;
    }

    public void setPersonID(Integer personID) {
        this.personID = personID;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class MealScanRequestDTO {\n");

        sb.append("  personID: ").append(personID).append("\n");
        sb.append("}\n");
        return sb.toString();
    }
}
