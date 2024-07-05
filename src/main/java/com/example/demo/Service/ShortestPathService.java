package com.example.demo.Service;

import com.example.demo.Model.resultDijkstra;

import java.util.HashMap;

public interface ShortestPathService {
    resultDijkstra getShortestPath(Long source_id, Long destination_id);
}
