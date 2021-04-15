package com.flightsaccounting.repository;

import com.flightsaccounting.entity.FlightType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightTypeRepository extends JpaRepository<FlightType, Integer> {
}
