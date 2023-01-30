package com.example.SHSWEDEN.Models;

import com.example.SHSWEDEN.Entities.User;

public class ListingObj {
    com.example.SHSWEDEN.Entities.Listing listing;
    User seller;

    public com.example.SHSWEDEN.Entities.Listing getListing() {
        return listing;
    }

    public void setListing(com.example.SHSWEDEN.Entities.Listing listing) {
        this.listing = listing;
    }

    public User getSeller() {
        return seller;
    }

    public void setSeller(User seller) {
        this.seller = seller;
    }

    public ListingObj(User seller, com.example.SHSWEDEN.Entities.Listing listing){
        this.listing = listing;
        this.seller = seller;


    }
}
