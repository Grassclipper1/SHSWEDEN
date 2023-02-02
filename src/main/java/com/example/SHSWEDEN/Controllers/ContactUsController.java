package com.example.SHSWEDEN.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ContactUsController {
    @GetMapping("/contact")
    public ModelAndView showContactForm() {
        return new ModelAndView("ContactUs");
    }

    @PostMapping("/contact")
    public ModelAndView submitContactForm(@RequestParam("name") String name, @RequestParam("email") String email, @RequestParam("message") String message) {


        return new ModelAndView("contact-success");
    }
}