package org.arm.resource.mngt.entity;

import lombok.Data;

@Data
public class JwtRequest {
	private String userName;
	private String password;

}
