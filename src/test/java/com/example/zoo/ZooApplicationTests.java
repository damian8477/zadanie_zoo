package com.example.zoo;

import com.example.zoo.model.entity.Zone;
import com.example.zoo.model.response.BasicResponse;
import com.example.zoo.service.impl.ZoneServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

class ZooApplicationTests {

	ZooApplicationTests(ZoneServiceImpl zoneService) {
		this.zoneService = zoneService;
	}

	@Test
	void contextLoads() {
	}

	private final ZoneServiceImpl zoneService;


	@Test
	void setIfAddZoneCorrect() throws IOException {
		//given
		BasicResponse expected = new BasicResponse(true, "Strefa dodana");
		//when
        BasicResponse actual = zoneService.addZone(Zone.builder().name("Test").build());
		//then
		Assertions.assertEquals(expected, actual);
	}

}
