package com.example.demo.Service;

import com.example.demo.Model.Station;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface StationService {
    HashMap<Long, String> getAllStations();
    Optional<Station> getStationById(Long id);
    Boolean deleteStationById (Long id);

    Station saveStation(Station a);

    Long createStation(Station a);
}
