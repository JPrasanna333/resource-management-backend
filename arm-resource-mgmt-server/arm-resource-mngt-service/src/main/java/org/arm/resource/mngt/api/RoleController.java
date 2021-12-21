package org.arm.resource.mngt.api;

import org.arm.resource.mngt.entity.Role;
import org.arm.resource.mngt.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleController {

	@Autowired
	private RoleService roleService;

	@PostMapping("/createNewRole")
	public Role createNewRole(@RequestBody Role role) {
		return roleService.createNewRole(role);
	}
}
