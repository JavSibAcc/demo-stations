package com.example.demo.Model;


public class resultDijkstra {

    // { "path": [12, 10, 11], "cost": 130}

    private long[] path;

    private Double cost;

    public resultDijkstra(long[] path, double cost) {
        this.cost = cost;
        this.path = path;
    }

    public resultDijkstra() {
    }

    public long[]  getPath() {
        return path;
    }

    public void setPath(long[]  path) {
        this.path = path;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }


}
