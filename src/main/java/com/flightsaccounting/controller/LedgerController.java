package com.flightsaccounting.controller;

import com.flightsaccounting.entity.Ledger;
import com.flightsaccounting.service.*;
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
public class LedgerController {
    private final LedgerService ledgerService;
    private final CurrentFlightService currentFlightService;
    private final CounterpartyService counterpartyService;
    private final GroundHandlingService groundHandlingService;

    @GetMapping("/listLedger/create")
    public String showCreationForm(Model model) {
        Ledger ledger = new Ledger();
        model.addAttribute("ledger", ledger);
        model.addAttribute("currentFlights", currentFlightService.findAll());
        model.addAttribute("counterparties", counterpartyService.findAll());
        model.addAttribute("groundHandlings", groundHandlingService.findAll());
        return "ledger/createLedger";
    }

    @PostMapping("/listLedger/create")
    public String processCreationForm(@Valid Ledger ledger, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "ledger/createLedger";
        }

        ledgerService.createLedger(ledger);
        return "redirect:/listLedger";
    }

    @GetMapping("/listLedger")
    public String getLedger(Model model) {
        model.addAttribute("ledgers", ledgerService.findAll());
        return "ledger/listLedger";
    }

    @GetMapping("/listLedger/update/{ledgerId}")
    public String showUpdateForm(@PathVariable("ledgerId") Integer ledgerId, Model model) {
        Optional<Ledger> ledger = ledgerService.findLedgerById(ledgerId);
        model.addAttribute("ledger", ledger);
        model.addAttribute("currentFlights", currentFlightService.findAll());
        model.addAttribute("counterparties", counterpartyService.findAll());
        model.addAttribute("groundHandlings", groundHandlingService.findAll());
        return "ledger/updateLedger";
    }

    @PostMapping("/listLedger/update")
    public String processUpdateForm(@Valid Ledger ledger, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "ledger/updateLedger";
        }

        ledgerService.updateLedger(ledger);
        return "redirect:/listLedger";
    }

    @GetMapping("/listLedger/delete/{ledgerId}")
    public String deleteLedger(@PathVariable("ledgerId") Integer ledgerId) {
        ledgerService.deleteLedgerById(ledgerId);
        return "redirect:/listLedger";
    }
}

