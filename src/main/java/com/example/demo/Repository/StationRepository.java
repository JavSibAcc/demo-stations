package com.example.demo.Repository;

import com.example.demo.Model.Station;
import org.springframework.stereotype.Component;


import java.util.*;

@Component
public class StationRepository {


    //HashSet<Station> arrStation = new HashSet<>();
    //Set<Station> hsStation = new HashSet<>();
    //List<Station> arrStation = new ArrayList<>(hsStation);

    HashMap<Long, String> hmStation = new HashMap<Long, String>();




    private StationRepository() {
        hmStation.put(1L, "Buenos Aires");
        hmStation.put(2L, "Paris");
        hmStation.put(3L, "Berlin");
        hmStation.put(4L, "Roma");
        hmStation.put(5L, "Barcelona");
    }

    public HashMap<Long, String> findAll() {
        return hmStation;
    }

    public Station saveStation(Station a) {
        hmStation.put(a.getId(), a.getName());
        return a;
    }
}
