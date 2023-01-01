package com.example.zoo.model;

import lombok.Data;

@Data
public class Elephant extends Animal{
    private final static String ELEPHANT = "ELEPHANT";

    public Elephant(String name, int zoneId) {
        super(ELEPHANT, name, 20, zoneId);
    }



}
