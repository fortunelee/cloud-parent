package com.cloud.service.feign.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cloud.service.feign.service.impl.UserFeignClientHystric;

@FeignClient(value = "db-config",fallbackFactory = UserFeignClientHystric.class)
public interface UserFeignClient {
	
	
	
	@RequestMapping(value = "/user/search/findByUserid", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String findByUserid(@RequestParam("userid") int userid);
	
	@RequestMapping(value = "/find", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String find(@RequestParam("userid") int userid);
}