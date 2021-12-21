package org.your.reference.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableCircuitBreaker
@EnableEurekaClient
@EnableFeignClients
@EnableHystrixDashboard
@EnableHystrix
@EnableJpaRepositories
@SpringBootApplication
public class RefServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RefServiceApplication.class, args);
	}
}
