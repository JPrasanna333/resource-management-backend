package org.arm.resource.mngt.repository;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Timestamp;
import java.util.List;

import org.arm.resource.mngt.ArmRMSApplication;
import org.arm.resource.mngt.entity.Priority;
import org.arm.resource.mngt.entity.Project;
import org.arm.resource.mngt.entity.Status;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = ArmRMSApplication.class)
public class ProjectsRepositoryTest {

	@Autowired
	private ProjectRepository projectRepository;

	@Test
	public void testSaveMethod() {

	Project project=	projectRepository.save(new Project(1, "avi", "avinash", Timestamp.valueOf("2020-03-27 09:03:01"),
				Timestamp.valueOf("2020-04-27 09:03:01"), Priority.HIGH, Status.DEFINED,
				Timestamp.valueOf("2021-11-24 12:08:27"), Timestamp.valueOf("2021-11-24 12:08:27"), 0, "Avinash",
				"ayan", null, null));
	assertNotNull(project);
	}

	@Test
	public void testGetAllProject() {
		List<Project> exp = projectRepository.findAll();
		assertEquals(exp.size(), 6);
	}

}
