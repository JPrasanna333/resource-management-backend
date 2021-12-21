package org.arm.resource.mngt.entity;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
//@AllArgsConstructor
@NoArgsConstructor
public class Project {

	@Id
	private int projectId;
	private String projectName;
	private String projectOwner;
	private Timestamp startDate;
	private Timestamp endDate;
	@Enumerated(EnumType.STRING)
	private Priority priority;
	@Enumerated(EnumType.STRING)
	private Status status;
	private Timestamp createDate;
	private Timestamp updateDate;
	private int isDeleted;
	private String createdBy;
	private String updatedBy;
	
	@ManyToOne
	@JoinColumn(name="campaignId")
	@JsonIgnore
	private Campaign campaign;
	
	@OneToMany(mappedBy="project")
	private Set<Task> tasks;

	public Project(int projectId, String projectName, String projectOwner, Timestamp startDate, Timestamp endDate,
			Priority priority, Status status, Timestamp createDate, Timestamp updateDate, int isDeleted,
			String createdBy, String updatedBy, Campaign campaign, Set<Task> tasks) {
		super();
		this.projectId = projectId;
		this.projectName = projectName;
		this.projectOwner = projectOwner;
		this.startDate = startDate;
		this.endDate = endDate;
		this.priority = priority;
		this.status = status;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.isDeleted = isDeleted;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
		this.campaign = campaign;
		this.tasks = tasks;
	}
	

	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", projectName=" + projectName + ", projectOwner=" + projectOwner
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", priority=" + priority + ", status=" + status
				+ ", createDate=" + createDate + ", updateDate=" + updateDate + ", isDeleted=" + isDeleted + "]";
	}

	
}
