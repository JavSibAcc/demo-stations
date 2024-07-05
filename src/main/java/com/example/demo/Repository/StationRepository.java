package com.example.demo.Repository;

import com.example.demo.Model.Station;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;


import java.util.*;

@Component
public class StationRepository {


    //HashSet<Station> arrStation = new HashSet<>();
    //Set<Station> hsStation = new HashSet<>();
    //List<Station> arrStation = new ArrayList<>(hsStation);

    public HashMap<Long, String> hmStation = new HashMap<Long, String>();




    private StationRepository() {
        hmStation.put(0L, "Barcelona");
        hmStation.put(1L, "Buenos Aires");
        hmStation.put(2L, "Paris");
        hmStation.put(3L, "Berlin");
        hmStation.put(4L, "Roma");
    }

    public HashMap<Long, String> findAll() {
        return hmStation;
    }

    public Station saveStation(@NotNull Station a) {
        hmStation.put(a.getId(), a.getName());
        return a;
    }
}
