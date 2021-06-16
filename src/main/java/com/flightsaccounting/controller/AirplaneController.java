package com.flightsaccounting.controller;

import com.flightsaccounting.entity.Airplane;
import com.flightsaccounting.service.AirlineService;
import com.flightsaccounting.service.AirplaneService;
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
public class AirplaneController {

    private final AirplaneService airplaneService;
    private final AirlineService airlineService;

    @GetMapping("/listAirplane/create")
    public String showCreationForm(Model model) {
        Airplane airplane = new Airplane();
        model.addAttribute("airplane", airplane);
        //List<Airline> airlines = airlineService.findAll();
        //model.addAttribute("airlines", airlines);
        model.addAttribute("airlines", airlineService.findAll());
        return "airplane/createAirplane";
    }

    @PostMapping("/listAirplane/create")
    public String processCreationForm(@Valid @ModelAttribute("airplane") Airplane airplane, BindingResult bindingResult,
                                      Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("airplane", airplane);
            model.addAttribute("airlines", airlineService.findAll());
            return "airplane/createAirplane";
        }
        airplaneService.createAirplane(airplane);
        return "redirect:/listAirplane";
    }

    @GetMapping("/listAirplane")
    public String getAirplanes(Model model) {
        model.addAttribute("airplanes", airplaneService.findAll());
        return "airplane/listAirplane";
    }


    @GetMapping("/listAirplane/update/{tailNumber}")
    public String showUpdateForm(@PathVariable("tailNumber") String tailNumber, Model model) {
        Optional<Airplane> airplane = airplaneService.findAirplaneById(tailNumber);
        model.addAttribute("airplane", airplane);
        model.addAttribute("airlines", airlineService.findAll());
        return "airplane/updateAirplane";
    }

    @PostMapping("/listAirplane/update")
    public String processUpdateForm(@Valid @ModelAttribute("airplane") Airplane airplane, BindingResult bindingResult,
                                    Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("airplane", airplane);
            model.addAttribute("airlines", airlineService.findAll());
            return "airplane/updateAirplane";
        }

        airplaneService.updateAirplane(airplane);
        return "redirect:/listAirplane";
    }

    @GetMapping("/listAirplane/delete/{tailNumber}")
    public String deleteAirplane(@PathVariable("tailNumber") String tailNumber) {
        airplaneService.deleteAirplaneById(tailNumber);
        return "redirect:/listAirplane";
    }

}
