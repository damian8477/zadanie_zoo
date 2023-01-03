package com.example.zoo.model.animal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Animal {

    private String type;
    private String name;
    private double foodDemand;
    private int zoneId;

}
