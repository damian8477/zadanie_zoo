package com.example.zoo;

import com.example.zoo.model.answer.BoolStringAnswer;
import com.example.zoo.model.db.Zone;
import com.example.zoo.service.impl.ZoneServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class ZooApplicationTests {

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
//		BoolStringAnswer expected = new BoolStringAnswer(true, "Strefa dodana");
//		//when
//		BoolStringAnswer actual = zoneService.addZone(Zone.builder().name("Test").build());
//		//then
//		Assertions.assertEquals(expected, actual);
//	}

}
