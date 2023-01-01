package com.example.zoo.model;

import lombok.Data;

@Data
public class Lion extends Animal{
    public Lion(String name, double foodDemand, int zoneId) {
        super(name, 11, zoneId);
    }
}
