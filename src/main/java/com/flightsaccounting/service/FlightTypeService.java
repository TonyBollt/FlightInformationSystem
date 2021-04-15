package com.flightsaccounting.service;

import com.flightsaccounting.entity.FlightType;

import java.util.List;
import java.util.Optional;

public interface FlightTypeService {

    void createFlightType(FlightType flightType);

    List<FlightType> findAll();

    Optional<FlightType> findFlightTypeById(Integer ftCode);

    void updateFlightType(FlightType flightType);

    void deleteFlightTypeById(Integer ftCode);

}
