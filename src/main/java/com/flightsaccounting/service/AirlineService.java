package com.flightsaccounting.service;

import com.flightsaccounting.entity.Airline;

import java.util.List;
import java.util.Optional;

public interface AirlineService{
    void createAirline(Airline airline);

    List<Airline> findAll();

    Optional<Airline> findAirlineById(Integer airlineCode);

    void updateAirline(Airline airline);

    void deleteAirlineById(Integer airlineCode);
}
