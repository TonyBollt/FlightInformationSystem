package com.flightsaccounting.service;

import com.flightsaccounting.entity.Airplane;
import com.flightsaccounting.repository.AirplaneRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AirplaneServiceImpl implements AirplaneService{

    private final AirplaneRepository airplaneRepository;

    @Override
    public void createAirplane(Airplane airplane) {
        airplaneRepository.save(airplane);
    }

    @Override
    public List<Airplane> findAll() {
        return airplaneRepository.findAll();
    }

    @Override
    public Optional<Airplane> findAirplaneById(String tailNumber) {
        return airplaneRepository.findById(tailNumber);
    }

    @Override
    public void updateAirplane(Airplane airplane) {
        airplaneRepository.save(airplane);
    }

    @Override
    public void deleteAirplaneById(String tailNumber) {
        airplaneRepository.deleteById(tailNumber);
    }

}
