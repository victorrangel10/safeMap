package br.com.safemap.safemap;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import br.com.safemap.entity.Event;




@SpringBootTest
class SafemapApplicationTests {
	@Autowired
	private WebTestClient webTestClient;

	@Test
	void testeCreate() {
		var event = new Event("furto", "agressivo", -20.33, -40.2, 5);

		webTestClient
		.post()
		.uri("/events")
		.bodyValue(event)
		.exchange()
		.expectStatus().isOk()
		.expectBody(Event.class)
		.value(e -> {
			assert e.getId() != null;
			assert e.getCategory().equals("furto");
			assert e.getDescription().equals("agressivo");
			assert e.getLatitude() == -20.33;
			assert e.getLongitude() == -40.2;
			assert e.getSeverity() == 5;
		});		
		
	}

}
