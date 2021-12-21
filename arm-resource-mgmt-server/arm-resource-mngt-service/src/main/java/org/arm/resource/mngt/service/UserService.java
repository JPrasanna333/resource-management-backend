package org.arm.resource.mngt.service;

import java.util.HashSet;
import java.util.Set;

import org.arm.resource.mngt.entity.Role;
import org.arm.resource.mngt.entity.Users;
import org.arm.resource.mngt.repository.RoleRepository;
import org.arm.resource.mngt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;

	public void initRoleAndUser() {
		Role role = roleRepository.findById("Admin").get();

		Users adminUser = new Users();
		adminUser.setUserName("admin");
		adminUser.setPassword(getEncodedPassword("admin"));
		adminUser.setFirstName("admin");
		adminUser.setLastName("admin");
		Set<Role> adminRoles = new HashSet<>();
		adminRoles.add(role);
		adminUser.setRole(adminRoles);
		userRepository.save(adminUser);
	}

	@Override
	public Users registerNewUser(Users user) {
		Role role = roleRepository.findById("User").get();

		Set<Role> userRoles = new HashSet<>();
		userRoles.add(role);
		user.setRole(userRoles);
		user.setPassword(getEncodedPassword(user.getPassword()));

		return userRepository.save(user);
	}

	@Override
	public String getEncodedPassword(String password) {
		return passwordEncoder.encode(password);
	}
}
