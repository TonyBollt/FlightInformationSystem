package com.flightsaccounting.service;

import com.flightsaccounting.entity.Runway;

import java.util.List;
import java.util.Optional;

public interface RunwayService {

    void createRunway(Runway runway);

    List<Runway> findAll();

    Optional<Runway> findRunwayById(Integer runwayCode);

    void updateRunway(Runway runway);

    void deleteRunwayById(Integer runwayCode);
}
