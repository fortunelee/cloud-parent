package com.cloud.service.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@EnableEurekaClient
@SpringBootApplication
public class ZuulApplication {
	
	// cloud zuul路由服务
	public static void main(String[] args) {
		SpringApplication.run(ZuulApplication.class, args);
	}
}