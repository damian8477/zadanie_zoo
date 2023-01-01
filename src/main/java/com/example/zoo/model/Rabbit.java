package com.example.zoo.model;

import lombok.Data;

@Data
public class Rabbit extends Animal{
    public Rabbit(String name, double foodDemand, int zoneId) {
        super(name, 4, zoneId);
    }
}
