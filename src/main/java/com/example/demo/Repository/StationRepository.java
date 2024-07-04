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
        //Station a = new Station(1L, "glo");
        hmStation.put(1L, "glo");
    }

    public HashMap<Long, String> findAll() {
        return hmStation;
    }

    public Station saveStation(Station a) {
        hmStation.put(a.getId(), a.getName());
        return a;
    }
}
