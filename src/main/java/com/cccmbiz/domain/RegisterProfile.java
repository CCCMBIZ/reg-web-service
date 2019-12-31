package com.cccmbiz.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class RegisterProfile {

    private Integer profileId;
    private Integer registerId;

    @Id
    @Column(name = "profile_id")
    public Integer getProfileId() {
        return profileId;
    }

    public void setProfileId(Integer profileId) {
        this.profileId = profileId;
    }


    @Basic
    @Column(name = "register_id")
    public Integer getRegisterId() {
        return registerId;
    }

    public void setRegisterId(Integer registerId) {
        this.registerId= registerId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegisterProfile that = (RegisterProfile) o;
        return Objects.equals(profileId, that.profileId) &&
                Objects.equals(registerId, that.registerId) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(profileId, registerId);
    }
}
