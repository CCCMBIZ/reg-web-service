package com.cccmbiz.web;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "person", schema = "cccmdb1", catalog = "")
public class Person {
    private int personId;
    private Boolean acceptedChrist;
    private Timestamp acceptedChristDate;
    private Integer acceptedChristLocation;
    private String age;
    private String allergies;
    private Boolean baptized;
    private Timestamp baptizedDate;
    private Double cellPhone;
    private String chineseName;
    private Boolean churchAdmin;
    private Integer churchId;
    private String commitServe;
    private String email;
    private Boolean familyAdmin;
    private Integer familyId;
    private String firstName;
    private String gender;
    private String headphone;
    private String healthCardNo;
    private Timestamp lastModified;
    private String lastName;
    private String loginId;
    private String misc1;
    private String misc2;
    private String misc3;
    private String password;
    private String phone;
    private String prc;
    private String preferredLanguage;
    private String relationship;
    private String remarks;
    private Boolean searchable;
    private Boolean seeker;
    private String servingRole;
    private String status;
    private String title;
    private Integer volunteerCode;
    private Boolean willingToAttendCccmTraining;
    private Boolean willingToBeVolunteer;
    private Double workPhone;

    @Id
    @Column(name = "PersonID")
    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    @Basic
    @Column(name = "AcceptedChrist")
    public Boolean getAcceptedChrist() {
        return acceptedChrist;
    }

    public void setAcceptedChrist(Boolean acceptedChrist) {
        this.acceptedChrist = acceptedChrist;
    }


    @Basic
    @Column(name = "AcceptedChristDate")
    public Timestamp getAcceptedChristDate() {
        return acceptedChristDate;
    }

    public void setAcceptedChristDate(Timestamp acceptedChristDate) {
        this.acceptedChristDate = acceptedChristDate;
    }

    @Basic
    @Column(name = "AcceptedChristLocation")
    public Integer getAcceptedChristLocation() {
        return acceptedChristLocation;
    }

    public void setAcceptedChristLocation(Integer acceptedChristLocation) {
        this.acceptedChristLocation = acceptedChristLocation;
    }

    @Basic
    @Column(name = "Age")
    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Basic
    @Column(name = "allergies")
    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    @Basic
    @Column(name = "Baptized")
    public Boolean getBaptized() {
        return baptized;
    }

    public void setBaptized(Boolean baptized) {
        this.baptized = baptized;
    }

    @Basic
    @Column(name = "BaptizedDate")
    public Timestamp getBaptizedDate() {
        return baptizedDate;
    }

    public void setBaptizedDate(Timestamp baptizedDate) {
        this.baptizedDate = baptizedDate;
    }

    @Basic
    @Column(name = "CellPhone")
    public Double getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(Double cellPhone) {
        this.cellPhone = cellPhone;
    }

    @Basic
    @Column(name = "ChineseName")
    public String getChineseName() {
        return chineseName;
    }

    public void setChineseName(String chineseName) {
        this.chineseName = chineseName;
    }

    @Basic
    @Column(name = "ChurchAdmin")
    public Boolean getChurchAdmin() {
        return churchAdmin;
    }

    public void setChurchAdmin(Boolean churchAdmin) {
        this.churchAdmin = churchAdmin;
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
    @Column(name = "CommitServe")
    public String getCommitServe() {
        return commitServe;
    }

    public void setCommitServe(String commitServe) {
        this.commitServe = commitServe;
    }

    @Basic
    @Column(name = "Email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "FamilyAdmin")
    public Boolean getFamilyAdmin() {
        return familyAdmin;
    }

    public void setFamilyAdmin(Boolean familyAdmin) {
        this.familyAdmin = familyAdmin;
    }

    @Basic
    @Column(name = "FamilyID")
    public Integer getFamilyId() {
        return familyId;
    }

    public void setFamilyId(Integer familyId) {
        this.familyId = familyId;
    }

    @Basic
    @Column(name = "FirstName")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "Gender")
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Basic
    @Column(name = "headphone")
    public String getHeadphone() {
        return headphone;
    }

    public void setHeadphone(String headphone) {
        this.headphone = headphone;
    }

    @Basic
    @Column(name = "healthCardNo")
    public String getHealthCardNo() {
        return healthCardNo;
    }

    public void setHealthCardNo(String healthCardNo) {
        this.healthCardNo = healthCardNo;
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
    @Column(name = "LastName")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "LoginID")
    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
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
    @Column(name = "Password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "Phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "PRC")
    public String getPrc() {
        return prc;
    }

    public void setPrc(String prc) {
        this.prc = prc;
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
    @Column(name = "Relationship")
    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    @Basic
    @Column(name = "Remarks")
    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Basic
    @Column(name = "Searchable")
    public Boolean getSearchable() {
        return searchable;
    }

    public void setSearchable(Boolean searchable) {
        this.searchable = searchable;
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
    @Column(name = "ServingRole")
    public String getServingRole() {
        return servingRole;
    }

    public void setServingRole(String servingRole) {
        this.servingRole = servingRole;
    }

    @Basic
    @Column(name = "Status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "Title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "VolunteerCode")
    public Integer getVolunteerCode() {
        return volunteerCode;
    }

    public void setVolunteerCode(Integer volunteerCode) {
        this.volunteerCode = volunteerCode;
    }

    @Basic
    @Column(name = "WillingToAttendCCCMTraining")
    public Boolean getWillingToAttendCccmTraining() {
        return willingToAttendCccmTraining;
    }

    public void setWillingToAttendCccmTraining(Boolean willingToAttendCccmTraining) {
        this.willingToAttendCccmTraining = willingToAttendCccmTraining;
    }

    @Basic
    @Column(name = "WillingToBeVolunteer")
    public Boolean getWillingToBeVolunteer() {
        return willingToBeVolunteer;
    }

    public void setWillingToBeVolunteer(Boolean willingToBeVolunteer) {
        this.willingToBeVolunteer = willingToBeVolunteer;
    }

    @Basic
    @Column(name = "WorkPhone")
    public Double getWorkPhone() {
        return workPhone;
    }

    public void setWorkPhone(Double workPhone) {
        this.workPhone = workPhone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person that = (Person) o;
        return personId == that.personId &&
                Objects.equals(acceptedChrist, that.acceptedChrist) &&
                Objects.equals(acceptedChristDate, that.acceptedChristDate) &&
                Objects.equals(acceptedChristLocation, that.acceptedChristLocation) &&
                Objects.equals(age, that.age) &&
                Objects.equals(allergies, that.allergies) &&
                Objects.equals(baptized, that.baptized) &&
                Objects.equals(baptizedDate, that.baptizedDate) &&
                Objects.equals(cellPhone, that.cellPhone) &&
                Objects.equals(chineseName, that.chineseName) &&
                Objects.equals(churchAdmin, that.churchAdmin) &&
                Objects.equals(churchId, that.churchId) &&
                Objects.equals(commitServe, that.commitServe) &&
                Objects.equals(email, that.email) &&
                Objects.equals(familyAdmin, that.familyAdmin) &&
                Objects.equals(familyId, that.familyId) &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(gender, that.gender) &&
                Objects.equals(headphone, that.headphone) &&
                Objects.equals(healthCardNo, that.healthCardNo) &&
                Objects.equals(lastModified, that.lastModified) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(loginId, that.loginId) &&
                Objects.equals(misc1, that.misc1) &&
                Objects.equals(misc2, that.misc2) &&
                Objects.equals(misc3, that.misc3) &&
                Objects.equals(password, that.password) &&
                Objects.equals(phone, that.phone) &&
                Objects.equals(prc, that.prc) &&
                Objects.equals(preferredLanguage, that.preferredLanguage) &&
                Objects.equals(relationship, that.relationship) &&
                Objects.equals(remarks, that.remarks) &&
                Objects.equals(searchable, that.searchable) &&
                Objects.equals(seeker, that.seeker) &&
                Objects.equals(servingRole, that.servingRole) &&
                Objects.equals(status, that.status) &&
                Objects.equals(title, that.title) &&
                Objects.equals(volunteerCode, that.volunteerCode) &&
                Objects.equals(willingToAttendCccmTraining, that.willingToAttendCccmTraining) &&
                Objects.equals(willingToBeVolunteer, that.willingToBeVolunteer) &&
                Objects.equals(workPhone, that.workPhone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(personId, acceptedChrist, acceptedChristDate, acceptedChristLocation, age, allergies, baptized, baptizedDate, cellPhone, chineseName, churchAdmin, churchId, commitServe, email, familyAdmin, familyId, firstName, gender, headphone, healthCardNo, lastModified, lastName, loginId, misc1, misc2, misc3, password, phone, prc, preferredLanguage, relationship, remarks, searchable, seeker, servingRole, status, title, volunteerCode, willingToAttendCccmTraining, willingToBeVolunteer, workPhone);
    }
}
