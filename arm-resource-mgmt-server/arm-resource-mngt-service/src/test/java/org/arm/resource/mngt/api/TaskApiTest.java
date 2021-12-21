package org.arm.resource.mngt.api;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.arm.resource.mngt.ArmRMSApplication;
import org.arm.resource.mngt.entity.Task;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

@SpringBootTest(classes = ArmRMSApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TaskApiTest {
	@LocalServerPort
	private int port;
	TestRestTemplate restTemplate = new TestRestTemplate();
	HttpHeaders headers = new HttpHeaders();

	@Test
	@SuppressWarnings("all")
	@DisplayName("getAllTaskApi Testing")
	public void testGetAllTask() {

		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
		ResponseEntity<List> response = restTemplate.exchange(createURLWithPort("/tasks"), HttpMethod.GET, entity,
				List.class);

		assertEquals(response.getBody().size(), 9);

	}

	@Test
	@DisplayName("getTaskByIdApi Testing")
	public void testGetTaskById() {

		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
		ResponseEntity<Task> response = restTemplate.exchange(createURLWithPort("/tasks/4"), HttpMethod.GET, entity,
				Task.class);

		assertEquals(response.getBody().getTaskId(), 4);

	}

	@Test
	@DisplayName("getTasksByDurationLessThan Testing")
	public void testfindByDurationLessThan() {

		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
		ResponseEntity<List<Task>> response = restTemplate.exchange(createURLWithPort("/tasks/availability/80"),
				HttpMethod.GET, entity, new ParameterizedTypeReference<List<Task>>() {
				});
		List<Task> taskList = response.getBody();
		assertEquals(taskList.size(), 8);

	}

	private String createURLWithPort(String uri) {
		return "http://localhost:" + port + uri;
	}
}
