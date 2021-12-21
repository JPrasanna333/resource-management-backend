package org.arm.resource.mngt.vo;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import org.arm.resource.mngt.entity.Priority;
import org.arm.resource.mngt.entity.Status;
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
@AllArgsConstructor
@NoArgsConstructor
public class ProjectVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6508299485922031642L;

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
	
	@OneToMany(mappedBy="projectVO")
	@JsonManagedReference
	private List<TaskVO> tasks;
	
	@ManyToOne
	@JoinColumn(name = "campaignId")
	@JsonBackReference
	private CampaignVO campaignVO;

}
