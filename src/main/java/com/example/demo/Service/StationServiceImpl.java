package com.example.demo.Service;

import com.example.demo.Model.Station;
import com.example.demo.Repository.StationRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class StationServiceImpl implements StationService {

    ObjectMapper mapper = new ObjectMapper();

    @Autowired
    StationRepository stationRepository;


    @Override
    public HashMap<Long, String> getAllStations()  {
        return stationRepository.findAll();
    }

    @Override
    public Optional<Station> getStationById(Long id) {
        return Optional.empty();
    }

    @Override
    public Boolean deleteStationById(Long id) {
        return null;
    }

    @Override
    public Station saveStation(Station a) {
        return stationRepository.saveStation(a);
    }

    @Override
    public Long createStation(Station a) {
        return null;
    }
}
