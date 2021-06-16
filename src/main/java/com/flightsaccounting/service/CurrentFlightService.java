package com.flightsaccounting.service;


import com.flightsaccounting.entity.CurrentFlight;

import java.util.List;
import java.util.Optional;

public interface CurrentFlightService {
    void createCurrentFlight(CurrentFlight currentFlight);

    List<CurrentFlight> findAll();

    List<CurrentFlight> findAllByOrderByDepDateDesc();

    Optional<CurrentFlight> findCurrentFlightById(Integer cfId);

    void updateCurrentFlight(CurrentFlight currentFlight);

    void deleteCurrentFlightById(Integer cfId);
}
