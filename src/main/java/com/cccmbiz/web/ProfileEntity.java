package com.cccmbiz.web;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "profile", schema = "cccmdb1", catalog = "")
public class ProfileEntity {
    private int personId;
    private Boolean archive;
    private Boolean checkIn;
    private Timestamp checkInDate;
    private Boolean checkOut;
    private Timestamp checkOutDate;
    private Integer churchId;
    private String churchName;
    private String comments;
    private Boolean decision;
    private Integer faithYear;
    private int familyId;
    private Integer groupId;
    private Timestamp lastModified;
    private Boolean leader;
    private Boolean nametag;
    private Boolean needHotel;
    private Boolean needTranspotation;
    private String preferredLanguage;
    private Timestamp registeredDate;
    private String registrationId;
    private String roomId;
    private Boolean seeker;
    private String volunteerJobs;
    private Boolean workshop;
    private String workshop1;
    private String workshop2;

    @Id
    @Column(name = "PersonID")
    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    @Basic
    @Column(name = "Archive")
    public Boolean getArchive() {
        return archive;
    }

    public void setArchive(Boolean archive) {
        this.archive = archive;
    }

    @Basic
    @Column(name = "CheckIn")
    public Boolean getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Boolean checkIn) {
        this.checkIn = checkIn;
    }

    @Basic
    @Column(name = "CheckInDate")
    public Timestamp getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(Timestamp checkInDate) {
        this.checkInDate = checkInDate;
    }

    @Basic
    @Column(name = "CheckOut")
    public Boolean getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Boolean checkOut) {
        this.checkOut = checkOut;
    }

    @Basic
    @Column(name = "CheckOutDate")
    public Timestamp getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(Timestamp checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    @Basic
    @Column(name = "ChurchID")
    public Integer getChurchId() {
        return churchId;
    }

    public void setChurchId(Integer churchId) {
        this.churchId = churchId;
    }

    @Basic
    @Column(name = "ChurchName")
    public String getChurchName() {
        return churchName;
    }

    public void setChurchName(String churchName) {
        this.churchName = churchName;
    }

    @Basic
    @Column(name = "Comments")
    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Basic
    @Column(name = "Decision")
    public Boolean getDecision() {
        return decision;
    }

    public void setDecision(Boolean decision) {
        this.decision = decision;
    }

    @Basic
    @Column(name = "FaithYear")
    public Integer getFaithYear() {
        return faithYear;
    }

    public void setFaithYear(Integer faithYear) {
        this.faithYear = faithYear;
    }

    @Basic
    @Column(name = "FamilyID")
    public int getFamilyId() {
        return familyId;
    }

    public void setFamilyId(int familyId) {
        this.familyId = familyId;
    }

    @Basic
    @Column(name = "GroupID")
    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
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
    @Column(name = "Leader")
    public Boolean getLeader() {
        return leader;
    }

    public void setLeader(Boolean leader) {
        this.leader = leader;
    }

    @Basic
    @Column(name = "Nametag")
    public Boolean getNametag() {
        return nametag;
    }

    public void setNametag(Boolean nametag) {
        this.nametag = nametag;
    }

    @Basic
    @Column(name = "NeedHotel")
    public Boolean getNeedHotel() {
        return needHotel;
    }

    public void setNeedHotel(Boolean needHotel) {
        this.needHotel = needHotel;
    }

    @Basic
    @Column(name = "NeedTranspotation")
    public Boolean getNeedTranspotation() {
        return needTranspotation;
    }

    public void setNeedTranspotation(Boolean needTranspotation) {
        this.needTranspotation = needTranspotation;
    }

    @Basic
    @Column(name = "PreferredLanguage")
    public String getPreferredLanguage() {
        return preferredLanguage;
    }

    public void setPreferredLanguage(String preferredLanguage) {
        this.preferredLanguage = preferredLanguage;
    }

    @Basic
    @Column(name = "RegisteredDate")
    public Timestamp getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(Timestamp registeredDate) {
        this.registeredDate = registeredDate;
    }

    @Basic
    @Column(name = "RegistrationID")
    public String getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(String registrationId) {
        this.registrationId = registrationId;
    }

    @Basic
    @Column(name = "RoomID")
    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    @Basic
    @Column(name = "Seeker")
    public Boolean getSeeker() {
        return seeker;
    }

    public void setSeeker(Boolean seeker) {
        this.seeker = seeker;
    }

    @Basic
    @Column(name = "volunteerJobs")
    public String getVolunteerJobs() {
        return volunteerJobs;
    }

    public void setVolunteerJobs(String volunteerJobs) {
        this.volunteerJobs = volunteerJobs;
    }

    @Basic
    @Column(name = "Workshop")
    public Boolean getWorkshop() {
        return workshop;
    }

    public void setWorkshop(Boolean workshop) {
        this.workshop = workshop;
    }

    @Basic
    @Column(name = "Workshop1")
    public String getWorkshop1() {
        return workshop1;
    }

    public void setWorkshop1(String workshop1) {
        this.workshop1 = workshop1;
    }

    @Basic
    @Column(name = "Workshop2")
    public String getWorkshop2() {
        return workshop2;
    }

    public void setWorkshop2(String workshop2) {
        this.workshop2 = workshop2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProfileEntity that = (ProfileEntity) o;
        return personId == that.personId &&
                familyId == that.familyId &&
                Objects.equals(archive, that.archive) &&
                Objects.equals(checkIn, that.checkIn) &&
                Objects.equals(checkInDate, that.checkInDate) &&
                Objects.equals(checkOut, that.checkOut) &&
                Objects.equals(checkOutDate, that.checkOutDate) &&
                Objects.equals(churchId, that.churchId) &&
                Objects.equals(churchName, that.churchName) &&
                Objects.equals(comments, that.comments) &&
                Objects.equals(decision, that.decision) &&
                Objects.equals(faithYear, that.faithYear) &&
                Objects.equals(groupId, that.groupId) &&
                Objects.equals(lastModified, that.lastModified) &&
                Objects.equals(leader, that.leader) &&
                Objects.equals(nametag, that.nametag) &&
                Objects.equals(needHotel, that.needHotel) &&
                Objects.equals(needTranspotation, that.needTranspotation) &&
                Objects.equals(preferredLanguage, that.preferredLanguage) &&
                Objects.equals(registeredDate, that.registeredDate) &&
                Objects.equals(registrationId, that.registrationId) &&
                Objects.equals(roomId, that.roomId) &&
                Objects.equals(seeker, that.seeker) &&
                Objects.equals(volunteerJobs, that.volunteerJobs) &&
                Objects.equals(workshop, that.workshop) &&
                Objects.equals(workshop1, that.workshop1) &&
                Objects.equals(workshop2, that.workshop2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(personId, archive, checkIn, checkInDate, checkOut, checkOutDate, churchId, churchName, comments, decision, faithYear, familyId, groupId, lastModified, leader, nametag, needHotel, needTranspotation, preferredLanguage, registeredDate, registrationId, roomId, seeker, volunteerJobs, workshop, workshop1, workshop2);
    }
}
