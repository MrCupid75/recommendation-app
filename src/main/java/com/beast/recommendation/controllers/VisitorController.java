package com.beast.recommendation.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.beast.recommendation.models.VisitorTModel;
import com.beast.recommendation.services.VisitorService;

import jakarta.validation.Valid;

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

    @GetMapping("/registrationviewpage")
    public String showRegistration(@ModelAttribute("visitorObject") VisitorTModel visitors) {
        return "registerVisitor";
    }

    @PostMapping("/register")
    public String registerVisitor(@Valid @ModelAttribute("visitorObject") 
            VisitorTModel newVisitor, BindingResult result) {
        if (result.hasErrors()) {
            return "registerVisitor";
        }
        visitorService.createUser(newVisitor);
        return "redirect:/visitors";
    }

    @GetMapping("/editview/{id}")
    public String viewVisitorById(@PathVariable("id") Long id, Model model) {
        VisitorTModel aVisitor = visitorService.getVisitbyId(id);
        model.addAttribute("aSingleVisitor", aVisitor);
        return "editView";
    }

    @PostMapping("/edit/{id}")
    public String editVisitor(@PathVariable("id") Long id, @Valid @ModelAttribute("aSingleVisitor") 
            VisitorTModel updatedVisitor, BindingResult result) {
                if(result.hasErrors()) {
                    return "editView";
                }
                visitorService.updateVisitor(updatedVisitor);
                return "redirect:/visitors";
            }

            @PostMapping("/remove/{id}")
            public String removeVisitor(@PathVariable("id") Long id) {
                visitorService.deletebyID(id);
                return "redirect:/visitors";
            }
}
