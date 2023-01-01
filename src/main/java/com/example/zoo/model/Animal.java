package com.example.zoo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Animal {

    public String type;
    public String name;
    public double foodDemand;
    public int zoneId;

}
