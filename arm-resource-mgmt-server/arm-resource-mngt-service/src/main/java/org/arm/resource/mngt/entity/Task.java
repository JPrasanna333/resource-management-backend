package org.arm.resource.mngt.entity;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
//@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int taskId;
	private String taskName;
	private String taskOwner;
	private Timestamp startDate;
	private Timestamp endDate;
	private float duration;
	@Enumerated(EnumType.STRING)
	private Priority priority;
	@Enumerated(EnumType.STRING)
	private Status status;
	private Timestamp createDate;
	private Timestamp updateDate;
	private int isDeleted;
	private String createdBy;
	private String updatedBy;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "projectId")
	private Project project;

	@ManyToOne
	@JoinColumn(name = "resourceId")
	private Resource resource;

	public Task(int taskId, String taskName, String taskOwner, Timestamp startDate, Timestamp endDate, float duration,
			Priority priority, Status status, Timestamp createDate, Timestamp updateDate, int isDeleted,
			String createdBy, String updatedBy, Project project, Resource resource) {
		super();
		this.taskId = taskId;
		this.taskName = taskName;
		this.taskOwner = taskOwner;
		this.startDate = startDate;
		this.endDate = endDate;
		this.duration = duration;
		this.priority = priority;
		this.status = status;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.isDeleted = isDeleted;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
		this.project = project;
		this.resource = resource;
	}

	
	

}
