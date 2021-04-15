package com.flightsaccounting.service;

import com.flightsaccounting.entity.Runway;
import com.flightsaccounting.repository.RunwayRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RunwayServiceImpl implements RunwayService{

    private final RunwayRepository runwayRepository;

    @Override
    public void createRunway(Runway runway) {
        runwayRepository.save(runway);
    }

    @Override
    public List<Runway> findAll() {
        return runwayRepository.findAll();
    }

    @Override
    public Optional<Runway> findRunwayById(Integer runwayCode) {
        return runwayRepository.findById(runwayCode);
    }

    @Override
    public void updateRunway(Runway runway) {
        runwayRepository.save(runway);
    }

    @Override
    public void deleteRunwayById(Integer runwayCode) {
        runwayRepository.deleteById(runwayCode);
    }
}
