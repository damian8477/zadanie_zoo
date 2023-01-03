package com.example.zoo.model.animal;

import lombok.Data;

import static com.example.zoo.constants.Constants.RABBIT;

@Data
public class Rabbit extends Animal{

    public Rabbit(String name, int zoneId) {
        super(RABBIT, name, 4, zoneId);
    }

}
