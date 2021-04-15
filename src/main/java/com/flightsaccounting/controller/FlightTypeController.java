package com.flightsaccounting.controller;

import com.flightsaccounting.entity.FlightType;
import com.flightsaccounting.service.FlightTypeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@AllArgsConstructor
public class FlightTypeController {

    private final FlightTypeService flightTypeService;

    @GetMapping("/listFlightType/create")
    public String showCreationForm(Model model) {
        FlightType flightType = new FlightType();
        model.addAttribute("flightType", flightType);
        return "flightType/createFlightType";
    }

    @PostMapping("/listFlightType/create")
    public String processCreationForm(@Valid FlightType flightType, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "flightType/createFlightType";
        }

        flightTypeService.createFlightType(flightType);
        return "redirect:/listFlightType";
    }

    @GetMapping("/listFlightType")
    public String getFlightTypes(Model model) {
        model.addAttribute("flightTypes", flightTypeService.findAll());
        return "flightType/listFlightType";
    }

    @GetMapping("/listFlightType/update/{ftCode}")
    public String showUpdateForm(@PathVariable("ftCode") Integer ftCode, Model model) {
        Optional<FlightType> flightType = flightTypeService.findFlightTypeById(ftCode);
        model.addAttribute("flightType", flightType);
        return "flightType/updateFlightType";
    }

    @PostMapping("/listFlightType/update")
    public String processUpdateForm(@Valid FlightType flightType, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "flightType/updateFlightType";
        }

        flightTypeService.updateFlightType(flightType);
        return "redirect:/listFlightType";
    }

    @GetMapping("/listFlightType/delete/{ftCode}")
    public String deleteFlightType(@PathVariable("ftCode") Integer ftCode) {
        flightTypeService.deleteFlightTypeById(ftCode);
        return "redirect:/listFlightType";
    }

}
