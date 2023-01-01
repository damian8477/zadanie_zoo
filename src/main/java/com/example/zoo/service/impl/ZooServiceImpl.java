package com.example.zoo.service.impl;


import com.example.zoo.constants.Constants;
import com.example.zoo.exception.PrzekroczonyLimitJedzeniaException;
import com.example.zoo.model.entity.Animals;
import com.example.zoo.model.Elephant;
import com.example.zoo.model.Lion;
import com.example.zoo.model.Rabbit;
import com.example.zoo.model.response.BasicResponse;
import com.example.zoo.model.dto.AnimalsDTO;
import com.example.zoo.repository.AnimalsRepository;
import com.example.zoo.repository.ZoneRepository;
import com.example.zoo.service.ZooService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Service
@RequiredArgsConstructor
public class ZooServiceImpl implements ZooService {
    private final AnimalsRepository animalsRepository;
    private final ZoneRepository zoneRepository;

    @Override
    public BasicResponse addElephant(Elephant elephant) throws PrzekroczonyLimitJedzeniaException {
        if (!isNull(zoneRepository.findById(elephant.getZoneId()))) {
            double foodQty = animalsRepository.findAllByZoneId(elephant.getZoneId()).stream()
                    .mapToDouble(Animals::getFoodDemand)
                    .sum() + elephant.getFoodDemand();
            if (foodQty > 100) {
                throw new PrzekroczonyLimitJedzeniaException(Constants.FOOD_LIMIT_EXCEPTION);
            }
            animalsRepository.save(Animals.builder()
                    .type(elephant.getType())
                    .name(elephant.getName())
                    .zoneId(elephant.getZoneId())
                    .foodDemand(elephant.getFoodDemand())
                    .build());
            return new BasicResponse(true, Constants.ANIMAL_ADD);
        } else {
            return new BasicResponse(false, Constants.ZONE_MISS);
        }
    }

    @Override
    public BasicResponse addLion(Lion lion) throws PrzekroczonyLimitJedzeniaException {
        if (!isNull(zoneRepository.findById(lion.getZoneId()))) {
            double foodQty = animalsRepository.findAllByZoneId(lion.getZoneId()).stream()
                    .mapToDouble(Animals::getFoodDemand)
                    .sum() + lion.getFoodDemand();
            if (foodQty > 100) {
                throw new PrzekroczonyLimitJedzeniaException(Constants.FOOD_LIMIT_EXCEPTION);
            }
            animalsRepository.save(Animals.builder()
                    .type(lion.getType())
                    .name(lion.getName())
                    .zoneId(lion.getZoneId())
                    .foodDemand(lion.getFoodDemand())
                    .build());
            return new BasicResponse(true, Constants.ANIMAL_ADD);
        } else {
            return new BasicResponse(false, Constants.ZONE_MISS);
        }
    }

    @Override
    public BasicResponse addRabbit(Rabbit rabbit) throws PrzekroczonyLimitJedzeniaException {
        if (!isNull(zoneRepository.findById(rabbit.getZoneId()))) {
            double foodQty = animalsRepository.findAllByZoneId(rabbit.getZoneId()).stream()
                    .mapToDouble(Animals::getFoodDemand)
                    .sum() + rabbit.getFoodDemand();
            if (foodQty > 100) {
                throw new PrzekroczonyLimitJedzeniaException(Constants.FOOD_LIMIT_EXCEPTION);
            }
            animalsRepository.save(Animals.builder()
                    .type(rabbit.getType())
                    .name(rabbit.getName())
                    .zoneId(rabbit.getZoneId())
                    .foodDemand(rabbit.getFoodDemand())
                    .build());
            return new BasicResponse(true, Constants.ANIMAL_ADD);
        } else {
            return new BasicResponse(false, Constants.ZONE_MISS);
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
