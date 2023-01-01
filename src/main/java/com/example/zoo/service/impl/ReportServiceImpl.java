package com.example.zoo.service.impl;

import com.example.zoo.model.db.Animals;
import com.example.zoo.model.db.Zone;
import com.example.zoo.model.answer.ReportHighestConsumptionZone;
import com.example.zoo.model.answer.ReportLeastAnimalsZone;
import com.example.zoo.repository.AnimalsRepository;
import com.example.zoo.repository.ZoneRepository;
import com.example.zoo.service.ReportService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicReference;

@Service
@AllArgsConstructor
public class ReportServiceImpl implements ReportService {
    private final ZoneRepository zoneRepository;
    private final AnimalsRepository animalsRepository;

    @Override
    public ReportHighestConsumptionZone getReportHighestConsumptionZone() {
        AtomicReference<Zone> zoneMax = new AtomicReference<>();
        AtomicReference<Double> foodMax = new AtomicReference<>(0.0);
        zoneRepository.findAll().forEach((Zone zone) -> {
            double sumZoneFood = animalsRepository.findAllByZoneId(zone.getId()).stream().mapToDouble(Animals::getFoodDemand).sum();
            if(sumZoneFood > foodMax.get()){
                foodMax.set(sumZoneFood);
                zoneMax.set(zone);
            }
        });
        return new ReportHighestConsumptionZone(zoneMax.get(), foodMax.get());
    }

    @Override
    public ReportLeastAnimalsZone getReportLeastAnimalsZone() {
        AtomicReference<Zone> zoneMax = new AtomicReference<>();
        AtomicReference<Integer> sizeMin= new AtomicReference<>( -1);
        zoneRepository.findAll().forEach(zone -> {
            int size = animalsRepository.findAllByZoneId(zone.getId()).size();
            if(size < sizeMin.get() || sizeMin.get() == -1){
                sizeMin.set(size);
                zoneMax.set(zone);
            }
        });
        return new ReportLeastAnimalsZone(zoneMax.get(), sizeMin.get());
    }
}
