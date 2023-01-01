package com.example.zoo.service;

import com.example.zoo.model.dto.ZoneDTO;
import com.example.zoo.model.entity.Zone;
import com.example.zoo.model.response.BasicResponse;

import java.util.List;

public interface ZoneService {

    BasicResponse addZone(Zone zone);

    List<ZoneDTO> getZoneList();

}
