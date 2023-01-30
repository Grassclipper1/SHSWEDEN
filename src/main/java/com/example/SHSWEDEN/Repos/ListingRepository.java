package com.example.SHSWEDEN.Repos;

import com.example.SHSWEDEN.Entities.Listing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ListingRepository extends JpaRepository<Listing, Integer> {


    @Query(value = "SELECT * FROM LISTING WHERE SELLER_ID = ?1", nativeQuery = true)
    List<Listing> getListingBySeller(String seller);

    @Query(value = "SELECT * FROM LISTING WHERE CATEGORY_ID = ?1", nativeQuery = true)
    List<Listing> getListingByCategory(String category);
}