package org.arm.resource.mngt.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.arm.resource.mngt.entity.Resource;
import org.arm.resource.mngt.entity.Task;
import org.arm.resource.mngt.service.ResourceService;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ResourceServiceImplTest {

	@InjectMocks
	private ResourceService resourceService;

	@Mock
	private ResourceRepository resourceRepository;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	@DisplayName("Testing get all resources")
	public void testGetAllResources() {
		List<Resource> resourceList = new ArrayList<>();
		Resource resource = (new Resource(1, "Navin", "Manager", Timestamp.valueOf("2020-03-27 09:03:01"),
				Timestamp.valueOf("2020-04-27 09:03:01"), 0, null, "resource.jpj", "Madras", null, null));
		resourceList.add(resource);

		when(resourceRepository.findAll()).thenReturn(resourceList);
		List<Resource> actual = resourceService.findAll();

		assertEquals(actual.size(), 1);

	}

	@Test
	@DisplayName("Testing get all resources when no resource is present")
	public void testGetAllResourcesWhenNoResource() {
		when(resourceRepository.findAll()).thenReturn(new ArrayList<Resource>());
		assertThrows(RuntimeException.class, () -> {
			resourceService.findAll();
		});

	}

	@Test
	@DisplayName("Testing save resource")
	public void testSaveResources() {
		Resource resource = (new Resource(1, "Navin", "Manager", Timestamp.valueOf("2020-03-27 09:03:01"),
				Timestamp.valueOf("2020-04-27 09:03:01"), 0, null, "resource.jpj", "Madras", null, null));

		when(resourceRepository.save(resource)).thenReturn(resource);
		resourceService.save(resource);
		verify(resourceRepository, times(1)).save(resource);

	}

	@Test
	@DisplayName("Testing get resource by id")
	public void testResourceById() {
		Resource resource = new Resource(1, "Navin", "Manager", Timestamp.valueOf("2020-03-27 09:03:01"),
				Timestamp.valueOf("2020-04-27 09:03:01"), 0, null, "resource.jpj", "Madras", null, null);

		when(resourceRepository.findById(1)).thenReturn(Optional.of(resource));
		assertEquals(resourceService.getById(1), resource);
	}

	@Test
	@DisplayName("Testing get all resources without task")
	public void testGetAllResourcesWithoutTask() {

		Resource resource1 = new Resource(1, "Navin", "Manager", Timestamp.valueOf("2020-03-27 09:03:01"),
				Timestamp.valueOf("2020-04-27 09:03:01"), 0, new ArrayList<Task>(), "resource.jpj", "Madras", null,
				null);
		Resource resource2 = new Resource(1, "Navin", "Manager", Timestamp.valueOf("2020-03-27 09:03:01"),
				Timestamp.valueOf("2020-04-27 09:03:01"), 0, new ArrayList<Task>(), "resource.jpj", "Madras", null,
				null);
		List<Resource> resourceList = Arrays.asList(resource1, resource2);

		when(resourceRepository.getResourceWithoutTaskAssigned()).thenReturn(resourceList);
		List<Resource> actual = resourceService.findResourceWithoutTaskAssigned();

		assertEquals(resourceList, actual);

	}

	@Test
	@DisplayName("Testing get all resources without task is empty")
	public void testGetAllResourcesWithoutTaskIsEmpty() {
		when(resourceRepository.getResourceWithoutTaskAssigned()).thenReturn(new ArrayList<Resource>());
		assertThrows(RuntimeException.class, () -> {
			resourceService.findResourceWithoutTaskAssigned();
		});

	}

}