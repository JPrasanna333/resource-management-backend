package org.arm.resource.mngt.api;

import org.arm.resource.mngt.entity.JwtRequest;
import org.arm.resource.mngt.entity.JwtResponse;
import org.arm.resource.mngt.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JwtController {
	@Autowired
	private JwtService jwtService;

	@PostMapping("/authenticate")
	public JwtResponse createJwtToken(@RequestBody JwtRequest jwtRequest) throws Exception {
		return jwtService.createJwtToken(jwtRequest);
	}

}
