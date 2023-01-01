package com.example.zoo.model.answer;

import com.example.zoo.model.db.Zone;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReportLeastAnimalsZone {
    private Zone zone;
    private int count;
}
