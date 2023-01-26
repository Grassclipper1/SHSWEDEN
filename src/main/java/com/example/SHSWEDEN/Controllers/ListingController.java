package com.example.SHSWEDEN.Controllers;


import com.example.SHSWEDEN.Entities.Listing;
import com.example.SHSWEDEN.Repos.ListingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ListingController {
    private static final int PAGE_SIZE = 10;
    @Autowired
    private ListingRepository listingRepository;

    @GetMapping("/allListings")
    public String listings(Model model, @RequestParam(value="page", required=false, defaultValue="1") int page) {

        List<Listing> listings = getPage(page-1, PAGE_SIZE);
        int pageCount = numberOfPages(PAGE_SIZE);
        int[] pages = toArray(pageCount);

        model.addAttribute("listings", listings);
        model.addAttribute("pages", pages);
        model.addAttribute("currentPage", page);
        model.addAttribute("showPrev", page > 1);
        model.addAttribute("showNext", page < pageCount);

        return "allListings";
    }

    @GetMapping("/oneListing/{page}/{id}")
    public String listing(Model model, @PathVariable Integer page, @PathVariable Integer id) {
        Listing listing = listingRepository.findById(id).get();
        model.addAttribute("page", page);
        model.addAttribute("listing", listing);

        return "oneListing";
    }


    @GetMapping("/createListing")
    String createListing(Model model) {
        model.addAttribute("listing", new Listing());
        return "createListing";
    }


    @PostMapping("/createListing")
    String addedListing(@ModelAttribute Listing listing){
        listingRepository.save(listing);
        return "redirect:/allListings";
    }



    private int[] toArray(int num) {
        int[] result = new int[num];
        for (int i = 0; i < num; i++) {
            result[i] = i+1;
        }
        return result;
    }
    private List<Listing> getPage(int page, int pageSize) {
        List<Listing> listings = (List<Listing>) listingRepository.findAll();
        int from = Math.max(0,page*pageSize);
        int to = Math.min(listings.size(),(page+1)*pageSize);

        return listings.subList(from, to);
    }
    private int numberOfPages(int pageSize) {
        List<Listing> listings = (List<Listing>) listingRepository.findAll();
        return (int)Math.ceil((listings.size()) / pageSize);
    }

}
