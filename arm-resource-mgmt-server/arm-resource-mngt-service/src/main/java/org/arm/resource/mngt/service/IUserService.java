package org.arm.resource.mngt.service;

import org.arm.resource.mngt.entity.Users;

public interface IUserService {
	public Users registerNewUser(Users user);

	public String getEncodedPassword(String password);
}
