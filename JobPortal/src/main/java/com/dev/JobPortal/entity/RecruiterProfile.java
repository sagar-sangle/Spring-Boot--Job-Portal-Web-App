package com.dev.JobPortal.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "recruiter_profile")
public class RecruiterProfile {

    @Id
    private int userAccountId;

    @OneToOne
    @JoinColumn(name = "user_account_id")
    @MapsId
    private Users userId;
    private String city;

    private String country;
    private String state;

    @Column(nullable = true,length = 64)
    private String profilePhoto;


    private String company;

    private String firstName;

    private String lastName;



    public RecruiterProfile() {
    }

    public RecruiterProfile(Users userId) {
        this.userId = userId;
    }

    public RecruiterProfile(int userAccountId, String city, String country, String state, String profilePhoto, String company, String firstName, String lastName) {
        this.userAccountId = userAccountId;
        this.city = city;
        this.country = country;
        this.state = state;
        this.profilePhoto = profilePhoto;
        this.company = company;
        this.firstName = firstName;
        this.lastName = lastName;

    }



    public int getUserAccountId() {
        return userAccountId;
    }

    public void setUserAccountId(int userAccountId) {
        this.userAccountId = userAccountId;
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

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
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

    @Override
    public String toString() {
        return "RecruiterProfile{" +
                "userAccountId=" + userAccountId +
                ", userId=" + userId +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", state='" + state + '\'' +
                ", profilePhoto='" + profilePhoto + '\'' +
                ", company='" + company + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
