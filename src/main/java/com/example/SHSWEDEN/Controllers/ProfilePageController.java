package com.example.SHSWEDEN.Controllers;


import com.example.SHSWEDEN.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

public class ProfilePageController {

    @Controller
    @RequestMapping("/profile")
    public class ProfileController {

        @Autowired
        private UserService userService;

//        @GetMapping("/{username}")
//        public String getProfile(@PathVariable String username, Model model) {
//            User user = userService.findByUserName(username);
//            model.addAttribute("user", user);
//            return "profile";
//        }
    }

}