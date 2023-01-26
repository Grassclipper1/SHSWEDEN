package com.example.SHSWEDEN.Entities;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
public class Feedback {
    @Id
    @Column(name = "Id", nullable = false)
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Size(max = 100)
    @Column(name = "FeedbackMessage", length = 100)
    private String feedbackMessage;

    //    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "ListingId")
    @Column(name = "ListingId")
    private String listing;

    @Column(name = "Rating")
    private Integer rating;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFeedbackMessage() {
        return feedbackMessage;
    }

    public void setFeedbackMessage(String feedbackMessage) {
        this.feedbackMessage = feedbackMessage;
    }

    public String getListing() {
        return listing;
    }

    public void setListing(String listing) {
        this.listing = listing;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

}