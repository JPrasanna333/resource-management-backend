package org.arm.resource.mngt.entity;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Resource {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int resourceId;
	private String resourceName;
	private String resourceType;
	private Timestamp createDate;
	private Timestamp updateDate;
	private int isDeleted;
		
	@OneToMany(mappedBy="resource")
	@JsonIgnore
	private List<Task> taskList;
	private String resourceImage;
	private String region;
	@OneToOne
	@JoinColumn(name="availableId")
	private Availability availability;
	
	@OneToOne
	@JoinColumn(name="leaveId")
	private Leaves leave;

	
}
