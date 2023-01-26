package com.example.SHSWEDEN.Controllers;

import com.example.SHSWEDEN.Entities.User;
import com.example.SHSWEDEN.Repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class UserController {

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

//    @PostMapping("/signin")
//    String signinuser() {
//        return "ProfilePage";
//    }

    @GetMapping("/ProfilePage")
    String ProfilePage() {
        return "ProfilePage";
    }

    @GetMapping("/signup")
    String signup(Model model) {
        model.addAttribute("user", new User());
        return "signup";
    }

    @PostMapping("/signup")
    public String login(@Valid @ModelAttribute User user, BindingResult bindingResult, HttpSession session, Model model) {
        userRepository.save(user);
        if (bindingResult.hasErrors()) {
            System.out.println("error");
        }
        return "account";

    }

}
