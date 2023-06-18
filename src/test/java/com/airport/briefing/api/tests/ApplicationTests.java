package com.airport.briefing.api.tests;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@LocalServerPort
	private int port;

	@Test
	void contextLoads() {
	}

	@Test
	public void kausTest() throws Exception {
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/AirportBriefing?identifiers=KAUS",
				String.class)).contains("KAUS").contains("runways");
	}

	@Test
	public void kausKiahTest() throws Exception {
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/AirportBriefing?identifiers=KAUS,KIAH",
				String.class)).contains("KAUS").contains("KIAH").contains("runways");
	}

	@Test
	public void errorTest() throws Exception {
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/AirportBriefing",
				String.class)).contains("ERROR");
	}
}
