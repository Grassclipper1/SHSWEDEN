package com.example.SHSWEDEN.Entities;


import javax.persistence.*;

@Entity
public class Purchase {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    Integer id;

    String itemName;

    Integer sellerId;

    Integer buyerId;

    Integer price;

    Long donationSum;

    public Purchase(){}

    public Purchase(String itemName, Integer sellerId, Integer buyerId, Integer price, Integer donationSum) {
        this.itemName = itemName;
        this.sellerId = sellerId;
        this.buyerId = buyerId;
        this.price = price;
        this.donationSum = Long.valueOf(donationSum);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Integer getSellerId() {
        return sellerId;
    }

    public void setSellerId(Integer sellerId) {
        this.sellerId = sellerId;
    }

    public Integer getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Integer buyerId) {
        this.buyerId = buyerId;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Long getDonationSum() {
        return donationSum;
    }

    public void setDonationSum(Long donationSum) {
        this.donationSum = donationSum;
    }
}
