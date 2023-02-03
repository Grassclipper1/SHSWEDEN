package com.example.SHSWEDEN.Controllers;

import com.example.SHSWEDEN.Entities.*;
import com.example.SHSWEDEN.Repos.*;
import com.example.SHSWEDEN.Services.ListingService;
import com.example.SHSWEDEN.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;


import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    ListingRepository listingRepository;

    @Autowired
    ListingService listingService;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    PurchaseRepository purchaseRepository;
    @Autowired
    DonationRepository donationRepository;

    @GetMapping("/")
    String landingPage(Model model) throws Exception {
        model.addAttribute("sumOfDonations", sumOfPriceSubDonation());
        model.getAttribute("sumOfDonations");
        /*sumOfPriceSubDonation();*/
        if (!categoryRepository.existsById(1)) {
            CategoryMaker();
        }
        return "startpage";
    }

    @GetMapping("/signin")
    String signin() {
        return "signin";
    }

    @PostMapping("/signin") //checks so user exist with correct password, and creates sessions.
    String login(HttpSession session, Model model, @RequestParam String emailAddress, @RequestParam String password) {
        User user = userService.findByEmailAddressAndPassword(emailAddress, password);
        if(user != null && user.getPassword().equals(password)){
            session.setAttribute("userId", user.getId());
            session.setAttribute("seller", user.getId());
            session.setAttribute("user", user);
            List<Listing> listings = listingService.findByUser(user.getId());
            model.addAttribute("listings", listings);
            return "ProfilePage";
        }
        return "signin";
    }


    @GetMapping("/signup")
    String signup(Model model, HttpSession session) {
        Integer id = (Integer) session.getAttribute("userId");
        if (id != null) {
            return "ProfilePage";
        } else
            session.removeAttribute("userId");
        model.addAttribute("user", new User());
        return "signup";
    }

    @PostMapping("/signup")
    public String login(@Valid User user, BindingResult bindingResult, HttpSession session, Model model) {
        if (bindingResult.hasErrors()) {
            System.out.println("error");
        }
        User createdUser = userRepository.save(user);
        session.setAttribute("userId", createdUser.getId());
        session.setAttribute("seller", createdUser.getId());
        session.setAttribute("user", createdUser);
        return "ProfilePage";
    }

    @GetMapping("/CheckoutPage")
    String checkout(HttpSession session, Model model) {
        Integer userId = (Integer) session.getAttribute("userId");
        Listing listing = (Listing) session.getAttribute("listing");
        if (listing != null){
        User user = userService.findById(userId);
        model.addAttribute("user", user);
        session.getAttribute("listing");
        model.addAttribute(listing);
        return "CheckoutPage";
        }
        else
            session.removeAttribute("listing");
        return "redirect:/";
    }

    //removes the listing you bought from database, and creates a purchase object to track the buy, and a donation object
    @PostMapping ("/CheckoutPage")
    String checkoutPost(HttpSession session, Model model){
        Listing listing = (Listing) session.getAttribute("listing");
        if (listing != null){
            User user = (User) session.getAttribute("user");
            System.out.println("success");
            Purchase purchase = new Purchase(listing.getTitle(), listing.getSeller(), user.getId(), listing.getPrice(), listing.getDonationPercent());
            purchaseRepository.save(purchase);
            Donation donation = new Donation(listing.getDonation(), listingService.purchaseDonation(listing.getPrice(), listing.getDonationPercent()), purchase.getId());
            listingRepository.delete(listing);
            donationRepository.save(donation);
            session.removeAttribute("listing");
            return "redirect:/";
        }else
            System.out.println("fail");
            return "CheckoutPage";
    }

    @GetMapping("/logout") //removes all the sessions so that you can log in as new user.
    String logout(HttpSession session) {
        session.removeAttribute("userId");
        session.removeAttribute("user");
        session.removeAttribute("seller");
        session.removeAttribute("listing");
        return "redirect:/";
    }
   @GetMapping("/ProfilePage")  //använder denna för att ha åtkomst till account för tester
    String ProfilePage(HttpSession session, Model model) {
        Integer id = (Integer) session.getAttribute("userId");

        if (id != null) {

            List<Listing> listings = listingService.findByUser(id);
            model.addAttribute("listings", listings);
            model.addAttribute("seller", id);

            return "ProfilePage";
        } else
            session.removeAttribute("userId");
        return "redirect:/";
    }

    public void CategoryMaker() throws Exception {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document document = db.parse(new File("TraderaCategories.xml"));
        NodeList nodeList = document.getElementsByTagName("Category");

        HashMap<String, Integer> nameIdMap = new HashMap<>();

        for (int x = 0; x < nodeList.getLength(); x++) {
            Category category = new Category();
            category.setName(nodeList.item(x).getAttributes().getNamedItem("Name").getNodeValue());

            nameIdMap.put(category.getName(), x + 1);

            if (nodeList.item(x).getParentNode().getAttributes().getNamedItem("Name") != null) {
                category.setParentId(nameIdMap.get(nodeList.item(x).getParentNode().getAttributes().getNamedItem("Name").getNodeValue()));
            } else {
                category.setParentId(0);
            }
            categoryRepository.save(category);
        }
    }

    public int sumOfPriceSubDonation() {
        List<Purchase> purchases = purchaseRepository.findAll();
        int totalDonation = 0;
        for(Purchase purchase : purchases) {
            totalDonation += purchase.getPrice() - (purchase.getPrice() - ((purchase.getDonationSum() * purchase.getPrice()) / 100));
        }
        return totalDonation;
    }

    @GetMapping("/blog")
    String Blog() {
        return "blog";
    }


}
