package com.example.zoo.service;

import com.example.zoo.model.response.ReportHighestConsumptionZoneResponse;
import com.example.zoo.model.response.ReportLeastAnimalsZoneResponse;

public interface ReportService {

    ReportHighestConsumptionZoneResponse getReportHighestConsumptionZone();

    ReportLeastAnimalsZoneResponse getReportLeastAnimalsZone();
}
