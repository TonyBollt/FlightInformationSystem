package com.flightsaccounting.service;


import com.flightsaccounting.entity.Flight;

import java.util.List;
import java.util.Optional;

public interface FlightService {
    void createFlight(Flight flight);

    List<Flight> findAll();

    Optional<Flight> findFlightById(String flightNo);

    void updateFlight(Flight flight);

    void deleteFlightById(String flightNo);
}
