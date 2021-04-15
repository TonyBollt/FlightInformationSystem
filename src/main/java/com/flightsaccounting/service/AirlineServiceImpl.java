package com.flightsaccounting.service;

import com.flightsaccounting.entity.Airline;
import com.flightsaccounting.repository.AirlineRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AirlineServiceImpl implements AirlineService{
    private final AirlineRepository airlineRepository;

    @Override
    public void createAirline(Airline airline) {
        airlineRepository.save(airline);
    }

    @Override
    public List<Airline> findAll() {
        return airlineRepository.findAll();
    }

    @Override
    public Optional<Airline> findAirlineById(Integer airlineCode) {
        return airlineRepository.findById(airlineCode);
    }

    @Override
    public void updateAirline(Airline airline) {
        airlineRepository.save(airline);
    }

    @Override
    public void deleteAirlineById(Integer airlineCode) {
        airlineRepository.deleteById(airlineCode);
    }
}
