package com.flightsaccounting.service;


import com.flightsaccounting.entity.Counterparty;

import java.util.List;
import java.util.Optional;

public interface CounterpartyService {
    void createCounterparty(Counterparty counterparty);

    List<Counterparty> findAll();

    Optional<Counterparty> findCounterpartyById(Integer cpCode);

    void updateCounterparty(Counterparty counterparty);

    void deleteCounterpartyById(Integer cpCode);
}
