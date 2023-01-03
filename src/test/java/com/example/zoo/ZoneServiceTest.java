package com.example.zoo;

import com.example.zoo.constants.Constants;
import com.example.zoo.model.entity.Zone;
import com.example.zoo.model.response.BasicResponse;
import com.example.zoo.repository.ZoneRepository;
import com.example.zoo.service.impl.ZoneServiceImpl;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.anyString;

@ExtendWith(MockitoExtension.class)
class ZoneServiceTest {

    @Mock
    public ZoneRepository zoneRepository;

    @InjectMocks
    public ZoneServiceImpl tested;

    @Test
    void shouldAddZoneWhenZoneByNameDoesNotExists() {
        //given
        Zone zone = new Zone();
        zone.setName("Example Zone");
        BasicResponse expected = new BasicResponse(true, Constants.ZONE_ADD);
        Mockito.when(zoneRepository.findByName(anyString())).thenReturn(null);
        //when
        BasicResponse actual = tested.addZone(zone);
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    void shouldNotAddZoneWhenZoneByNameExists() {
        //given
        Zone zone = new Zone();
        zone.setName("Example Zone");
        BasicResponse expected = new BasicResponse(false, Constants.ZONE_NAME);
        Mockito.when(zoneRepository.findByName(anyString())).thenReturn(zone);
        //when
        BasicResponse actual = tested.addZone(zone);
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    void shouldNotAddZoneWhenZoneByNullObject() {
        //given
        BasicResponse expected = new BasicResponse(false, Constants.ZONE_ERROR);
        //when
        BasicResponse actual = tested.addZone(null);
        //then
        Assert.assertEquals(expected, actual);
    }
}