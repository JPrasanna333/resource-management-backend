package org.arm.resource.mngt.repository;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Timestamp;
import java.util.List;

import org.arm.resource.mngt.ArmRMSApplication;
import org.arm.resource.mngt.entity.Priority;
import org.arm.resource.mngt.entity.Status;
import org.arm.resource.mngt.entity.Task;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest(classes = ArmRMSApplication.class)
public class TaskRepositoryTest {

	@Autowired
	private TaskRepository taskRepository;

	@Test
	@DisplayName("TaskSave test")
	public void taskSaveMethodTest() {
		Task task=taskRepository.save(new Task(1, "Alpha", "Emma", Timestamp.valueOf("2021-05-13 09:03:01"),
				Timestamp.valueOf("2021-05-19 14:30:01"), 24, Priority.HIGH, Status.COMPLETED,
				Timestamp.valueOf("2021-05-13 09:03:01"), null, 0, null, null, null, null));
		assertNotNull(task);
	}

	@Test
	@DisplayName("getAllTaskRepo Testing")
	public void testGetAllResource() {
		List<Task> exp = taskRepository.findAll();
		assertEquals(exp.size(), 9);
	}
}
