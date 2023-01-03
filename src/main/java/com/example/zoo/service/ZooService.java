package com.example.zoo.service;

import com.example.zoo.exception.PrzekroczonyLimitJedzeniaException;
import com.example.zoo.model.animal.Elephant;
import com.example.zoo.model.animal.Lion;
import com.example.zoo.model.animal.Rabbit;
import com.example.zoo.model.response.BasicResponse;
import com.example.zoo.model.dto.AnimalsDTO;

import java.util.List;

public interface ZooService {

    BasicResponse addElephant(Elephant elephant) throws PrzekroczonyLimitJedzeniaException;

    BasicResponse addLion(Lion lion) throws PrzekroczonyLimitJedzeniaException;

    BasicResponse addRabbit(Rabbit lion) throws PrzekroczonyLimitJedzeniaException;

    List<AnimalsDTO> getAnimalsZoneList(String name);

    List<AnimalsDTO> getAnimalsZoneList(int zoneId);

    List<AnimalsDTO> getAnimalsNameList(String name);

}
