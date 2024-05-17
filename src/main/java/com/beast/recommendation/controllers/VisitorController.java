package com.beast.recommendation.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VisitorController {

    @GetMapping("/visitorwelcomescreen")
    public String showWelcomeScrenn() {
        // System.out.println("I am in the controller");
        return "index";
    }
}
