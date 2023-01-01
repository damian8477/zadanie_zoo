package com.example.zoo.service.impl;

import com.example.zoo.model.dto.ZoneDTO;
import com.example.zoo.model.db.Zone;
import com.example.zoo.model.answer.BoolStringAnswer;
import com.example.zoo.repository.ZoneRepository;
import com.example.zoo.service.ZoneService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ZoneServiceImpl implements ZoneService {
    private final ZoneRepository zoneRepository;

    @Override
    public BoolStringAnswer addZone(Zone zone) {
        try{
            if(zoneRepository.findByName(zone.getName()) != null) return new BoolStringAnswer(false, "Strefa o takiej nazwie już istnieje");
            zoneRepository.save(zone);
            return new BoolStringAnswer(true, "Strefa dodana");
        }catch (Exception ignored){
            return new BoolStringAnswer(false, "Blad podczas dodania");

        }
    }

    @Override
    public List<ZoneDTO> getZoneList() {
        return zoneRepository.findAll()
                .stream()
                .map(zone -> new ModelMapper().map(zone, ZoneDTO.class))
                .collect(Collectors.toList());
    }
}
