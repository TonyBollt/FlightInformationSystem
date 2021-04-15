package com.flightsaccounting.service;

import com.flightsaccounting.entity.FlightType;
import com.flightsaccounting.repository.FlightTypeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class FlightTypeServiceImpl implements FlightTypeService {

    private final FlightTypeRepository flightTypeRepository;

    @Override
    public void createFlightType(FlightType flightType) {
        flightTypeRepository.save(flightType);
    }

    @Override
    public List<FlightType> findAll() {
        return flightTypeRepository.findAll();
    }

    @Override
    public Optional<FlightType> findFlightTypeById(Integer ftCode) {
        return flightTypeRepository.findById(ftCode);
    }

    @Override
    public void updateFlightType(FlightType flightType) {
        flightTypeRepository.save(flightType);
    }

    @Override
    public void deleteFlightTypeById(Integer ftCode) {
        flightTypeRepository.deleteById(ftCode);
    }
}
