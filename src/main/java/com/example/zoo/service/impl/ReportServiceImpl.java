package com.example.zoo.service.impl;

import com.example.zoo.model.entity.Animals;
import com.example.zoo.model.entity.Zone;
import com.example.zoo.model.response.ReportHighestConsumptionZoneResponse;
import com.example.zoo.model.response.ReportLeastAnimalsZoneResponse;
import com.example.zoo.repository.AnimalsRepository;
import com.example.zoo.repository.ZoneRepository;
import com.example.zoo.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicReference;

@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService {
    private final ZoneRepository zoneRepository;
    private final AnimalsRepository animalsRepository;

    @Override
    public ReportHighestConsumptionZoneResponse getReportHighestConsumptionZone() {
        AtomicReference<Zone> zoneMax = new AtomicReference<>();
        AtomicReference<Double> maxQtyFoodInZone = new AtomicReference<>(0.0);
        zoneRepository.findAll().forEach((Zone zone) -> {
            double zoneFoodQty = animalsRepository.findAllByZoneId(zone.getId()).stream().mapToDouble(Animals::getFoodDemand).sum();
            if (zoneFoodQty > maxQtyFoodInZone.get()) {
                maxQtyFoodInZone.set(zoneFoodQty);
                zoneMax.set(zone);
            }
        });
        return new ReportHighestConsumptionZoneResponse(zoneMax.get(), maxQtyFoodInZone.get());
    }

    @Override
    public ReportLeastAnimalsZoneResponse getReportLeastAnimalsZone() {
        AtomicReference<Zone> zoneMax = new AtomicReference<>();
        AtomicReference<Integer> sizeMin = new AtomicReference<>(-1);
        zoneRepository.findAll().forEach(zone -> {
            int size = animalsRepository.findAllByZoneId(zone.getId()).size();
            if (size < sizeMin.get() || sizeMin.get() == -1) {
                sizeMin.set(size);
                zoneMax.set(zone);
            }
        });
        return new ReportLeastAnimalsZoneResponse(zoneMax.get(), sizeMin.get());
    }
}
