package com.example.demo.Controller;

import com.example.demo.Model.*;
import com.example.demo.Service.PathService;
import com.example.demo.Service.StationService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("api")
public class ApiDemo {

    @Autowired
    StationService stationService;

    @Autowired
    PathService pathService;

    @GetMapping("/saludar")
    public String saludar()
    {
        return "HOLA MUNDO !!!";
    }
    //----------------------------------------------------------------------------------------------------

    @GetMapping("/getAllStations")
    public HashMap<Long, String> getAllStations()
    {
        return stationService.getAllStations();
    }

    @PutMapping ("/stations/{id}")
    public Object saveStation(@PathVariable("id") Long id, @RequestBody @NotNull Station a)
    {
        a.setId(id);
        Object object = stationService.saveStation(a);

        if ( null == object )
        {
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        }
        return ("{ \"status\": \"ok\" }"); //new ResponseEntity<Void>(HttpStatus.OK);
    }

    @GetMapping("/getAllPaths")
    public HashMap<Long, Path> getAllPaths()
    {
        return pathService.getAllPaths();
    }

    @PutMapping ("/paths/{id}")
    public Object savePath(@PathVariable("id") Long id, @RequestBody @NotNull Path a)
    {
        a.setId(id);
        Object object = pathService.savePath(a);

        if ( null == object )
        {
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        }
        return ("{ \"status\": \"ok\" }"); //new ResponseEntity<Void>(HttpStatus.OK);
    }

    @GetMapping("/paths/{source_id}/{destination_id}")
    public Object getShortestPath(@PathVariable("source_id") Long source_id, @PathVariable("destination_id") Long destination_id)
    {
        /*
        Object object = pathService.getShortestPath(source_id, destination_id);
        if ( null == object )
        {
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        }
        return object; //("{ \"status\": \"ok\" }");
        */
        return ("{ \"source_id\": " + source_id + ", \"destination_id\": " + destination_id + " }");
    }
}
