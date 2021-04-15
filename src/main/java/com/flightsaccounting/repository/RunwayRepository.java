package com.flightsaccounting.repository;

import com.flightsaccounting.entity.Runway;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RunwayRepository extends JpaRepository<Runway, Integer> {
}
