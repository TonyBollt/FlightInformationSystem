package com.flightsaccounting.controller;

import com.flightsaccounting.entity.CurrentFlight;
import com.flightsaccounting.service.AirplaneService;
import com.flightsaccounting.service.CurrentFlightService;
import com.flightsaccounting.service.FlightService;
import com.flightsaccounting.service.RunwayService;
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
public class CurrentFlightController {
    private final CurrentFlightService currentFlightService;
    private final FlightService flightService;
    private final AirplaneService airplaneService;
    private final RunwayService runwayService;

    @GetMapping("/listCurrentFlight/create")
    public String showCreationForm(Model model) {
        CurrentFlight currentFlight = new CurrentFlight();
        model.addAttribute("currentFlight", currentFlight);
        model.addAttribute("flights", flightService.findAll());
        model.addAttribute("airplanes", airplaneService.findAll());
        model.addAttribute("runways", runwayService.findAll());
        return "currentFlight/createCurrentFlight";
    }

    @PostMapping("/listCurrentFlight/create")
    public String processCreationForm(@Valid @ModelAttribute("currentFlight") CurrentFlight currentFlight, BindingResult bindingResult,
                                      Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("currentFlight", currentFlight);
            model.addAttribute("flights", flightService.findAll());
            model.addAttribute("airplanes", airplaneService.findAll());
            model.addAttribute("runways", runwayService.findAll());
            return "currentFlight/createCurrentFlight";
        }

        currentFlightService.createCurrentFlight(currentFlight);
        return "redirect:/listCurrentFlight";
    }

    @GetMapping("/listCurrentFlight")
    public String getCurrentFlights(Model model) {
        model.addAttribute("currentFlights", currentFlightService.findAllByOrderByDepDateDesc());
        //model.addAttribute("currentFlights", currentFlightService.findAll());
        return "currentFlight/listCurrentFlight";
    }

    @GetMapping("/listCurrentFlight/update/{cfId}")
    public String showUpdateForm(@PathVariable(value = "cfId") Integer cfId, Model model) {
        Optional<CurrentFlight> currentFlight = currentFlightService.findCurrentFlightById(cfId);
        model.addAttribute("currentFlight", currentFlight);
        model.addAttribute("flights", flightService.findAll());
        model.addAttribute("airplanes", airplaneService.findAll());
        model.addAttribute("runways", runwayService.findAll());
        return "currentFlight/updateCurrentFlight";
    }

    @PostMapping("/listCurrentFlight/update")
    public String processUpdateForm(@Valid @ModelAttribute("currentFlight") CurrentFlight currentFlight, BindingResult bindingResult,
                                    Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("currentFlight", currentFlight);
            model.addAttribute("flights", flightService.findAll());
            model.addAttribute("airplanes", airplaneService.findAll());
            model.addAttribute("runways", runwayService.findAll());
            return "currentFlight/updateCurrentFlight";
        }

        currentFlightService.updateCurrentFlight(currentFlight);
        return "redirect:/listCurrentFlight";
    }

    @GetMapping("/listCurrentFlight/delete/{cfId}")
    public String deleteCurrentFlight(@PathVariable("cfId") Integer cfId) {
        currentFlightService.deleteCurrentFlightById(cfId);
        return "redirect:/listCurrentFlight";
    }

}