package org.arm.resource.mngt.repository;

import java.util.List;

import org.arm.resource.mngt.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {

	List<Task> findByDurationLessThan(float availableHours);
	List<Task> findByProjectProjectId(int projectId);
}
