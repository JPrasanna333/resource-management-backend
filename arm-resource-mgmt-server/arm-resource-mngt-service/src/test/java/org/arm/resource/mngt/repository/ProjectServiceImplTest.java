package org.arm.resource.mngt.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.arm.resource.mngt.entity.Priority;
import org.arm.resource.mngt.entity.Project;
import org.arm.resource.mngt.entity.Status;
import org.arm.resource.mngt.service.ProjectService;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ProjectServiceImplTest {

	@InjectMocks
	private ProjectService projectService;

	@Mock
	private ProjectRepository projectRepository;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	@DisplayName("Testing get all Project")
	public void testGetAllProjects() {
		List<Project> project = new ArrayList<>();
		Project projectS = new Project(1, "avi", "avinash", Timestamp.valueOf("2020-03-27 09:03:01"),
				Timestamp.valueOf("2020-04-27 09:03:01"), Priority.HIGH, Status.DEFINED,
				Timestamp.valueOf("2021-11-24 12:08:27"), Timestamp.valueOf("2021-11-24 12:08:27"), 0, "Avinash",
				"ayan", null, null);
		project.add(projectS);
		Project projectS1 = new Project(2, "avi", "avinash", Timestamp.valueOf("2020-03-27 09:03:01"),
				Timestamp.valueOf("2020-04-27 09:03:01"), Priority.HIGH, Status.DEFINED,
				Timestamp.valueOf("2021-11-24 12:08:27"), Timestamp.valueOf("2021-11-24 12:08:27"), 0, "Avinash",
				"ayan", null, null);
		project.add(projectS1);

		when(projectRepository.findAll()).thenReturn(project);
		List<Project> actual = projectService.getAllProject();

		assertEquals(actual.size(), 2);

	}
	@Test
	@DisplayName("Testing save Project")
	public void testSaveProject() {
		Project project = new Project(1, "avi", "avinash", Timestamp.valueOf("2020-03-27 09:03:01"),
				Timestamp.valueOf("2020-04-27 09:03:01"), Priority.HIGH, Status.DEFINED,
				Timestamp.valueOf("2021-11-24 12:08:27"), Timestamp.valueOf("2021-11-24 12:08:27"), 0, "Avinash",
				"ayan", null, null);
		when(projectRepository.save(project)).thenReturn(project);
		projectService.save(project);
		verify(projectRepository,times(1)).save(project);

	}
	@Test
	@DisplayName("Testing get Project by id")
	public void testGetProjectById() {
		Project project = new Project(1, "avi", "avinash", Timestamp.valueOf("2020-03-27 09:03:01"),
				Timestamp.valueOf("2020-04-27 09:03:01"), Priority.HIGH, Status.DEFINED,
				Timestamp.valueOf("2021-11-24 12:08:27"), Timestamp.valueOf("2021-11-24 12:08:27"), 0, "Avinash",
				"ayan", null, null);
		when(projectRepository.findById(1)).thenReturn(Optional.of(project));
		assertEquals(projectService.getById(1), project);
	}

}