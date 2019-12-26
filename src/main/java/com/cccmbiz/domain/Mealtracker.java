package com.cccmbiz.domain;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Mealtracker {
    private Integer tid;
    private Timestamp lastModified;
    private Integer mealId;
    private Integer personId;
    private Integer registerId;
    private Integer householdId;
    private String remark;



    @Id
    @Column(name = "tid")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    @Basic
    @Column(name = "LastModified")
    public Timestamp getLastModified() {
        return lastModified;
    }

    public void setLastModified(Timestamp lastModified) {
        this.lastModified = lastModified;
    }

    @Basic
    @Column(name = "MealId")
    public Integer getMealId() {
        return mealId;
    }

    public void setMealId(Integer mealId) {
        this.mealId= mealId;
    }

    @Basic
    @Column(name = "PersonId")
    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    @Basic
    @Column(name = "RegisterId")
    public Integer getRegisterId() {
        return registerId;
    }

    public void setRegisterId(Integer registerId) {
        this.registerId = registerId;
    }

    @Basic
    @Column(name = "HouseholdId")
    public Integer getHouseholdId() {
        return householdId;
    }

    public void setHouseholdId(Integer householdId) {
        this.householdId = householdId;
    }

    @Basic
    @Column(name = "Remark")
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mealtracker that = (Mealtracker) o;
        return tid == that.tid &&
                personId == that.personId &&
                Objects.equals(lastModified, that.lastModified) &&
                Objects.equals(mealId, that.mealId) &&
                Objects.equals(registerId, that.registerId) &&
                Objects.equals(remark, that.remark);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tid, lastModified, mealId, personId, registerId, remark);
    }
}
