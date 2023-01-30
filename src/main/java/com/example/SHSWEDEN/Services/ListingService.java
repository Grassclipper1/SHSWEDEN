package com.example.SHSWEDEN.Services;

import com.example.SHSWEDEN.Entities.Listing;
import com.example.SHSWEDEN.Entities.User;
import com.example.SHSWEDEN.Models.ListingObj;
import com.example.SHSWEDEN.Repos.ListingRepository;
import com.example.SHSWEDEN.Repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListingService {

    @Autowired
    ListingRepository listingRepository;

     @Autowired
    UserRepository userRepository;

    public ListingObj getListing(Integer id) {

        Listing listing = listingRepository.findById(id).get();
        int sellerId = listing.getSeller();
        User user = userRepository.findById(sellerId).orElse(null);


        return new ListingObj(user, listing);
    }

    public void save(Listing listing){
        listingRepository.save(listing);
    }

    public List<Listing> findAll(){
        return listingRepository.findAll();
    }


}
