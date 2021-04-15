package com.flightsaccounting.repository;

import com.flightsaccounting.entity.CurrentFlight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrentFlightRepository extends JpaRepository<CurrentFlight, Integer> {

}
