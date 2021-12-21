package org.arm.resource.mngt.api;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.arm.resource.mngt.ArmRMSApplication;
import org.arm.resource.mngt.entity.Resource;
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
public class ResourceApiTest {

	@LocalServerPort
	private int port;
	TestRestTemplate restTemplate = new TestRestTemplate();
	HttpHeaders headers = new HttpHeaders();

	@SuppressWarnings("all")
	@Test
	@DisplayName("getAllResourceApi Testing")
	public void testGetAllResource() {

		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
		ResponseEntity<List> response = restTemplate.exchange(createURLWithPort("/resources"), HttpMethod.GET, entity,
				List.class);

		assertEquals(response.getBody().size(), 28);

	}

	@Test
	@DisplayName("getResourceByIdApi Testing")
	public void testResourceById() {

		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
		ResponseEntity<Resource> response = restTemplate.exchange(createURLWithPort("/resources/3"), HttpMethod.GET,
				entity, Resource.class);

		assertEquals(response.getBody().getResourceId(), 3);

	}

	@Test
	@DisplayName("getAllResourceWithoutTaskApi Testing")
	public void testResourcesWithoutTask() {

		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
		ResponseEntity<List<Resource>> response = restTemplate.exchange(createURLWithPort("/resources/without-task"),
				HttpMethod.GET, entity, new ParameterizedTypeReference<List<Resource>>() {
				});
		List<Resource> resourcesWithoutTaskList = response.getBody();
		assertNull(resourcesWithoutTaskList.get(0).getTaskList());

	}

	private String createURLWithPort(String uri) {
		return "http://localhost:" + port + uri;
	}
//	@SuppressWarnings("deprecation")
//	@Test
//	@DisplayName("getAllResourceWithTaskApi Testing")
//	public void testResourcesWithTask() {
//
//		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
//		ResponseEntity<List<Resource>> response = restTemplate.exchange(createURLWithPort("/resources/without-task"), HttpMethod.GET,
//				entity, new ParameterizedTypeReference<List<Resource>>() {});
//		List<Resource> resourcesWithoutTaskList=response.getBody();
//		assertTrue(resourcesWithoutTaskList.isEmpty());
//
//	}

}
