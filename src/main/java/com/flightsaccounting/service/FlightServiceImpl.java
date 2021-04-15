package com.flightsaccounting.service;

import com.flightsaccounting.entity.Flight;
import com.flightsaccounting.repository.FlightRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class FlightServiceImpl implements FlightService {

    private final FlightRepository flightRepository;

    @Override
    public void createFlight(Flight flight) {
        flightRepository.save(flight);
    }

    @Override
    public List<Flight> findAll() {
        return flightRepository.findAll();
    }

    @Override
    public Optional<Flight> findFlightById(String flightNo) {
        return flightRepository.findById(flightNo);
    }

    @Override
    public void updateFlight(Flight flight) {
        flightRepository.save(flight);
    }

    @Override
    public void deleteFlightById(String flightNo) {
        flightRepository.deleteById(flightNo);
    }
}

