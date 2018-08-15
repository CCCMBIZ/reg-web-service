package com.cccmbiz.web;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "family", schema = "cccmdb1", catalog = "")
public class FamilyEntity {
    private int familyId;
    private String churchId;
    private String country;
    private String familyName;
    private String headOfFamilyPersonId;
    private String homeAddress;
    private String homeAddress2;
    private String homeCity;
    private String homeFax;
    private String homePhone;
    private String homeState;
    private String homeZip;
    private Boolean hotel;
    private Timestamp lastModified;
    private String misc1;
    private String misc2;
    private String misc3;
    private Boolean newsletter;
    private String otherCountry;
    private String otherState;
    private String ucCountry;
    private String ucState;

    @Id
    @Column(name = "FamilyID")
    public int getFamilyId() {
        return familyId;
    }

    public void setFamilyId(int familyId) {
        this.familyId = familyId;
    }

    @Basic
    @Column(name = "ChurchID")
    public String getChurchId() {
        return churchId;
    }

    public void setChurchId(String churchId) {
        this.churchId = churchId;
    }

    @Basic
    @Column(name = "Country")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Basic
    @Column(name = "FamilyName")
    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    @Basic
    @Column(name = "HeadOfFamilyPersonID")
    public String getHeadOfFamilyPersonId() {
        return headOfFamilyPersonId;
    }

    public void setHeadOfFamilyPersonId(String headOfFamilyPersonId) {
        this.headOfFamilyPersonId = headOfFamilyPersonId;
    }

    @Basic
    @Column(name = "HomeAddress")
    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    @Basic
    @Column(name = "HomeAddress2")
    public String getHomeAddress2() {
        return homeAddress2;
    }

    public void setHomeAddress2(String homeAddress2) {
        this.homeAddress2 = homeAddress2;
    }

    @Basic
    @Column(name = "HomeCity")
    public String getHomeCity() {
        return homeCity;
    }

    public void setHomeCity(String homeCity) {
        this.homeCity = homeCity;
    }

    @Basic
    @Column(name = "HomeFax")
    public String getHomeFax() {
        return homeFax;
    }

    public void setHomeFax(String homeFax) {
        this.homeFax = homeFax;
    }

    @Basic
    @Column(name = "HomePhone")
    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    @Basic
    @Column(name = "HomeState")
    public String getHomeState() {
        return homeState;
    }

    public void setHomeState(String homeState) {
        this.homeState = homeState;
    }

    @Basic
    @Column(name = "HomeZip")
    public String getHomeZip() {
        return homeZip;
    }

    public void setHomeZip(String homeZip) {
        this.homeZip = homeZip;
    }

    @Basic
    @Column(name = "hotel")
    public Boolean getHotel() {
        return hotel;
    }

    public void setHotel(Boolean hotel) {
        this.hotel = hotel;
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
    @Column(name = "Misc1")
    public String getMisc1() {
        return misc1;
    }

    public void setMisc1(String misc1) {
        this.misc1 = misc1;
    }

    @Basic
    @Column(name = "Misc2")
    public String getMisc2() {
        return misc2;
    }

    public void setMisc2(String misc2) {
        this.misc2 = misc2;
    }

    @Basic
    @Column(name = "Misc3")
    public String getMisc3() {
        return misc3;
    }

    public void setMisc3(String misc3) {
        this.misc3 = misc3;
    }

    @Basic
    @Column(name = "Newsletter")
    public Boolean getNewsletter() {
        return newsletter;
    }

    public void setNewsletter(Boolean newsletter) {
        this.newsletter = newsletter;
    }

    @Basic
    @Column(name = "otherCountry")
    public String getOtherCountry() {
        return otherCountry;
    }

    public void setOtherCountry(String otherCountry) {
        this.otherCountry = otherCountry;
    }

    @Basic
    @Column(name = "otherState")
    public String getOtherState() {
        return otherState;
    }

    public void setOtherState(String otherState) {
        this.otherState = otherState;
    }

    @Basic
    @Column(name = "ucCountry")
    public String getUcCountry() {
        return ucCountry;
    }

    public void setUcCountry(String ucCountry) {
        this.ucCountry = ucCountry;
    }

    @Basic
    @Column(name = "ucState")
    public String getUcState() {
        return ucState;
    }

    public void setUcState(String ucState) {
        this.ucState = ucState;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FamilyEntity that = (FamilyEntity) o;
        return familyId == that.familyId &&
                Objects.equals(churchId, that.churchId) &&
                Objects.equals(country, that.country) &&
                Objects.equals(familyName, that.familyName) &&
                Objects.equals(headOfFamilyPersonId, that.headOfFamilyPersonId) &&
                Objects.equals(homeAddress, that.homeAddress) &&
                Objects.equals(homeAddress2, that.homeAddress2) &&
                Objects.equals(homeCity, that.homeCity) &&
                Objects.equals(homeFax, that.homeFax) &&
                Objects.equals(homePhone, that.homePhone) &&
                Objects.equals(homeState, that.homeState) &&
                Objects.equals(homeZip, that.homeZip) &&
                Objects.equals(hotel, that.hotel) &&
                Objects.equals(lastModified, that.lastModified) &&
                Objects.equals(misc1, that.misc1) &&
                Objects.equals(misc2, that.misc2) &&
                Objects.equals(misc3, that.misc3) &&
                Objects.equals(newsletter, that.newsletter) &&
                Objects.equals(otherCountry, that.otherCountry) &&
                Objects.equals(otherState, that.otherState) &&
                Objects.equals(ucCountry, that.ucCountry) &&
                Objects.equals(ucState, that.ucState);
    }

    @Override
    public int hashCode() {
        return Objects.hash(familyId, churchId, country, familyName, headOfFamilyPersonId, homeAddress, homeAddress2, homeCity, homeFax, homePhone, homeState, homeZip, hotel, lastModified, misc1, misc2, misc3, newsletter, otherCountry, otherState, ucCountry, ucState);
    }
}
