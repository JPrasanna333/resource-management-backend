package org.your.reference.service.api;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.your.reference.service.client.EmpServiceClient;
import org.your.reference.service.entity.Employee;
import org.your.reference.service.impl.TestService;

@RestController
public class SampleApi {
	
	private static Logger logger = LoggerFactory.getLogger(SampleApi.class);
	
	@Autowired
	private EmpServiceClient empServiceClient;
	
	@Autowired
	private TestService testService;
	
	/**
	 * 
	 * @return
	 */
	@GetMapping("/emps")
	List<Employee> allEmployees() {
		logger.info("Sample service for feign client");
		return empServiceClient.getEmlpoyees();
	}
	
	@GetMapping("/testapi")
	public String testApi(){
		return testService.testMessage();
	}

}
