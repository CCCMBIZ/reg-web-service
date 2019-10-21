package com.cccmbiz.dto;


import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.*;

import javax.validation.constraints.NotNull;


@ApiModel(description = "")
public class MealStatusRequestDTO {


    private Integer personID = null;


    private Integer familyID = null;


    private Integer phoneNumber = null;


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
    @JsonProperty("phoneNumber")
    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class MealStatusRequestDTO {\n");

        sb.append("  personID: ").append(personID).append("\n");
        sb.append("  familyID: ").append(familyID).append("\n");
        sb.append("  phoneNumber: ").append(phoneNumber).append("\n");
        sb.append("}\n");
        return sb.toString();
    }
}
