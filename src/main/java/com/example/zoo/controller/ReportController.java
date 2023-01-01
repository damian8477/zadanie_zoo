package com.example.zoo.controller;

import com.example.zoo.model.response.ReportHighestConsumptionZoneResponse;
import com.example.zoo.model.response.ReportLeastAnimalsZoneResponse;
import com.example.zoo.service.ReportService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/report")
public record ReportController(ReportService reportService) {
    @GetMapping("/zone/food-demand-max")
    public ReportHighestConsumptionZoneResponse reportHighestConsumptionZone() {
        return reportService.getReportHighestConsumptionZone();
    }

    @GetMapping("/zone/least-animals")
    public ReportLeastAnimalsZoneResponse reportLeastAnimalsZone() {
        return reportService.getReportLeastAnimalsZone();
    }
}
