package org.arm.resource.mngt.api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.arm.resource.mngt.entity.Task;
import org.arm.resource.mngt.exception.TaskNotFoundException;
import org.arm.resource.mngt.service.ITaskService;
import org.arm.resource.mngt.vo.TaskVO;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {
	@Autowired
	private ITaskService taskService;

	/**
	 * gets task by id
	 * @param id
	 * @return task object
	 */
	@GetMapping("/tasks/{task-id}")
	Task getById(@PathVariable("task-id") int id) {
		return taskService.getById(id);
	}

	@GetMapping("/tasks/project/{project-id}")
	public List<Task> getTasksByProjectId(@PathVariable("project-id") int projectId) {
		return taskService.getTasksByProjectId(projectId);
	}
	/**
	 * gets all task,resource(if available)
	 * and filtering unwanted columns i.e., using ResourceVO
	 * @return TaskVO list object as response entity
	 * @throws TaskNotFoundException
	 */
	@GetMapping("/tasks")
	public List<TaskVO> allTaskVO() throws TaskNotFoundException {
		List<TaskVO> taskVOs = new ArrayList<TaskVO>();
		List<Task> allTasks = taskService.getAllTask();
		for (Task task : allTasks) {
			DozerBeanMapper dozerBeanMapper = new DozerBeanMapper();
			dozerBeanMapper.setMappingFiles(Arrays.asList("mapping\\mapper.xml"));
			TaskVO taskVO = dozerBeanMapper.map(task, TaskVO.class);
			taskVOs.add(taskVO);
		}
		return taskVOs;
	}


	/**
	 * gets all tasks which is less than availableHours
	 * @param availableHours
	 * @return Task list object as response entity
	 * @throws TaskNotFoundException
	 */
	@GetMapping("/tasks/availability/{available-hour}")
	ResponseEntity<List<Task>> findByDurationLessThan(@PathVariable("available-hour") float availableHours)throws TaskNotFoundException {
		List<Task> taskList = taskService.getByDurationLessThan(availableHours);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Get Brandlist By Name");
		return ResponseEntity.ok().headers(headers).body(taskList);

	}
}
