package com.example.zoo;

import com.example.zoo.constants.Constants;
import com.example.zoo.model.entity.Animals;
import com.example.zoo.model.entity.Zone;
import com.example.zoo.model.response.BasicResponse;
import com.example.zoo.model.response.ReportHighestConsumptionZoneResponse;
import com.example.zoo.repository.AnimalsRepository;
import com.example.zoo.repository.ZoneRepository;
import com.example.zoo.service.impl.ReportServiceImpl;
import com.example.zoo.service.impl.ZoneServiceImpl;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import static org.mockito.ArgumentMatchers.anyString;

@ExtendWith(MockitoExtension.class)
public class ReportServiceTest {
    @Mock
    public ZoneRepository zoneRepository;

    @Mock
    public AnimalsRepository animalsRepository;

    @InjectMocks
    public ReportServiceImpl tested;

    @Test
    public void shouldAddZoneWhenZoneByNameDoesNotExists() {
        //given
        Zone zone = null;//new Zone();
        //zone.setName("Example Zone");
        ReportHighestConsumptionZoneResponse expected = new ReportHighestConsumptionZoneResponse(zone, 0);
       // Mockito.when(zoneRepository.findAll()).thenReturn(List.of(zone));
        Mockito.when(zoneRepository.findAll()).thenReturn(new ArrayList<>());
        //when
        ReportHighestConsumptionZoneResponse actual = tested.getReportHighestConsumptionZone();
        //then
        Assert.assertEquals(expected, actual);
    }


//    @Override
//    public ReportHighestConsumptionZoneResponse getReportHighestConsumptionZone() {
//        AtomicReference<Zone> zoneMax = new AtomicReference<>();
//        AtomicReference<Double> maxQtyFoodInZone = new AtomicReference<>(0.0);
//        zoneRepository.findAll().forEach((Zone zone) -> {
//            double zoneFoodQty = animalsRepository.findAllByZoneId(zone.getId()).stream().mapToDouble(Animals::getFoodDemand).sum();
//            if (zoneFoodQty > maxQtyFoodInZone.get()) {
//                maxQtyFoodInZone.set(zoneFoodQty);
//                zoneMax.set(zone);
//            }
//        });
//        return new ReportHighestConsumptionZoneResponse(zoneMax.get(), maxQtyFoodInZone.get());
//    }
}