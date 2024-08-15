package com.sunbeam;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import com.sunbeam.entities.Category;

//Integration Test : complete end to end testing
//creates a web app context (SC) using any available random free port.
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class RestControllerTestWithServer {
	// randomly available free port is injected in local server port
	// @Value("${local.server.port}")
	@LocalServerPort
	private int serverPort;
	// Abstraction of REST client to be used in test scenario
	@Autowired
	private TestRestTemplate template;

	@Test
	public void testGetCategoryDetails() {

		Category category = template.getForObject
				("http://localhost:" + serverPort + "/categories/1", Category.class);
		assertEquals("category1", category.getCategoryName());
		assertEquals(LocalDate.of(2024, 7, 9), category.getCreatedOn());
	}

}
