package com.example.zoo.model;

import lombok.Data;

@Data
public class Elephant extends Animal{
    public Elephant(String name, double foodDemand, int zoneId) {
        super(name, 20, zoneId);
    }
}
