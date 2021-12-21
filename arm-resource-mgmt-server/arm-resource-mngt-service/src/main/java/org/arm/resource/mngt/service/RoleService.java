package org.arm.resource.mngt.service;

import org.arm.resource.mngt.entity.Role;
import org.arm.resource.mngt.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService implements IRoleService {
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public Role createNewRole(Role role) {
		return roleRepository.save(role);
	}

}
