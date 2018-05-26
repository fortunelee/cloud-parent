package com.cloud.service.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableConfigServer
@EnableEurekaClient
public class ConfigServiceApplication {

	public static void main(String[] args) {
		// config 配置服务
		SpringApplication.run(ConfigServiceApplication.class, args);
	}
}
