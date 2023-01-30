package com.example.SHSWEDEN.Controllers;

import com.example.SHSWEDEN.Entities.Category;
import com.example.SHSWEDEN.Entities.Listing;
import com.example.SHSWEDEN.Entities.User;
import com.example.SHSWEDEN.Repos.CategoryRepository;
import com.example.SHSWEDEN.Repos.ListingRepository;
import com.example.SHSWEDEN.Repos.UserRepository;
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
import java.util.HashMap;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    ListingRepository listingRepository;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    CategoryRepository categoryRepository;

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

    @PostMapping("/signin")
    String login(HttpSession session, @RequestParam String emailAddress, @RequestParam String password) {
        User user = userService.findByEmailAddressAndPassword(emailAddress, password);

        if(user != null && user.getPassword().equals(password)){
            session.setAttribute("userId", user.getId());
            session.setAttribute("user", user);
            return "ProfilePage";
        }
        return "signin";
    }


    @GetMapping("/ProfilePage")
    String ProfilePage() {
        return "ProfilePage";
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
        session.setAttribute("user",createdUser);
        return "account";
    }

    @GetMapping("/CheckoutPage")
    String checkout(HttpSession session, Model model) {
        int userId = (int)session.getAttribute("userId");
        User user = userService.findById(userId);
        model.addAttribute("user", user);
        return "CheckoutPage";
    }

    @GetMapping("/logout")
    String logout(HttpSession session) {
        session.removeAttribute("userId");
        session.removeAttribute("user");
        return "redirect:/";
    }
    @GetMapping("/account")  //använder denna för att ha åtkomst till account för tester
    String account(HttpSession session, Model model) {
        Integer id = (Integer) session.getAttribute("userId");
        if (id != null) {
            model.addAttribute("seller", id);
            return "account";
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

        /* private void sumOfPriceSubDonation() {
        List<Listing> listings = listingRepository.findAll();
        int totalDonation = 0;
        for(Listing listing : listings) {
            totalDonation += listing.getPrice() - (listing.getPrice() - ((listing.getDonationPercent() * listing.getPrice()) / 100));
        }
        System.out.println(totalDonation);
    }*/

    public int sumOfPriceSubDonation() {
        List<Listing> listings = listingRepository.findAll();
        int totalDonation = 0;
        for(Listing listing : listings) {
            totalDonation += listing.getPrice() - (listing.getPrice() - ((listing.getDonationPercent() * listing.getPrice()) / 100));
        }
        /*System.out.println(totalDonation);*/
        return totalDonation;
    }

    /* ----------------------- */

/*    @GetMapping("/")
    String startpage2(Model model) {
        model.addAttribute("sum", sumOfPriceSubDonation());
        model.getAttribute("sum");
        return "startpage";
    }*/


/*    @GetMapping("/")
    String landingPage() throws Exception {
        *//*sumOfPriceSubDonation();*//*
        if (!categoryRepository.existsById(1)) {
            CategoryMaker();
        }
        return "startpage";
    }*/




}
