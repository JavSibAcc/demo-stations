package com.example.demo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Path {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long source_id;

    private Long destination_id;

    private Double cost;

    public Path() {
    }

    public Path(Double cost, Long source_id, Long destination_id) {
        this.cost = cost;
        this.source_id = source_id;
        this.destination_id = destination_id;
    }

    public Path(Long id, Double cost, Long source_id, Long destination_id) {
        this.cost = cost;
        this.source_id = source_id;
        this.destination_id = destination_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSource_id() {
        return source_id;
    }

    public void setSource_id(Long source_id) {
        this.source_id = source_id;
    }

    public Long getDestination_id() {
        return destination_id;
    }

    public void setDestination_id(Long destination_id) {
        this.destination_id = destination_id;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }
}
