package com.cccmbiz.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;


@ApiModel(description = "")
public class MealScanResponseDTO {

    private Integer mealId = null ;
    private Integer mealOrdered = null;
    private Integer mealTaken = null;
    private Integer mealRemaining = null;
    private Integer mealStatus = null ;
    private List<MealScanResponsePickUpRecordDTO> pickUpRecord = new ArrayList<MealScanResponsePickUpRecordDTO>();

    /**
     *
     **/
    @ApiModelProperty(value = "")
    @JsonProperty("mealId")
    public Integer getMealId() {
        return mealId;
    }

    public void setMealId(Integer mealId) {
        this.mealId = mealId;
    }

    /**
     *
     **/
    @ApiModelProperty(value = "")
    @JsonProperty("mealStatus")
    public Integer getMealStatus() {
        return mealStatus;
    }

    public void setMealStatus(Integer mealStatus) {
        this.mealStatus = mealStatus;
    }

    /**
     *
     **/
    @ApiModelProperty(value = "")
    @JsonProperty("mealOrdered")
    public Integer getMealOrdered() {
        return mealOrdered;
    }

    public void setMealOrdered(Integer mealOrdered) {
        this.mealOrdered = mealOrdered;
    }


    /**
     *
     **/
    @ApiModelProperty(value = "")
    @JsonProperty("mealTaken")
    public Integer getMealTaken() {
        return mealTaken;
    }

    public void setMealTaken(Integer mealTaken) {
        this.mealTaken = mealTaken;
    }


    /**
     *
     **/
    @ApiModelProperty(value = "")
    @JsonProperty("mealRemaining")
    public Integer getMealRemaining() {
        return mealRemaining;
    }

    public void setMealRemaining(Integer mealRemaining) {
        this.mealRemaining = mealRemaining;
    }


    /**
     *
     **/
    @ApiModelProperty(value = "")
    @JsonProperty("pickUpRecord")
    public List<MealScanResponsePickUpRecordDTO> getPickUpRecord() {
        return pickUpRecord;
    }

    public void setPickUpRecord(List<MealScanResponsePickUpRecordDTO> pickUpRecord) {
        this.pickUpRecord = pickUpRecord;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class MealScanResponseDTO {\n");

        sb.append("  mealId: ").append(mealId).append("\n");
        sb.append("  mealOrdered: ").append(mealOrdered).append("\n");
        sb.append("  mealTaken: ").append(mealTaken).append("\n");
        sb.append("  mealRemaining: ").append(mealRemaining).append("\n");
        sb.append("  mealStatus: ").append(mealStatus).append("\n");
        sb.append("  pickUpRecord: ").append(pickUpRecord).append("\n");
        sb.append("}\n");
        return sb.toString();
    }
}
