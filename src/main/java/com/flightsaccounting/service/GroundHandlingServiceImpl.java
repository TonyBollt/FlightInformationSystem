package com.flightsaccounting.service;

import com.flightsaccounting.entity.GroundHandling;
import com.flightsaccounting.repository.GroundHandlingRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class GroundHandlingServiceImpl implements GroundHandlingService{

    private final GroundHandlingRepository groundHandlingRepository;

    @Override
    public void createGroundHandling(GroundHandling groundHandling) {
        groundHandlingRepository.save(groundHandling);
    }

    @Override
    public List<GroundHandling> findAll() {
        return groundHandlingRepository.findAll();
    }

    @Override
    public Optional<GroundHandling> findGroundHandlingById(Integer ghCode) {
        return groundHandlingRepository.findById(ghCode);
    }

    @Override
    public void updateGroundHandling(GroundHandling groundHandling) {
        groundHandlingRepository.save(groundHandling);
    }

    @Override
    public void deleteGroundHandlingById(Integer ghCode) {
        groundHandlingRepository.deleteById(ghCode);
    }
}
