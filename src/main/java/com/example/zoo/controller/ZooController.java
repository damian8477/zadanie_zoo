package com.example.zoo.controller;


import com.example.zoo.exception.PrzekroczonyLimitJedzeniaException;
import com.example.zoo.model.*;
import com.example.zoo.model.answer.BoolStringAnswer;
import com.example.zoo.model.db.Animals;
import com.example.zoo.model.db.Zone;
import com.example.zoo.model.dto.AnimalsDTO;
import com.example.zoo.model.dto.ZoneDTO;
import com.example.zoo.service.ZoneService;
import com.example.zoo.service.ZooService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/zoo")
public record ZooController(ZoneService zoneService,
                            ZooService zooService) {
    @PostMapping(value = "/add-zone")
    public BoolStringAnswer postZone(@RequestBody Zone zone) {
        return zoneService.addZone(zone);
    }

    @GetMapping("/zone")
    public List<ZoneDTO> getZoneList() {
        return zoneService.getZoneList();
    }

    @PostMapping(value = "/add-elephant")
    public BoolStringAnswer postAddElephant(@RequestBody Elephant elephant)throws PrzekroczonyLimitJedzeniaException {
        return zooService.addElephant(elephant);
    }

    @PostMapping(value = "/add-lion")
    public BoolStringAnswer postAddLion(@RequestBody Lion lion) throws PrzekroczonyLimitJedzeniaException{
        return zooService.addLion(lion);
    }

    @PostMapping(value = "/add-rabbit")
    public BoolStringAnswer  postAddRabbit(@RequestBody Rabbit rabbit)throws PrzekroczonyLimitJedzeniaException {
        return zooService.addRabbit(rabbit);
    }

    @GetMapping("{zoneName}/name/animals")
    public List<AnimalsDTO> getAnimalsZoneList(@PathVariable String zoneName) {
        return zooService.getAnimalsZoneList(zoneName);
    }

    @GetMapping("{zoneId}/id/animals")
    public List<AnimalsDTO> getAnimalsZoneList(@PathVariable int zoneId) {
        return zooService.getAnimalsZoneList(zoneId);
    }

    @GetMapping("{name}/animals")
    public List<AnimalsDTO> getNameAnimals(@PathVariable String name) {
        return zooService.getAnimalsNameList(name);
    }
}
