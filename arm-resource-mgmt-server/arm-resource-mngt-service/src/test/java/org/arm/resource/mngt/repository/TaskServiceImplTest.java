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

import org.arm.resource.mngt.entity.Priority;
import org.arm.resource.mngt.entity.Status;
import org.arm.resource.mngt.entity.Task;
import org.arm.resource.mngt.service.TaskService;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class TaskServiceImplTest {
	@InjectMocks
	private TaskService taskService;

	@Mock
	private TaskRepository taskRepository;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	@DisplayName("Testing getAllTask")
	public void testGetAllTask() {
		List<Task> taskList = new ArrayList<>();
		Task task = new Task(1, "Alpha", "Badal", Timestamp.valueOf("2020-03-27 09:03:01"),
				Timestamp.valueOf("2020-04-27 09:03:01"), 25, Priority.HIGH, Status.DEFINED,
				Timestamp.valueOf("2020-03-27 09:03:01"), Timestamp.valueOf("2020-03-27 09:03:01"), 1, "Prasanna",
				"Navin", null, null);
		taskList.add(task);

		when(taskRepository.findAll()).thenReturn(taskList);
		List<Task> actual = taskService.getAllTask();

		assertEquals(taskList, actual);

	}

	@Test
	@DisplayName("Testing getAllTask when no task is there")
	public void testGetAllTaskWhenNoTask() {
		List<Task> taskList = new ArrayList<>();
		when(taskRepository.findAll()).thenReturn(taskList);

		assertThrows(RuntimeException.class, () -> {
			taskService.getAllTask();
		});
	}

	@Test
	@DisplayName("Testing createTask")
	public void testCreateTask() {
		Task task = new Task(1, "Alpha", "Badal", Timestamp.valueOf("2020-03-27 09:03:01"),
				Timestamp.valueOf("2020-04-27 09:03:01"), 25, Priority.HIGH, Status.DEFINED,
				Timestamp.valueOf("2020-03-27 09:03:01"), Timestamp.valueOf("2020-03-27 09:03:01"), 1, "Prasanna",
				"Navin", null, null);
		when(taskRepository.save(task)).thenReturn(task);
		taskService.createTasks(task);
		verify(taskRepository, times(1)).save(task);

	}
	
	@Test
	@DisplayName("Testing getById")
	public void testGetTaskById() {
		 Task task =new Task(1, "Alpha", "Badal", Timestamp.valueOf("2020-03-27 09:03:01"),
				Timestamp.valueOf("2020-04-27 09:03:01"), 25, Priority.HIGH, Status.DEFINED,
				Timestamp.valueOf("2020-03-27 09:03:01"), Timestamp.valueOf("2020-03-27 09:03:01"), 1, "Prasanna",
				"Navin", null, null);
		when(taskRepository.findById(1)).thenReturn(Optional.of(task));
		Task actual = taskService.getById(1);
		verify(taskRepository, times(1)).findById(1);
		assertEquals(task, actual);
	}

	@Test
	@DisplayName("Testing getByDuration")
	public void testGetByDurationLessThan() {
		Task task1 = new Task(1, "Alpha", "Badal", Timestamp.valueOf("2020-03-27 09:03:01"),
				Timestamp.valueOf("2020-04-27 09:03:01"), 25, Priority.HIGH, Status.DEFINED,
				Timestamp.valueOf("2020-03-27 09:03:01"), Timestamp.valueOf("2020-03-27 09:03:01"), 1, "Prasanna",
				"Navin", null, null);
		Task task2 = new Task(2, "Beta", "Abdul", Timestamp.valueOf("2020-03-27 09:03:01"),
				Timestamp.valueOf("2020-04-27 09:03:01"), 65, Priority.HIGH, Status.DEFINED,
				Timestamp.valueOf("2020-03-27 09:03:01"), Timestamp.valueOf("2020-03-27 09:03:01"), 1, "Prasanna",
				"Navin", null, null);
		List<Task> taskList = Arrays.asList(task1, task2);
		when(taskRepository.findByDurationLessThan(70)).thenReturn(taskList);
		List<Task> actual = taskService.getByDurationLessThan(70);
		assertEquals(taskList, actual);

	}

	@Test
	@DisplayName("Testing getByDurationWhrnDurationisNotAvailable")
	public void testGetByDurationLessThanWhenDurationIsNotAvailable() {
		when(taskRepository.findByDurationLessThan(80)).thenReturn(new ArrayList<Task>());
		assertThrows(RuntimeException.class, () -> {
			taskService.getByDurationLessThan(80);
		});

	}

}