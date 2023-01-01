package com.example.zoo.controller;


import com.example.zoo.exception.PrzekroczonyLimitJedzeniaException;
import com.example.zoo.model.*;
import com.example.zoo.model.response.BasicResponse;
import com.example.zoo.model.entity.Zone;
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
    @PostMapping("/add-zone")
    public BasicResponse addZone(@RequestBody Zone zone) {
        return zoneService.addZone(zone);
    }

    @GetMapping("/zone")
    public List<ZoneDTO> zoneList() {
        return zoneService.getZoneList();
    }

    @PostMapping("/add-elephant")
    public BasicResponse addElephant(@RequestBody Elephant elephant) throws PrzekroczonyLimitJedzeniaException {
        return zooService.addElephant(elephant);
    }

    @PostMapping("/add-lion")
    public BasicResponse addLion(@RequestBody Lion lion) throws PrzekroczonyLimitJedzeniaException {
        return zooService.addLion(lion);
    }

    @PostMapping("/add-rabbit")
    public BasicResponse addRabbit(@RequestBody Rabbit rabbit) throws PrzekroczonyLimitJedzeniaException {
        return zooService.addRabbit(rabbit);
    }

    @GetMapping("{zoneName}/name/animals")
    public List<AnimalsDTO> animalsZoneList(@PathVariable String zoneName) {
        return zooService.getAnimalsZoneList(zoneName);
    }

    @GetMapping("{zoneId}/id/animals")
    public List<AnimalsDTO> animalsZoneList(@PathVariable int zoneId) {
        return zooService.getAnimalsZoneList(zoneId);
    }

    @GetMapping("{name}/animals")
    public List<AnimalsDTO> nameAnimals(@PathVariable String name) {
        return zooService.getAnimalsNameList(name);
    }
}
