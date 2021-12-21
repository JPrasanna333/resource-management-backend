package org.arm.resource.mngt.service;

import java.util.List;

import org.arm.resource.mngt.entity.Task;
import org.arm.resource.mngt.exception.IDNotFoundException;
import org.arm.resource.mngt.exception.TaskNotFoundException;

public interface ITaskService {

	public List<Task> getAllTask() throws TaskNotFoundException;
	
	Task getById(int id) throws IDNotFoundException;

	public void createTasks(Task tasks);
	
	List<Task> getByDurationLessThan(float availableHours) throws TaskNotFoundException;

	List<Task> getTasksByProjectId(int projectId);
}
