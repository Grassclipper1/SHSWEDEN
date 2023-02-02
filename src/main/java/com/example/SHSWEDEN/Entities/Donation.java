package com.example.SHSWEDEN.Entities;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Entity
public class Donation {
    @Id
    @Column(name = "Id", nullable = false)
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "NameOrganisation", nullable = true, length = 50)
    private String nameOrganisation;

    int donationSum;

    int purchaseId;

    public Donation(String donation, int i, int purchaseId) {
        this.nameOrganisation = donation;
        this.donationSum = i;
        this.purchaseId = purchaseId;
    }

//    @Size(max = 200)
//    @NotNull
//    @Column(name = "Description", nullable = false, length = 200)
//    private String description;





    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameOrganisation() {
        return nameOrganisation;
    }

    public void setNameOrganisation(String nameOrganisation) {
        this.nameOrganisation = nameOrganisation;
    }

    public int getDonationSum() {
        return donationSum;
    }

    public void setDonationSum(int donationSum) {
        this.donationSum = donationSum;
    }

    public int getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(int purchaseId) {
        this.purchaseId = purchaseId;
    }
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }

}