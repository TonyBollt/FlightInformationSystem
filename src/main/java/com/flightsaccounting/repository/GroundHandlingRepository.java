package com.flightsaccounting.repository;

import com.flightsaccounting.entity.GroundHandling;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroundHandlingRepository extends JpaRepository<GroundHandling, Integer> {
}
