package com.example.zoo.service.impl;

import com.example.zoo.constants.Constants;
import com.example.zoo.model.dto.ZoneDTO;
import com.example.zoo.model.entity.Zone;
import com.example.zoo.model.response.BasicResponse;
import com.example.zoo.repository.ZoneRepository;
import com.example.zoo.service.ZoneService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Objects.isNull;

@Service
@RequiredArgsConstructor
public class ZoneServiceImpl implements ZoneService {
    private final ZoneRepository zoneRepository;

    @Override
    public BasicResponse addZone(Zone zone) {
        try {
            if (!isNull(zoneRepository.findByName(zone.getName())))
                return new BasicResponse(false, Constants.ZONE_NAME);
            zoneRepository.save(zone);
            return new BasicResponse(true, Constants.ZONE_ADD);
        } catch (Exception ignored) {
            return new BasicResponse(false, Constants.ZONE_ERROR);
        }
    }

    @Override
    public List<ZoneDTO> getZoneList() {
        return zoneRepository.findAll()
                .stream()
                .map(zone -> new ModelMapper().map(zone, ZoneDTO.class))
                .toList();
    }

}
