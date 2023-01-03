package com.example.zoo.model.animal;

import lombok.Data;

@Data
public class Rabbit extends Animal{
    private final static String RABBIT = "RABBIT";

    public Rabbit(String name, int zoneId) {
        super(RABBIT, name, 4, zoneId);
    }

}
