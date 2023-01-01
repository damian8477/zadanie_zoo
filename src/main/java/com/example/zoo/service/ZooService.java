package com.example.zoo.service;

import com.example.zoo.exception.PrzekroczonyLimitJedzeniaException;
import com.example.zoo.model.db.Animals;
import com.example.zoo.model.Elephant;
import com.example.zoo.model.Lion;
import com.example.zoo.model.Rabbit;
import com.example.zoo.model.answer.BoolStringAnswer;
import com.example.zoo.model.dto.AnimalsDTO;

import java.util.List;

public interface ZooService {

    BoolStringAnswer addElephant(Elephant elephant) throws PrzekroczonyLimitJedzeniaException;
    BoolStringAnswer addLion(Lion lion) throws PrzekroczonyLimitJedzeniaException;
    BoolStringAnswer addRabbit(Rabbit lion) throws PrzekroczonyLimitJedzeniaException;
    List<AnimalsDTO> getAnimalsZoneList(String name);
    List<AnimalsDTO> getAnimalsZoneList(int zoneId);
    List<AnimalsDTO> getAnimalsNameList(String name);

}
