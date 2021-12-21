package org.your.reference.service.impl;

import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService{

	@Override
	public String testMessage() {
		return "Hi";
	}

}
