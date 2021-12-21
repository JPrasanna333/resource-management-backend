package org.arm.resource.mngt.entity;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
//@AllArgsConstructor
@NoArgsConstructor
public class ApiErrors {
	
	LocalDateTime timestamp;
	String message;
	int status;
	String error;
	public ApiErrors(LocalDateTime timestamp, String message, int status, String error) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.status = status;
		this.error = error;
	}
	
}
