package com.cccmbiz.domain;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "register", schema = "cccc2019", catalog = "")
public class Register {
    private int id;
    private String uid;
    private int householdId;
    private int eventId;
    private String profileId;
    private Timestamp createdOn;
    private Timestamp lastUpdate;
    private byte status;
    private byte priceModel;
    private byte adult;
    private Byte meal;
    private String stripeCustomerId;
    private String note;
    private Timestamp checkinTime;
    private byte totalPeople;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "uid")
    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    @Basic
    @Column(name = "household_id")
    public int getHouseholdId() {
        return householdId;
    }

    public void setHouseholdId(int householdId) {
        this.householdId = householdId;
    }

    @Basic
    @Column(name = "event_id")
    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    @Basic
    @Column(name = "profile_id")
    public String getProfileId() {
        return profileId;
    }

    public void setProfileId(String profileId) {
        this.profileId = profileId;
    }

    @Basic
    @Column(name = "created_on")
    public Timestamp getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Timestamp createdOn) {
        this.createdOn = createdOn;
    }

    @Basic
    @Column(name = "last_update")
    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Basic
    @Column(name = "status")
    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    @Basic
    @Column(name = "price_model")
    public byte getPriceModel() {
        return priceModel;
    }

    public void setPriceModel(byte priceModel) {
        this.priceModel = priceModel;
    }

    @Basic
    @Column(name = "adult")
    public byte getAdult() {
        return adult;
    }

    public void setAdult(byte adult) {
        this.adult = adult;
    }

    @Basic
    @Column(name = "meal")
    public Byte getMeal() {
        return meal;
    }

    public void setMeal(Byte meal) {
        this.meal = meal;
    }

    @Basic
    @Column(name = "stripe_customer_id")
    public String getStripeCustomerId() {
        return stripeCustomerId;
    }

    public void setStripeCustomerId(String stripeCustomerId) {
        this.stripeCustomerId = stripeCustomerId;
    }

    @Basic
    @Column(name = "note")
    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Basic
    @Column(name = "checkin_time")
    public Timestamp getCheckinTime() {
        return checkinTime;
    }

    public void setCheckinTime(Timestamp checkinTime) {
        this.checkinTime = checkinTime;
    }

    @Basic
    @Column(name = "total_people")
    public byte getTotalPeople() {
        return totalPeople;
    }

    public void setTotalPeople(byte totalPeople) {
        this.totalPeople = totalPeople;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Register register = (Register) o;
        return id == register.id &&
                householdId == register.householdId &&
                eventId == register.eventId &&
                status == register.status &&
                priceModel == register.priceModel &&
                adult == register.adult &&
                totalPeople == register.totalPeople &&
                Objects.equals(uid, register.uid) &&
                Objects.equals(profileId, register.profileId) &&
                Objects.equals(createdOn, register.createdOn) &&
                Objects.equals(lastUpdate, register.lastUpdate) &&
                Objects.equals(meal, register.meal) &&
                Objects.equals(stripeCustomerId, register.stripeCustomerId) &&
                Objects.equals(note, register.note) &&
                Objects.equals(checkinTime, register.checkinTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, uid, householdId, eventId, profileId, createdOn, lastUpdate, status, priceModel, adult, meal, stripeCustomerId, note, checkinTime, totalPeople);
    }
}
