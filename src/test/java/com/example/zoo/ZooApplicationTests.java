package com.example.zoo;

import com.example.zoo.constants.Constants;
import com.example.zoo.exception.PrzekroczonyLimitJedzeniaException;
import com.example.zoo.model.animal.Elephant;
import com.example.zoo.model.entity.Animals;
import com.example.zoo.model.entity.Zone;
import com.example.zoo.model.response.BasicResponse;
import com.example.zoo.repository.AnimalsRepository;
import com.example.zoo.repository.ZoneRepository;
import com.example.zoo.service.impl.ZoneServiceImpl;
import com.example.zoo.service.impl.ZooServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BooleanSupplier;

import static java.util.Objects.isNull;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

class ZooApplicationTests {

	@Test
	   void testfirt(){
			var mockTest = mock(ZoneRepository.class);
			when(mockTest.findByName("elmo")).thenReturn(new Zone());
		   assertFalse(isNull(mockTest.findByName("elmo")));
		}

	@Test
	void testMock() throws PrzekroczonyLimitJedzeniaException {

		ZooServiceImpl zooService = mock(ZooServiceImpl.class);

		Elephant elephant = new Elephant("Elmo", 1);

		//when(zooService.addElephant(elephant2)).thenThrow(PrzekroczonyLimitJedzeniaException.class);
		//assertThatExceptionOfType(PrzekroczonyLimitJedzeniaException.class).isThrownBy(() -> zooService.addElephant(elephant));
		when(zooService.addElephant(elephant)).thenReturn(new BasicResponse(true, Constants.ANIMAL_ADD));

		assertTrue(zooService.addElephant(elephant).isBool());
	}
//	ZooApplicationTests(ZoneServiceImpl zoneService) {
//		this.zoneService = zoneService;
//	}
//
//	@Test
//	void contextLoads() {
//	}
//
//	private final ZoneServiceImpl zoneService;
//
//
//	@Test
//	void setIfAddZoneCorrect() throws IOException {
//		//given
//		BasicResponse expected = new BasicResponse(true, "Strefa dodana");
//		//when
//        BasicResponse actual = zoneService.addZone(Zone.builder().name("Test").build());
//		//then
//		Assertions.assertEquals(expected, actual);
//	}

}
