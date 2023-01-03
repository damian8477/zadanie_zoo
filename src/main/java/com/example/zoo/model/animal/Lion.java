package com.example.zoo.model.animal;

import lombok.Data;

import static com.example.zoo.constants.Constants.LION;

@Data
public class Lion extends Animal{

    public Lion(String name, int zoneId) {
        super(LION, name, 11, zoneId);
    }

}
