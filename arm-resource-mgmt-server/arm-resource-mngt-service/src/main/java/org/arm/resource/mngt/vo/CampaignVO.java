package org.arm.resource.mngt.vo;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import org.arm.resource.mngt.entity.Priority;
import org.arm.resource.mngt.entity.Status;
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
public class CampaignVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8386616996157565633L;

	@Id
	private int campaignId;
	private String campaignName;
	private String campaignOwner;
	private Timestamp startDate;
	private Timestamp endDate;
	@Enumerated(EnumType.STRING)
	private Priority priority;
	@Enumerated(EnumType.STRING)
	private Status status;
	private String region;
	@OneToMany(mappedBy = "campaignVO")
	@JsonManagedReference
	private List<ProjectVO> projects;

}
