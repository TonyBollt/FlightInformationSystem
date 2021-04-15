package com.flightsaccounting.service;

import com.flightsaccounting.entity.Ledger;

import java.util.List;
import java.util.Optional;

public interface LedgerService {
    void createLedger(Ledger ledger);

    List<Ledger> findAll();

    Optional<Ledger> findLedgerById(Integer ledgerId);

    void updateLedger(Ledger ledger);

    void deleteLedgerById(Integer ledgerId);
}

