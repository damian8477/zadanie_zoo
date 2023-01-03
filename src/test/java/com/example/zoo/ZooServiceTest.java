package com.example.zoo;


import com.example.zoo.constants.Constants;
import com.example.zoo.exception.PrzekroczonyLimitJedzeniaException;
import com.example.zoo.model.animal.Elephant;
import com.example.zoo.model.animal.Lion;
import com.example.zoo.model.animal.Rabbit;
import com.example.zoo.model.dto.AnimalsDTO;
import com.example.zoo.model.entity.Animals;
import com.example.zoo.model.entity.Zone;
import com.example.zoo.model.response.BasicResponse;
import com.example.zoo.repository.AnimalsRepository;
import com.example.zoo.repository.ZoneRepository;
import com.example.zoo.service.impl.ZooServiceImpl;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.ArgumentMatchers.anyInt;

@ExtendWith(MockitoExtension.class)
class ZooServiceTest {
    @Mock
    public ZoneRepository zoneRepository;

    @Mock
    public AnimalsRepository animalsRepository;

    @InjectMocks
    ZooServiceImpl tested;

    @Test
    void shouldAddElephantWhenZoneFoodQtyIsLessThanLimit() throws PrzekroczonyLimitJedzeniaException {
        //given
        Zone zone = new Zone();
        zone.setName("Example Zone");
        Elephant elephant = new Elephant("Example Elephant", 1);

        BasicResponse expected = new BasicResponse(true, Constants.ANIMAL_ADD);
        Mockito.when(zoneRepository.findById(anyInt())).thenReturn(zone);
        //when
        BasicResponse actual = tested.addElephant(elephant);
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    void shouldNotAddElephantWhenZoneNotExist() throws PrzekroczonyLimitJedzeniaException {
        //given
        Zone zone = new Zone();
        zone.setName("Example Zone");
        Elephant elephant = new Elephant("Example Elephant", 1);

        BasicResponse expected = new BasicResponse(false, Constants.ZONE_MISS);
        Mockito.when(zoneRepository.findById(anyInt())).thenReturn(null);
        //when
        BasicResponse actual = tested.addElephant(elephant);
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    void shouldNotAddElephantWhenZoneFoodQtyIsOverThanLimit() {
        //given
        Zone zone = new Zone();
        zone.setName("Example Zone");
        Elephant elephant = new Elephant("Example Elephant", 1);
        elephant.setFoodDemand(120.0);

        Mockito.when(zoneRepository.findById(anyInt())).thenReturn(zone);
        //when
        //then
        assertThatExceptionOfType(PrzekroczonyLimitJedzeniaException.class).isThrownBy(() -> tested.addElephant(elephant));
    }


    @Test
    void shouldAddLionWhenZoneFoodQtyIsLessThanLimit() throws PrzekroczonyLimitJedzeniaException {
        //given
        Zone zone = new Zone();
        zone.setName("Example Zone");
        Lion lion = new Lion("Example Lion", 1);

        BasicResponse expected = new BasicResponse(true, Constants.ANIMAL_ADD);
        Mockito.when(zoneRepository.findById(anyInt())).thenReturn(zone);
        //when
        BasicResponse actual = tested.addLion(lion);
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    void shouldNotAddLionWhenZoneNotExist() throws PrzekroczonyLimitJedzeniaException {
        //given
        Zone zone = new Zone();
        zone.setName("Example Zone");
        Lion lion = new Lion("Example Lion", 1);

        BasicResponse expected = new BasicResponse(false, Constants.ZONE_MISS);
        Mockito.when(zoneRepository.findById(anyInt())).thenReturn(null);
        //when
        BasicResponse actual = tested.addLion(lion);
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    void shouldNotAddLionWhenZoneFoodQtyIsOverThanLimit() {
        //given
        Zone zone = new Zone();
        zone.setName("Example Zone");
        Lion lion = new Lion("Example Lion", 1);
        lion.setFoodDemand(120.0);

        Mockito.when(zoneRepository.findById(anyInt())).thenReturn(zone);
        //when
        //then
        assertThatExceptionOfType(PrzekroczonyLimitJedzeniaException.class).isThrownBy(() -> tested.addLion(lion));
    }


    @Test
    void shouldAddRabbitWhenZoneFoodQtyIsLessThanLimit() throws PrzekroczonyLimitJedzeniaException {
        //given
        Zone zone = new Zone();
        zone.setName("Example Zone");
        Rabbit rabbit = new Rabbit("Example Rabbit", 1);

        BasicResponse expected = new BasicResponse(true, Constants.ANIMAL_ADD);
        Mockito.when(zoneRepository.findById(anyInt())).thenReturn(zone);
        //when
        BasicResponse actual = tested.addRabbit(rabbit);
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    void shouldNotAddRabbitWhenZoneNotExist() throws PrzekroczonyLimitJedzeniaException {
        //given
        Zone zone = new Zone();
        zone.setName("Example Zone");
        Rabbit rabbit = new Rabbit("Example Rabbit", 1);

        BasicResponse expected = new BasicResponse(false, Constants.ZONE_MISS);
        Mockito.when(zoneRepository.findById(anyInt())).thenReturn(null);
        //when
        BasicResponse actual = tested.addRabbit(rabbit);
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    void shouldNotAddRabbitWhenZoneFoodQtyIsOverThanLimit() {
        //given
        Zone zone = new Zone();
        zone.setName("Example Zone");
        Rabbit rabbit = new Rabbit("Example Rabbit", 1);
        rabbit.setFoodDemand(120.0);

        Mockito.when(zoneRepository.findById(anyInt())).thenReturn(zone);
        //when
        //then
        assertThatExceptionOfType(PrzekroczonyLimitJedzeniaException.class).isThrownBy(() -> tested.addRabbit(rabbit));
    }

    @Test
    void shouldGetAnimalsWhenZoneExist(){
        //given
        List<Animals> animalList = new ArrayList<>(List.of(new Animals(), new Animals(), new Animals()));

        List<AnimalsDTO> expected = new ArrayList<>(List.of(new AnimalsDTO(), new AnimalsDTO(), new AnimalsDTO()));

        Mockito.when(animalsRepository.findAllByZoneId(anyInt())).thenReturn(animalList);
        //when
        List<AnimalsDTO> actual = tested.getAnimalsZoneList(1).stream()
                .map(animals -> new ModelMapper().map(animals, AnimalsDTO.class))
                .collect(Collectors.toList());
        //then
        Assert.assertEquals(expected, actual);
    }
}
