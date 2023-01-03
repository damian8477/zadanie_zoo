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
class ReportServiceTest {
    @Mock
    public ZoneRepository zoneRepository;

    @Mock
    public AnimalsRepository animalsRepository;

    @InjectMocks
    public ReportServiceImpl tested;

    @Test
    void shouldGetEmptyReportWhenZoneListIsEmpty() {
        //given
        ReportHighestConsumptionZoneResponse expected = new ReportHighestConsumptionZoneResponse(null, 0);
        //when
        Mockito.when(zoneRepository.findAll()).thenReturn(new ArrayList<>());

        ReportHighestConsumptionZoneResponse actual = tested.getReportHighestConsumptionZone();
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    void shouldReturnReportWhenZoneListIsNotEmptyWinFirstZone() {
        //given
        Zone firstZone = new Zone(1, "Example zone first");
        Zone secondZone = new Zone(2, "Example zone second");

        List<Animals> firstAnimalsList1 = new ArrayList<>(List.of(new Animals(0, "", "", 50, 1), new Animals(0, "", "", 49, 1)));
        List<Animals> secondAnimalsList2 = new ArrayList<>(List.of(new Animals(0, "", "", 20, 1), new Animals(0, "", "", 55, 1)));

        ReportHighestConsumptionZoneResponse expected = new ReportHighestConsumptionZoneResponse(firstZone, 99);
        //when
        Mockito.when(zoneRepository.findAll()).thenReturn(List.of(firstZone, secondZone));
        Mockito.when(animalsRepository.findAllByZoneId(1)).thenReturn(firstAnimalsList1);
        Mockito.when(animalsRepository.findAllByZoneId(2)).thenReturn(secondAnimalsList2);

        ReportHighestConsumptionZoneResponse actual = tested.getReportHighestConsumptionZone();
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    void shouldReturnReportWhenZoneListIsNotEmptyWinSecondZone() {
        //given
        Zone firstZone = new Zone(1, "Example zone first");
        Zone secondZone = new Zone(2, "Example zone second");

        List<Animals> firstAnimalsList1 = new ArrayList<>(List.of(new Animals(0, "", "", 0, 1), new Animals(0, "", "", 49, 1)));
        List<Animals> secondAnimalsList2 = new ArrayList<>(List.of(new Animals(0, "", "", 20, 1), new Animals(0, "", "", 55, 1)));

        ReportHighestConsumptionZoneResponse expected = new ReportHighestConsumptionZoneResponse(secondZone, 75);

        //when
        Mockito.when(zoneRepository.findAll()).thenReturn(List.of(firstZone, secondZone));
        Mockito.when(animalsRepository.findAllByZoneId(1)).thenReturn(firstAnimalsList1);
        Mockito.when(animalsRepository.findAllByZoneId(2)).thenReturn(secondAnimalsList2);

        ReportHighestConsumptionZoneResponse actual = tested.getReportHighestConsumptionZone();
        //then
        Assert.assertEquals(expected, actual);
    }


}
