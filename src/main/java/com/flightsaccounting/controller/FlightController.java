package com.flightsaccounting.controller;

import com.flightsaccounting.entity.Flight;
import com.flightsaccounting.service.AirlineService;
import com.flightsaccounting.service.FlightService;
import com.flightsaccounting.service.FlightTypeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@AllArgsConstructor
public class FlightController {
    private final FlightService flightService;
    private final FlightTypeService flightTypeService;
    private final AirlineService airlineService;

    @GetMapping("/listFlight/create")
    public String showCreationForm(Model model) {
        Flight flight = new Flight();
        model.addAttribute("flight", flight);
        model.addAttribute("flightTypes", flightTypeService.findAll());
        model.addAttribute("airlines", airlineService.findAll());
        return "flight/createFlight";
    }

    @PostMapping("/listFlight/create")
    public String processCreationForm(@Valid @ModelAttribute("flight") Flight flight, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "flight/createFlight";
        }

        flightService.createFlight(flight);
        return "redirect:/listFlight";
    }

    @GetMapping("/listFlight")
    public String getFlights(Model model) {
        model.addAttribute("flights", flightService.findAll());
        return "flight/listFlight";
    }

    @GetMapping("/listFlight/update/{flightNo}")
    public String showUpdateForm(@PathVariable("flightNo") String flightNo, Model model) {
        Optional<Flight> flight = flightService.findFlightById(flightNo);
        model.addAttribute("flight", flight);
        model.addAttribute("flightTypes", flightTypeService.findAll());
        model.addAttribute("airlines", airlineService.findAll());
        return "flight/updateFlight";
    }

    @PostMapping("/listFlight/update")
    public String processUpdateForm(@Valid @ModelAttribute("flight") Flight flight, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "flight/updateFlight";
        }

        flightService.updateFlight(flight);
        return "redirect:/listFlight";
    }

    @GetMapping("/listFlight/delete/{flightNo}")
    public String deleteFlight(@PathVariable("flightNo") String flightNo) {
        flightService.deleteFlightById(flightNo);
        return "redirect:/listFlight";
    }

}