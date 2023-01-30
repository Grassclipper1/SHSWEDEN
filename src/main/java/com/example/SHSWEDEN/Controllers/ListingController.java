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
import java.util.Date;
import java.util.List;

@Controller
public class ListingController {
    private static final int PAGE_SIZE = 10;
    @Autowired
    private ListingService listingService;
    @Autowired
    private UserService userService;
    @Autowired
    private CategoryService categoryService;

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
        ListingObj listingObj = listingService.getListing(id);
        model.addAttribute("page", page);
        model.addAttribute("listing", listingObj.getListing());
        model.addAttribute("seller", listingObj.getSeller());

        return "oneListing";
    }


    @GetMapping("/createListing")
    String createListing(HttpSession session, Model model) {
        Integer id = (Integer) session.getAttribute("userId");

        List<Category> categories = categoryService.findByParentId(0);
        model.addAttribute("categories", categories);

        if (id != null) {
            Listing listing = new Listing();
            listing.setSeller(id);
            listing.setDate(String.valueOf(new Date()));
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



    private int[] toArray(int num) {
        int[] result = new int[num];
        for (int i = 0; i < num; i++) {
            result[i] = i+1;
        }
        return result;
    }
    private List<Listing> getPage(int page, int pageSize) {
        List<Listing> listings = (List<Listing>) listingService.findAll();
        int from = Math.max(0,page*pageSize);
        int to = Math.min(listings.size(),(page+1)*pageSize);

        return listings.subList(from, to);
    }
    private int numberOfPages(int pageSize) {
        List<Listing> listings = (List<Listing>) listingService.findAll();
        return (int)Math.ceil((listings.size()) / pageSize);
    }

}
