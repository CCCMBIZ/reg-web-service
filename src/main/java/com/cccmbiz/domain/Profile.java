package com.cccmbiz.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Profile {
    private int id;
    private String uid;
    private Integer householdId;
    private String cnName;
    private String firstName;
    private String lastName;
    private String sex;
    private Integer birth;
    private String phone;
    private String wechat;
    private String address;
    private String address2;
    private String city;
    private String state;
    private String country;
    private String zipcode;
    private Integer believe;
    private Byte serve;
    private Byte status;
    private Church churchByChurchId;

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
    public Integer getHouseholdId() {
        return householdId;
    }

    public void setHouseholdId(Integer householdId) {
        this.householdId = householdId;
    }

    @Basic
    @Column(name = "cn_name")
    public String getCnName() {
        return cnName;
    }

    public void setCnName(String cnName) {
        this.cnName = cnName;
    }

    @Basic
    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "sex")
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Basic
    @Column(name = "birth")
    public Integer getBirth() {
        return birth;
    }

    public void setBirth(Integer birth) {
        this.birth = birth;
    }

    @Basic
    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "wechat")
    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "address2")
    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    @Basic
    @Column(name = "city")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "state")
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Basic
    @Column(name = "country")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Basic
    @Column(name = "zipcode")
    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    @Basic
    @Column(name = "believe")
    public Integer getBelieve() {
        return believe;
    }

    public void setBelieve(Integer believe) {
        this.believe = believe;
    }

    @Basic
    @Column(name = "serve")
    public Byte getServe() {
        return serve;
    }

    public void setServe(Byte serve) {
        this.serve = serve;
    }

    @Basic
    @Column(name = "status")
    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Profile profile = (Profile) o;
        return id == profile.id &&
                Objects.equals(uid, profile.uid) &&
                Objects.equals(householdId, profile.householdId) &&
                Objects.equals(cnName, profile.cnName) &&
                Objects.equals(firstName, profile.firstName) &&
                Objects.equals(lastName, profile.lastName) &&
                Objects.equals(sex, profile.sex) &&
                Objects.equals(birth, profile.birth) &&
                Objects.equals(phone, profile.phone) &&
                Objects.equals(wechat, profile.wechat) &&
                Objects.equals(address, profile.address) &&
                Objects.equals(address2, profile.address2) &&
                Objects.equals(city, profile.city) &&
                Objects.equals(state, profile.state) &&
                Objects.equals(country, profile.country) &&
                Objects.equals(zipcode, profile.zipcode) &&
                Objects.equals(believe, profile.believe) &&
                Objects.equals(serve, profile.serve) &&
                Objects.equals(status, profile.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, uid, householdId, cnName, firstName, lastName, sex, birth, phone, wechat, address, address2, city, state, country, zipcode, believe, serve, status);
    }

    @ManyToOne
    @JoinColumn(name = "church_id", referencedColumnName = "id")
    public Church getChurchByChurchId() {
        return churchByChurchId;
    }

    public void setChurchByChurchId(Church churchByChurchId) {
        this.churchByChurchId = churchByChurchId;
    }
}
