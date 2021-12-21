package org.your.reference.service.client;

import java.util.ArrayList;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.your.reference.service.entity.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@FeignClient(name = "RESOURCE-MNGT-SERVICE", fallback = EmpServiceClient.EmployeeClientFallback.class)
public interface EmpServiceClient {

	@Component
	static class EmployeeClientFallback implements EmpServiceClient {

		private static Logger logger = LoggerFactory.getLogger(EmpServiceClient.class);

		@Override
		public List<Employee> getEmlpoyees() {
			logger.info("From circuit breaker");
			List<Employee> emps = new ArrayList<Employee>();
			Employee e = new Employee();
			e.setName("Default Employee");
			emps.add(e);
			return emps;
		}

	}

	@GetMapping("/employees")
	public List<Employee> getEmlpoyees();
}
