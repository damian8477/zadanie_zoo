package com.example.zoo.service;

import com.example.zoo.exception.PrzekroczonyLimitJedzeniaException;
import com.example.zoo.model.dto.ZoneDTO;
import com.example.zoo.model.db.Zone;
import com.example.zoo.model.answer.BoolStringAnswer;

import java.util.List;

public interface ZoneService {

    BoolStringAnswer addZone(Zone zone);

    List<ZoneDTO> getZoneList();
}
