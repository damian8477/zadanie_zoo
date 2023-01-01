package com.example.zoo.model.answer;

import com.example.zoo.model.db.Zone;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReportHighestConsumptionZone {
    private Zone zone;
    private double food;
}
