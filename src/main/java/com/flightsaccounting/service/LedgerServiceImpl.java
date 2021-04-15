package com.flightsaccounting.service;

import com.flightsaccounting.entity.Ledger;
import com.flightsaccounting.repository.LedgerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class LedgerServiceImpl implements LedgerService {

    private final LedgerRepository ledgerRepository;

    @Override
    public void createLedger(Ledger ledger) {
        ledgerRepository.save(ledger);
    }

    @Override
    public List<Ledger> findAll() {
        return ledgerRepository.findAll();
    }

    @Override
    public Optional<Ledger> findLedgerById(Integer ledgerId) {
        return ledgerRepository.findById(ledgerId);
    }

    @Override
    public void updateLedger(Ledger ledger) {
        ledgerRepository.save(ledger);
    }

    @Override
    public void deleteLedgerById(Integer ledgerId) {
        ledgerRepository.deleteById(ledgerId);
    }
}

