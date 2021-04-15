package com.flightsaccounting.controller;

import com.flightsaccounting.entity.Counterparty;
import com.flightsaccounting.service.CounterpartyService;
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
public class CounterpartyController {

    private final CounterpartyService counterpartyService;

    @GetMapping("/listCounterparty/create")
    public String showCreationForm(Model model) {
        Counterparty counterparty = new Counterparty();
        model.addAttribute("counterparty", counterparty);
        return "counterparty/createCounterparty";
    }

    @PostMapping("/listCounterparty/create")
    public String processCreationForm(@Valid Counterparty counterparty, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "counterparty/createCounterparty";
        }

        counterpartyService.createCounterparty(counterparty);
        return "redirect:/listCounterparty";
    }

    @GetMapping("/listCounterparty")
    public String getCounterparties(Model model) {
        model.addAttribute("counterparties", counterpartyService.findAll());
        return "counterparty/listCounterparty";
    }

    @GetMapping("/listCounterparty/update/{cpCode}")
    public String showUpdateForm(@PathVariable("cpCode") Integer cpCode, Model model) {
        Optional<Counterparty> counterparty = counterpartyService.findCounterpartyById(cpCode);
        model.addAttribute("counterparty", counterparty);
        return "counterparty/updateCounterparty";
    }

    @PostMapping("/listCounterparty/update")
    public String processUpdateForm(@Valid Counterparty counterparty, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "counterparty/updateCounterparty";
        }

        counterpartyService.updateCounterparty(counterparty);
        return "redirect:/listCounterparty";
    }

    @GetMapping("/listCounterparty/delete/{cpCode}")
    public String deleteCounterparty(@PathVariable("cpCode") Integer cpCode) {
        counterpartyService.deleteCounterpartyById(cpCode);
        return "redirect:/listCounterparty";
    }

}
