package org.arm.spring.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ArmSpringGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArmSpringGatewayApplication.class, args);
	}

}
