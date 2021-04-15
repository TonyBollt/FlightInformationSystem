
package com.flightsaccounting.service;


import com.flightsaccounting.entity.CurrentFlight;
import com.flightsaccounting.repository.CurrentFlightRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CurrentFlightServiceImpl implements CurrentFlightService {

    private final CurrentFlightRepository currentFlightRepository;

    @Override
    public void createCurrentFlight(CurrentFlight currentFlight) {
        currentFlightRepository.save(currentFlight);
    }

    @Override
    public List<CurrentFlight> findAll() {
        return currentFlightRepository.findAll();
    }

    @Override
    public Optional<CurrentFlight> findCurrentFlightById(Integer cfId) {
        return currentFlightRepository.findById(cfId);
    }

    @Override
    public void updateCurrentFlight(CurrentFlight currentFlight) {
        currentFlightRepository.save(currentFlight);
    }

    @Override
    public void deleteCurrentFlightById(Integer cfId) {
        currentFlightRepository.deleteById(cfId);
    }
}

