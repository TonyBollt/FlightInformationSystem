package com.flightsaccounting.service;

import com.flightsaccounting.entity.GroundHandling;

import java.util.List;
import java.util.Optional;

public interface GroundHandlingService {
    void createGroundHandling(GroundHandling groundHandling);

    List<GroundHandling> findAll();

    Optional<GroundHandling> findGroundHandlingById(Integer ghCode);

    void updateGroundHandling(GroundHandling groundHandling);

    void deleteGroundHandlingById(Integer ghCode);
}
