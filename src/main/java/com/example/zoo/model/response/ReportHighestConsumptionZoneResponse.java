package com.example.zoo.model.response;

import com.example.zoo.model.entity.Zone;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReportHighestConsumptionZoneResponse {
    private Zone zone;
    private double food;
}
