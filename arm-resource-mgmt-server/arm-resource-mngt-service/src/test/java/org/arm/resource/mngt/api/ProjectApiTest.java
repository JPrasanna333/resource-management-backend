package org.arm.resource.mngt.api;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.arm.resource.mngt.ArmRMSApplication;
import org.arm.resource.mngt.entity.Project;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

@SpringBootTest(classes = ArmRMSApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProjectApiTest {

	@LocalServerPort
	private int port;
	TestRestTemplate restTemplate = new TestRestTemplate();
	HttpHeaders headers = new HttpHeaders();

	@SuppressWarnings("all")
	@Test
	@DisplayName("getAllProjectApi Testing")
	public void testGetAllProject() {

		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
		ResponseEntity<List> response = restTemplate.exchange(createURLWithPort("/projects"), HttpMethod.GET, entity,
				List.class);

		assertEquals(response.getBody().size(), 6);

	}

	@Test
	@DisplayName("getProjectByIdApi Testing")
	public void testProjectById() {

		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
		ResponseEntity<Project> response = restTemplate.exchange(createURLWithPort("/projects/2"), HttpMethod.GET,
				entity, Project.class);
		System.out.println(response.getBody());
		assertEquals(response.getBody().getProjectId(), 2);

	}

	private String createURLWithPort(String uri) {
		return "http://localhost:" + port + uri;
	}
}