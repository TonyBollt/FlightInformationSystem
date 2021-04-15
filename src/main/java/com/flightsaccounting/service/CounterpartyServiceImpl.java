package com.flightsaccounting.service;

import com.flightsaccounting.entity.Counterparty;
import com.flightsaccounting.repository.CounterpartyRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CounterpartyServiceImpl implements CounterpartyService{

    private final CounterpartyRepository counterpartyRepository;

    @Override
    public void createCounterparty(Counterparty counterparty) {
        counterpartyRepository.save(counterparty);
    }

    @Override
    public List<Counterparty> findAll() {
        return counterpartyRepository.findAll();
    }

    @Override
    public Optional<Counterparty> findCounterpartyById(Integer cpCode) {
        return counterpartyRepository.findById(cpCode);
    }

    @Override
    public void updateCounterparty(Counterparty counterparty) {
        counterpartyRepository.save(counterparty);
    }

    @Override
    public void deleteCounterpartyById(Integer cpCode) {
        counterpartyRepository.deleteById(cpCode);
    }
}
