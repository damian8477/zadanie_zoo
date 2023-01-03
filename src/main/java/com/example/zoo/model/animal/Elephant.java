package com.example.zoo.model.animal;

import lombok.Data;

import static com.example.zoo.constants.Constants.ELEPHANT;

@Data
public class Elephant extends Animal{

    public Elephant(String name, int zoneId) {
        super(ELEPHANT, name, 20, zoneId);
    }

}
