package com.example.zoo.service;

import com.example.zoo.model.answer.ReportHighestConsumptionZone;
import com.example.zoo.model.answer.ReportLeastAnimalsZone;

public interface ReportService {
    ReportHighestConsumptionZone getReportHighestConsumptionZone();
    ReportLeastAnimalsZone getReportLeastAnimalsZone();
}
