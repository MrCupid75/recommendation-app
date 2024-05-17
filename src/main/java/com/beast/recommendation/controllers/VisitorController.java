package com.beast.recommendation.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.beast.recommendation.models.VisitorTModel;
import com.beast.recommendation.services.VisitorService;

@Controller
public class VisitorController {

    private VisitorService visitorService;

    public VisitorController(VisitorService initialVisitorService) {
        this.visitorService = initialVisitorService;
    }

    @GetMapping("/visitorwelcomescreen")
    public String showWelcomeScrenn() {
        // System.out.println("I am in the controller");
        return "index";
    }

    @GetMapping("/visitors")
    public String showVisitors(Model model) {
        model.addAttribute("ListofVisitors", visitorService.showAllUsers());
        return "viewVisitors";
    }

    @GetMapping("/registration")
    public String showRegistration(@ModelAttribute("visitorObject") VisitorTModel visitors) {
        return "registerVisitor";
    }
}
