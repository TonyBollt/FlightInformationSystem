package com.flightsaccounting.controller;

import com.flightsaccounting.entity.Runway;
import com.flightsaccounting.service.RunwayService;
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
public class RunwayController {

    private final RunwayService runwayService;

    @GetMapping("/listRunway/create")
    public String showCreationForm(Model model) {
        Runway runway = new Runway();
        model.addAttribute("runway", runway);
        return "runway/createRunway";
    }

    @PostMapping("/listRunway/create")
    public String processCreationForm(@Valid Runway runway, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "runway/createRunway";
        }

        runwayService.createRunway(runway);
        return "redirect:/listRunway";
    }

    @GetMapping("/listRunway")
    public String getRunways(Model model) {
        model.addAttribute("runways", runwayService.findAll());
        return "runway/listRunway";
    }

    @GetMapping("/listRunway/update/{runwayCode}")
    public String showUpdateForm(@PathVariable("runwayCode") Integer runwayCode, Model model) {
        Optional<Runway> runway = runwayService.findRunwayById(runwayCode);
        model.addAttribute("runway", runway);
        return "runway/updateRunway";
    }

    @PostMapping("/listRunway/update")
    public String processUpdateForm(@Valid Runway runway, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "runway/updateRunway";
        }

        runwayService.updateRunway(runway);
        return "redirect:/listRunway";
    }

    @GetMapping("/listRunway/delete/{runwayCode}")
    public String deleteRunway(@PathVariable("runwayCode") Integer runwayCode) {
        runwayService.deleteRunwayById(runwayCode);
        return "redirect:/listRunway";
    }

}
