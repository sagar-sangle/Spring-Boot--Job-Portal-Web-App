package com.dev.JobPortal.entity;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "job_seeker_profile")
public class JobSeekerProfile {

    @Id
    private int userAccountId;


    @OneToOne
    @JoinColumn(name = "user_account_id")
    @MapsId
    private Users userId;
    private String city;

    private String country;
    private String state;

    @Column(length = 64,nullable = true)
    private String profilePhoto;


    private  String employmentType;


    private String firstName;

    private String lastName;
    private String resume;

    private String workAuthorization;

    @OneToMany(targetEntity = Skills.class,cascade = CascadeType.ALL,mappedBy = "jobSeekerProfile")
    private List<Skills> skills;

    public JobSeekerProfile() {
    }

    public JobSeekerProfile(Users userId) {
        this.userId = userId;
    }

    public JobSeekerProfile(int userAccountId, Users userId, String city, String country, String state, String profilePhoto, String employmentType, String firstName, String lastName, String resume, String workAuthorization, List<Skills> skills) {
        this.userAccountId = userAccountId;
        this.userId = userId;
        this.city = city;
        this.country = country;
        this.state = state;
        this.profilePhoto = profilePhoto;
        this.employmentType = employmentType;
        this.firstName = firstName;
        this.lastName = lastName;
        this.resume = resume;
        this.workAuthorization = workAuthorization;
        this.skills = skills;
    }

    public int getUserAccountId() {
        return userAccountId;
    }

    public void setUserAccountId(int userAccountId) {
        this.userAccountId = userAccountId;
    }

    public Users getUserId() {
        return userId;
    }

    public void setUserId(Users userId) {
        this.userId = userId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhoto(String profilePhoto) {
        this.profilePhoto = profilePhoto;
    }

    public String getEmploymentType() {
        return employmentType;
    }

    public void setEmploymentType(String employmentType) {
        this.employmentType = employmentType;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public String getWorkAuthorization() {
        return workAuthorization;
    }

    public void setWorkAuthorization(String workAuthorization) {
        this.workAuthorization = workAuthorization;
    }

    public List<Skills> getSkills() {
        return skills;
    }

    public void setSkills(List<Skills> skills) {
        this.skills = skills;
    }

    @Override
    public String toString() {
        return "JobSeekerProfile{" +
                "userAccountId=" + userAccountId +
                ", userId=" + userId +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", state='" + state + '\'' +
                ", profilePhoto='" + profilePhoto + '\'' +
                ", employmentType='" + employmentType + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", resume='" + resume + '\'' +
                ", workAuthorization='" + workAuthorization + '\'' +
                ", skills=" + skills +
                '}';
    }
}
