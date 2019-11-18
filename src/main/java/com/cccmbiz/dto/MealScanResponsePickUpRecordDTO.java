package com.cccmbiz.dto;


import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.*;
import org.joda.time.DateTime;

import javax.validation.constraints.NotNull;


@ApiModel(description = "")
public class MealScanResponsePickUpRecordDTO {

    private String pickUpDate = null;

    private Integer personId = null;

    private String name = null;

    /**
     *
     **/
    @ApiModelProperty(value = "")
    @JsonProperty("pickUpDate")
    public String getPickUpDate() {
        return pickUpDate;
    }

    public void setPickUpDate(String pickUpDate) {
        this.pickUpDate = pickUpDate;
    }


    /**
     *
     **/
    @ApiModelProperty(value = "")
    @JsonProperty("personId")
    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId ;
    }


    /**
     *
     **/
    @ApiModelProperty(value = "")
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class MealScanResponsePickUpRecordDTO {\n");

        sb.append("  pickUpDate: ").append(pickUpDate).append("\n");
        sb.append("  personId: ").append(personId).append("\n");
        sb.append("  name: ").append(name).append("\n");
        sb.append("}\n");
        return sb.toString();
    }
}
