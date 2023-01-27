package com.example.SHSWEDEN.Controllers;

import com.example.SHSWEDEN.Entities.Listing;
import com.example.SHSWEDEN.Entities.User;
import com.example.SHSWEDEN.Repos.UserRepository;
import com.example.SHSWEDEN.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    String landingPage() {
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
        return "redirect:/";
    }
    @GetMapping("/account")  //använder denna för att ha åtkomst till account för tester
    String account(HttpSession session) {
        Integer id = (Integer) session.getAttribute("userId");
        if (id != null) {
            return "account";
        } else
            session.removeAttribute("userId");
        return "redirect:/";
    }


}
