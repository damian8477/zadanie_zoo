package com.example.zoo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class AnimalsDTO {

    private int id;
    private String type;
    private String name;
    private double foodDemand;
    private int zoneId;

}
