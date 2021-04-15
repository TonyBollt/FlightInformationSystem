package com.flightsaccounting.controller;

import com.flightsaccounting.entity.Airline;
import com.flightsaccounting.service.AirlineService;
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
public class AirlineController {
    private final AirlineService airlineService;

    //@GetMapping({"/index/indexAirline"})
    //public String indexAirline(Model model) {
    //    return "airline/indexAirline";
    //}

    @GetMapping("/listAirline/create")
    public String showCreationForm(Model model) {
        Airline airline = new Airline();
        model.addAttribute("airline", airline);
        return "airline/createAirline";
    }

    @PostMapping("/listAirline/create")
    public String processCreationForm(@ModelAttribute("airline") @Valid Airline airline, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "airline/createAirline";
        }

        airlineService.createAirline(airline);
        return "redirect:/listAirline";
    }

    @GetMapping("/listAirline")
    public String getAirlines(Model model) {
        model.addAttribute("airlines", airlineService.findAll());
        return "airline/listAirline";
    }

    @GetMapping("/listAirline/update/{airlineCode}")
    public String showUpdateForm(@PathVariable("airlineCode") Integer airlineCode, Model model) {
        Optional<Airline> airline = airlineService.findAirlineById(airlineCode);
        model.addAttribute("airline", airline);
        return "airline/updateAirline";
    }

    @PostMapping("/listAirline/update")
    public String processUpdateForm(@Valid Airline airline, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "airline/updateAirline";
        }

        airlineService.updateAirline(airline);
        return "redirect:/listAirline";
    }

    @GetMapping("/listAirline/delete/{airlineCode}")
    public String deleteAirline(@PathVariable("airlineCode") Integer airlineCode) {
        airlineService.deleteAirlineById(airlineCode);
        return "redirect:/listAirline";
    }


}
