package com.example.demo.Service;

import java.util.HashMap;

public interface ShortestPathService {
    HashMap<Long, String> getShortestPath(Long source_id, Long destination_id);
    Long createShortestPath();
}
