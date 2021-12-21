package org.arm.discovery.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class ArmEurekaServerApplication {
	public static void main(String[] args) {
		SpringApplication.run(ArmEurekaServerApplication.class, args);
	}
}
