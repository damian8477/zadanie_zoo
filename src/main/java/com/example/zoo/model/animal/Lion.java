package com.example.zoo.model.animal;

import lombok.Data;

@Data
public class Lion extends Animal{
    private final static String LION = "LION";

    public Lion(String name, int zoneId) {
        super(LION, name, 11, zoneId);
    }

}
