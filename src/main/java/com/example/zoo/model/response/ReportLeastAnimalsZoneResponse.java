package com.example.zoo.model.response;

import com.example.zoo.model.entity.Zone;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReportLeastAnimalsZoneResponse {
    private Zone zone;
    private int count;
}
