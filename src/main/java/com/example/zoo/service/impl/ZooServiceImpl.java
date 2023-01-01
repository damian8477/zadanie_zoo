package com.example.zoo.service.impl;


import com.example.zoo.exception.PrzekroczonyLimitJedzeniaException;
import com.example.zoo.model.db.Animals;
import com.example.zoo.model.Elephant;
import com.example.zoo.model.Lion;
import com.example.zoo.model.Rabbit;
import com.example.zoo.model.answer.BoolStringAnswer;
import com.example.zoo.model.dto.AnimalsDTO;
import com.example.zoo.model.dto.ZoneDTO;
import com.example.zoo.repository.AnimalsRepository;
import com.example.zoo.repository.ZoneRepository;
import com.example.zoo.service.ZooService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ZooServiceImpl implements ZooService {
    private final AnimalsRepository animalsRepository;
    private final ZoneRepository zoneRepository;

    @Override
    public BoolStringAnswer addElephant(Elephant elephant) throws PrzekroczonyLimitJedzeniaException{
        if (zoneRepository.findById(elephant.getZoneId()) != null) {
            if (animalsRepository.findAllByZoneId(elephant.getZoneId()).stream()
                    .mapToDouble(Animals::getFoodDemand)
                    .sum() + elephant.getFoodDemand() > 100) {
                throw new PrzekroczonyLimitJedzeniaException("Za mało jedzonka w tej strefie, wybierz inną");
            }
            animalsRepository.save(Animals.builder()
                    .type("ELEPHANT")
                    .name(elephant.getName())
                    .zoneId(elephant.getZoneId())
                    .foodDemand(elephant.getFoodDemand())
                    .build());
            return new BoolStringAnswer(true, "Zwierze zostało dodane do wybranej strefy");
        } else {
            return new BoolStringAnswer(false, "Wybrana strefa nie istnieje");
        }
    }

    @Override
    public BoolStringAnswer addLion(Lion lion) throws PrzekroczonyLimitJedzeniaException{
        if (zoneRepository.findById(lion.getZoneId()) != null) {
            if (animalsRepository.findAllByZoneId(lion.getZoneId()).stream()
                    .mapToDouble(Animals::getFoodDemand)
                    .sum() + lion.getFoodDemand() > 100) {
                throw new PrzekroczonyLimitJedzeniaException("Za mało jedzonka w tej strefie, wybierz inną");
            }
            animalsRepository.save(Animals.builder()
                    .type("LION")
                    .name(lion.getName())
                    .zoneId(lion.getZoneId())
                    .foodDemand(lion.getFoodDemand())
                    .build());
            return new BoolStringAnswer(true, "Zwierze zostało dodane do wybranej strefy");
        } else {
            return new BoolStringAnswer(false, "Wybrana strefa nie istnieje");
        }
    }

    @Override
    public BoolStringAnswer addRabbit(Rabbit rabbit) throws PrzekroczonyLimitJedzeniaException {
        if (zoneRepository.findById(rabbit.getZoneId()) != null) {
            if (animalsRepository.findAllByZoneId(rabbit.getZoneId()).stream()
                    .mapToDouble(Animals::getFoodDemand)
                    .sum() + rabbit.getFoodDemand() > 100) {
                throw new PrzekroczonyLimitJedzeniaException("Za mało jedzonka w tej strefie, wybierz inną");
            }
            animalsRepository.save(Animals.builder()
                    .type("RABBIT")
                    .name(rabbit.getName())
                    .zoneId(rabbit.getZoneId())
                    .foodDemand(rabbit.getFoodDemand())
                    .build());
            return new BoolStringAnswer(true, "Zwierze zostało dodane do wybranej strefy");
        } else {
            return new BoolStringAnswer(false, "Wybrana strefa nie istnieje");
        }
    }

    @Override
    public List<AnimalsDTO> getAnimalsZoneList(String name) {
        try {
            return animalsRepository.findAllByZoneId(zoneRepository.findByName(name).getId()).stream()
                    .map(animals -> new ModelMapper().map(animals, AnimalsDTO.class))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    @Override
    public List<AnimalsDTO> getAnimalsZoneList(int zoneId) {
        try {
            return animalsRepository.findAllByZoneId(zoneId).stream()
                    .map(animals -> new ModelMapper().map(animals, AnimalsDTO.class))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    @Override
    public List<AnimalsDTO> getAnimalsNameList(String name) {
        try {
            return animalsRepository.findAllByName(name).stream()
                    .map(animals -> new ModelMapper().map(animals, AnimalsDTO.class))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

}
