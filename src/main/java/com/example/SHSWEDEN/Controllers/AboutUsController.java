package com.example.SHSWEDEN.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AboutUsController {

    @GetMapping("/about")
    public String about() {
        return "AboutUs";
    }
}

