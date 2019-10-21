package com.cccmbiz.repositories;

public interface MealPlanProjection {

    public Integer getHouseholdId();

    public Integer getBreakfast1();

    public Integer getBreakfast2();

    public Integer getBreakfast3();

    public Integer getDinner1();

    public Integer getDinner2();

    public Integer getDinner3();

    public Integer getLunch1();

    public Integer getLunch2();

    public Integer getLunch3();

    public Double getBreakfastFee();

    public Double getDinnerFee();

    public Double getLunchFee();
}
