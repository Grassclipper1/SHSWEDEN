package com.example.SHSWEDEN.Entities;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.Instant;

@Entity
public class Listing {
    @Id
    @Column(name = "Id", nullable = false)
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Size(max = 50)
    @NotNull
    @Column(name = "Title", nullable = false, length = 50)
    private String title;

    @Size(max = 50)
    @NotNull
    @Column(name = "Description", nullable = false, length = 50)
    private String description;

    @Column(name = "Price", nullable = false, precision = 18)
    private Integer price;

    @Column(name = "Image")
    private Integer image;

    //    @NotNull
    @Column(name = "\"Date\"", nullable = true)
    private Instant date;

    //    @NotNull
//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "SellerId", nullable = false)
    @Column(name = "SellerId", nullable = true)
    private String seller;

    //    @NotNull
//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "CategoryId", nullable = false)
    @Column(name = "CategoryId", nullable = true)
    private String category;

    @Column(name = "ShippingCost", precision = 18)
    private Integer shippingCost;

    @NotNull
    @Column(name = "DonationPercent", nullable = false)
    private Integer donationPercent;

    //    @NotNull
//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "DonationId", nullable = false)
    @Column(name = "DonationId", nullable = true)
    private String donation;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getImage() {
        return image;
    }

    public void setImage(Integer image) {
        this.image = image;
    }

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getShippingCost() {
        return shippingCost;
    }

    public void setShippingCost(Integer shippingCost) {
        this.shippingCost = shippingCost;
    }

    public Integer getDonationPercent() {
        return donationPercent;
    }

    public void setDonationPercent(Integer donationPercent) {
        this.donationPercent = donationPercent;
    }

    public String getDonation() {
        return donation;
    }

    public void setDonation(String donation) {
        this.donation = donation;
    }

}