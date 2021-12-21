package org.arm.resource.mngt.vo;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import org.arm.resource.mngt.entity.Priority;
import org.arm.resource.mngt.entity.Status;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TaskVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6006685066263382760L;

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

	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name = "projectId")
	private ProjectVO projectVO;
	
	@ManyToOne
	@JoinColumn(name = "resourceId")
	private ResourceVO resource;

}
