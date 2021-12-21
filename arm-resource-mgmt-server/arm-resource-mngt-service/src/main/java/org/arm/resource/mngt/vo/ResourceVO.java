package org.arm.resource.mngt.vo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.arm.resource.mngt.entity.Availability;
import org.arm.resource.mngt.entity.Leaves;

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
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ResourceVO implements Serializable {

	/**
	* 
	*/
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int resourceId;
	private String resourceName;
	private String resourceType;

	@OneToMany(mappedBy = "resource")
	@JsonBackReference
	private List<TaskVO> taskList;
	private String resourceImage;
	private String region;
	
	@OneToOne
	@JoinColumn(name="availableId")
	private Availability availability;
	
	@OneToOne
	@JoinColumn(name="leaveId")
	private Leaves leave;

}
