package com.example.SHSWEDEN.Entities;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Entity
@Table(name = "\"USER\"")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private Integer id;

    @Size(max = 50)
    @NotNull
    @Column(name = "FirstName", nullable = false, length = 50)
    private String firstName;

    @Size(max = 50)
    @NotNull
    @Column(name = "LastName", nullable = false, length = 50)
    private String lastName;

    @Size(max = 50)
    @NotNull
    @Column(name = "UserName", nullable = false, length = 50)
    private String userName;

    @Size(max = 50)
    @NotNull
    @Column(name = "Password", nullable = false, length = 50)
    private String password;

    @Size(max = 50)
    @NotNull
    @Email
    @Column(name = "EmailAddress", nullable = false, length = 50)
    private String emailAddress;

    @Size(max = 50)
    @NotNull
    @Column(name = "StreetAddress", nullable = false, length = 50)
    private String streetAddress;

    @NotNull
//    @ManyToOne(fetch = FetchType.LAZY, optional = true)
//    @JoinColumn(name = "ZipId", nullable = false)
    @Column(name = "ZipId", nullable = false)
    private String zip;

    @Column(name = "DonationSum", precision = 18)
    private BigDecimal donationSum;

    public User() {
    }

    public User(String firstName, String lastName, String userName, String password, String emailAddress, String streetAddress, String zip) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.emailAddress = emailAddress;
        this.streetAddress = streetAddress;
        this.zip = zip;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public BigDecimal getDonationSum() {
        return donationSum;
    }

    public void setDonationSum(BigDecimal donationSum) {
        this.donationSum = donationSum;
    }

}