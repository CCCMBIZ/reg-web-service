package com.cccmbiz.domain;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "meal_plan", schema = "cccc2019", catalog = "")
public class Mealplan {
    private Integer householdId;
    private Integer breakfast1;
    private Integer breakfast2;
    private Integer breakfast3;
//    private Integer breakfast4;
//    private Integer breakfast5;
    private Integer dinner1;
    private Integer dinner2;
    private Integer dinner3;
//    private Integer dinner4;
//    private Integer dinner5;
//    private String lastScannedPerson;
    private Integer lunch1;
    private Integer lunch2;
    private Integer lunch3;
//    private Integer lunch4;
//    private Integer lunch5;
    private Double breakfastFee;
    private Double dinnerFee;
    private Double lunchFee;

    @Id
    @Column(name = "HouseholdID")
    public Integer getHouseholdId() {
        return householdId;
    }

    public void setHouseholdId(Integer registrationId) {
        this.householdId = registrationId;
    }

    @Basic
    @Column(name = "breakfast1")
    public Integer getBreakfast1() {
        return breakfast1;
    }

    public void setBreakfast1(Integer breakfast1) {
        this.breakfast1 = breakfast1;
    }

    @Basic
    @Column(name = "breakfast2")
    public Integer getBreakfast2() {
        return breakfast2;
    }

    public void setBreakfast2(Integer breakfast2) {
        this.breakfast2 = breakfast2;
    }

    @Basic
    @Column(name = "breakfast3")
    public Integer getBreakfast3() {
        return breakfast3;
    }

    public void setBreakfast3(Integer breakfast3) {
        this.breakfast3 = breakfast3;
    }

//    @Basic
//    @Column(name = "breakfast4")
//    public Integer getBreakfast4() {
//        return breakfast4;
//    }
//
//    public void setBreakfast4(Integer breakfast4) {
//        this.breakfast4 = breakfast4;
//    }
//
//    @Basic
//    @Column(name = "breakfast5")
//    public Integer getBreakfast5() {
//        return breakfast5;
//    }
//
//    public void setBreakfast5(Integer breakfast5) {
//        this.breakfast5 = breakfast5;
//    }

    @Basic
    @Column(name = "dinner1")
    public Integer getDinner1() {
        return dinner1;
    }

    public void setDinner1(Integer dinner1) {
        this.dinner1 = dinner1;
    }

    @Basic
    @Column(name = "dinner2")
    public Integer getDinner2() {
        return dinner2;
    }

    public void setDinner2(Integer dinner2) {
        this.dinner2 = dinner2;
    }

    @Basic
    @Column(name = "dinner3")
    public Integer getDinner3() {
        return dinner3;
    }

    public void setDinner3(Integer dinner3) {
        this.dinner3 = dinner3;
    }

//    @Basic
//    @Column(name = "dinner4")
//    public Integer getDinner4() {
//        return dinner4;
//    }
//
//    public void setDinner4(Integer dinner4) {
//        this.dinner4 = dinner4;
//    }
//
//    @Basic
//    @Column(name = "dinner5")
//    public Integer getDinner5() {
//        return dinner5;
//    }
//
//    public void setDinner5(Integer dinner5) {
//        this.dinner5 = dinner5;
//    }
//
//    @Basic
//    @Column(name = "lastScannedPerson")
//    public String getLastScannedPerson() {
//        return lastScannedPerson;
//    }
//
//    public void setLastScannedPerson(String lastScannedPerson) {
//        this.lastScannedPerson = lastScannedPerson;
//    }

    @Basic
    @Column(name = "lunch1")
    public Integer getLunch1() {
        return lunch1;
    }

    public void setLunch1(Integer lunch1) {
        this.lunch1 = lunch1;
    }

    @Basic
    @Column(name = "lunch2")
    public Integer getLunch2() {
        return lunch2;
    }

    public void setLunch2(Integer lunch2) {
        this.lunch2 = lunch2;
    }

    @Basic
    @Column(name = "lunch3")
    public Integer getLunch3() {
        return lunch3;
    }

    public void setLunch3(Integer lunch3) {
        this.lunch3 = lunch3;
    }

//    @Basic
//    @Column(name = "lunch4")
//    public Integer getLunch4() {
//        return lunch4;
//    }
//
//    public void setLunch4(Integer lunch4) {
//        this.lunch4 = lunch4;
//    }
//
//    @Basic
//    @Column(name = "lunch5")
//    public Integer getLunch5() {
//        return lunch5;
//    }
//
//    public void setLunch5(Integer lunch5) {
//        this.lunch5 = lunch5;
//    }

    @Basic
    @Column(name = "breakfastFee")
    public Double getBreakfastFee() {
        return breakfastFee;
    }

    public void setBreakfastFee(Double breakfastFee) {
        this.breakfastFee = breakfastFee;
    }

    @Basic
    @Column(name = "dinnerFee")
    public Double getDinnerFee() {
        return dinnerFee;
    }

    public void setDinnerFee(Double dinnerFee) {
        this.dinnerFee = dinnerFee;
    }

    @Basic
    @Column(name = "lunchFee")
    public Double getLunchFee() {
        return lunchFee;
    }

    public void setLunchFee(Double lunchFee) {
        this.lunchFee = lunchFee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mealplan mealplan = (Mealplan) o;
        return Objects.equals(householdId, mealplan.householdId) &&
                Objects.equals(breakfast1, mealplan.breakfast1) &&
                Objects.equals(breakfast2, mealplan.breakfast2) &&
                Objects.equals(breakfast3, mealplan.breakfast3) &&
//                Objects.equals(breakfast4, mealplan.breakfast4) &&
//                Objects.equals(breakfast5, mealplan.breakfast5) &&
                Objects.equals(dinner1, mealplan.dinner1) &&
                Objects.equals(dinner2, mealplan.dinner2) &&
                Objects.equals(dinner3, mealplan.dinner3) &&
//                Objects.equals(dinner4, mealplan.dinner4) &&
//                Objects.equals(dinner5, mealplan.dinner5) &&
//                Objects.equals(lastScannedPerson, mealplan.lastScannedPerson) &&
                Objects.equals(lunch1, mealplan.lunch1) &&
                Objects.equals(lunch2, mealplan.lunch2) &&
                Objects.equals(lunch3, mealplan.lunch3) &&
//                Objects.equals(lunch4, mealplan.lunch4) &&
//                Objects.equals(lunch5, mealplan.lunch5) &&
                Objects.equals(breakfastFee, mealplan.breakfastFee) &&
                Objects.equals(dinnerFee, mealplan.dinnerFee) &&
                Objects.equals(lunchFee, mealplan.lunchFee);
    }

    @Override
    public int hashCode() {
//        return Objects.hash(registrationId, breakfast1, breakfast2, breakfast3, breakfast4, breakfast5, dinner1, dinner2, dinner3, dinner4, dinner5, lastScannedPerson, lunch1, lunch2, lunch3, lunch4, lunch5, breakfastFee, dinnerFee, lunchFee);
        return Objects.hash(householdId, breakfast1, breakfast2, breakfast3, dinner1, dinner2, dinner3, lunch1, lunch2, lunch3, breakfastFee, dinnerFee, lunchFee);

    }
}
