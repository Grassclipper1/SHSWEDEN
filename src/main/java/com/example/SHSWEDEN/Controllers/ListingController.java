package com.example.SHSWEDEN.Controllers;


import com.example.SHSWEDEN.Entities.Category;
import com.example.SHSWEDEN.Entities.Listing;
import com.example.SHSWEDEN.Entities.User;
import com.example.SHSWEDEN.Models.ListingObj;
import com.example.SHSWEDEN.Repos.ListingRepository;
import com.example.SHSWEDEN.Repos.UserRepository;
import com.example.SHSWEDEN.Services.CategoryService;
import com.example.SHSWEDEN.Services.ListingService;
import com.example.SHSWEDEN.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Controller
public class ListingController {

    @Autowired
    private ListingService listingService;
    @Autowired
    private UserService userService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    ListingRepository listingRepository;

    @GetMapping("/allListings")
    public String listings(Model model, @RequestParam(value = "seller", required = false, defaultValue = "0")
    int seller, @RequestParam(value = "category", required = false, defaultValue = "0")
    int category){
        List<Listing> listings = listingService.createListingList(seller, category);
        model.addAttribute("listings", listings);
        return "allListings";
    }

    @GetMapping("/oneListing/{id}")
    public String listing(Model model,  @PathVariable Integer id, HttpSession session) {
        ListingObj listingObj = listingService.getListing(id);
        model.addAttribute("listing", listingObj.getListing());
        model.addAttribute("seller", listingObj.getSeller());
        return "oneListing";
    }

    @PostMapping("/oneListing")
    public String listingPost(HttpSession session, @RequestParam Integer id) {
        Listing listing = listingRepository.getById(id);
        session.setAttribute("listing", listing);
        session.getAttribute("user");
        System.out.println(listing);
        return "CheckoutPage";
    }

    @GetMapping("/createListing")
    String createListing(HttpSession session, Model model) {
        Integer id = (Integer) session.getAttribute("userId");
        List<Category> categories = categoryService.findByParentId(0);
        model.addAttribute("categories", categories);
        if (id != null) {
            Listing listing = new Listing();
            listing.setSeller(id);
            listing.setDate(String.valueOf(LocalDate.now()));
            model.addAttribute("listing", listing);
            return "createListing";
        } else
            session.removeAttribute("userId");
        return "redirect:/allListings";
    }
    @RequestMapping(value = "/createListing/{parentId}", method = RequestMethod.GET)
    public @ResponseBody List<Category> subCategories(@PathVariable("parentId") Integer parentId){
        return this.categoryService.findByParentId(parentId);
    }
    @PostMapping("/createListing")
    String addedListing(@Valid Listing listing, HttpSession session, Model model, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            System.out.println("error");
            return "createListing";
        }
        listingService.save(listing);
        return "redirect:/allListings";
    }


}
