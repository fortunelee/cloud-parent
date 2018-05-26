package com.cloud.service.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaApplication {
	
	// 服务注册发现中心 Eureka Service
	public static void main(String[] args) {
		SpringApplication.run(EurekaApplication.class, args);
	}
}
