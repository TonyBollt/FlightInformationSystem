package com.flightsaccounting.service;

import com.flightsaccounting.entity.Airplane;

import java.util.List;
import java.util.Optional;

public interface AirplaneService {

    void createAirplane(Airplane airplane);

    List<Airplane> findAll();

    Optional<Airplane> findAirplaneById(String tailNumber);

    void updateAirplane(Airplane airplane);

    void deleteAirplaneById(String tailNumber);

}
