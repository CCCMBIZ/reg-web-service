package com.cccmbiz.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Church {
    private int id;
    private String acronym;
    private String nameCn;
    private String nameEn;
    private String address;
    private String city;
    private String state;
    private String zipcode;
    private String region;
    private String website;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "acronym")
    public String getAcronym() {
        return acronym;
    }

    public void setAcronym(String acronym) {
        this.acronym = acronym;
    }

    @Basic
    @Column(name = "name_cn")
    public String getNameCn() {
        return nameCn;
    }

    public void setNameCn(String nameCn) {
        this.nameCn = nameCn;
    }

    @Basic
    @Column(name = "name_en")
    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
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
    @Column(name = "zipcode")
    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    @Basic
    @Column(name = "region")
    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Basic
    @Column(name = "website")
    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Church church = (Church) o;
        return id == church.id &&
                Objects.equals(acronym, church.acronym) &&
                Objects.equals(nameCn, church.nameCn) &&
                Objects.equals(nameEn, church.nameEn) &&
                Objects.equals(address, church.address) &&
                Objects.equals(city, church.city) &&
                Objects.equals(state, church.state) &&
                Objects.equals(zipcode, church.zipcode) &&
                Objects.equals(region, church.region) &&
                Objects.equals(website, church.website);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, acronym, nameCn, nameEn, address, city, state, zipcode, region, website);
    }
}
