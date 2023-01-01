package com.example.zoo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class AnimalsDTO {
    private int id;
    private String type;
    private String name;
    private double foodDemand;
    private int zoneId;
}
