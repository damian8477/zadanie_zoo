package com.example.zoo.controller;

import com.example.zoo.model.answer.ReportHighestConsumptionZone;
import com.example.zoo.model.answer.ReportLeastAnimalsZone;
import com.example.zoo.service.ReportService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/report")
public record ReportController(ReportService reportService) {
    @GetMapping("/zone/food-demand-max")
    public ReportHighestConsumptionZone getReportHighestConsumptionZone() {
        return reportService.getReportHighestConsumptionZone();
    }

    @GetMapping("/zone/least-animals")
    public ReportLeastAnimalsZone getReportLeastAnimalsZone() {
        return reportService.getReportLeastAnimalsZone();
    }
}
