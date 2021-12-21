package org.arm.resource.mngt.entity;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
public class Availability {

	@Id
	private int availableId;
	private String availableType;
	private int availableHours;
	private Timestamp startDate;
	private Timestamp endDate;
	@Enumerated(EnumType.STRING)
	private AvailableStatus availableStatus;
	@JsonIgnore
	private Timestamp createDate;
	@JsonIgnore
	private Timestamp updateDate;
	@JsonIgnore
	private int isDeleted;
	
}
