package com.flightsaccounting.controller;

import com.flightsaccounting.entity.GroundHandling;
import com.flightsaccounting.service.GroundHandlingService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@AllArgsConstructor
public class GroundHandlingController {

    private final GroundHandlingService groundHandlingService;

    @GetMapping("/listGroundHandling/create")
    public String showCreationForm(Model model) {
        GroundHandling groundHandling = new GroundHandling();
        model.addAttribute("groundHandling", groundHandling);
        return "groundHandling/createGroundHandling";
    }

    @PostMapping("/listGroundHandling/create")
    public String processCreationForm(@Valid GroundHandling groundHandling, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "groundHandling/createGroundHandling";
        }

        groundHandlingService.createGroundHandling(groundHandling);
        return "redirect:/listGroundHandling";
    }

    @GetMapping("/listGroundHandling")
    public String getGroundHandlings(Model model) {
        model.addAttribute("groundHandlings", groundHandlingService.findAll());
        return "groundHandling/listGroundHandling";
    }

    @GetMapping("/listGroundHandling/update/{ghCode}")
    public String showUpdateForm(@PathVariable("ghCode") Integer ghCode, Model model) {
        Optional<GroundHandling> groundHandling = groundHandlingService.findGroundHandlingById(ghCode);
        model.addAttribute("groundHandling", groundHandling);
        return "groundHandling/updateGroundHandling";
    }

    @PostMapping("/listGroundHandling/update")
    public String processUpdateForm(@Valid @ModelAttribute("groundHandling") GroundHandling groundHandling, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "groundHandling/updateGroundHandling";
        }

        groundHandlingService.updateGroundHandling(groundHandling);
        return "redirect:/listGroundHandling";
    }

    @GetMapping("/listGroundHandling/delete/{ghCode}")
    public String deleteGroundHandling(@PathVariable("ghCode") Integer ghCode) {
        groundHandlingService.deleteGroundHandlingById(ghCode);
        return "redirect:/listGroundHandling";
    }

}
