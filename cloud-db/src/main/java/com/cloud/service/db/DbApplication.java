package com.cloud.service.db;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class DbApplication {
	
	
	public static void main(String[] args) {
		// 提供DB服务
		SpringApplication.run(DbApplication.class, args);
	}
	
}
