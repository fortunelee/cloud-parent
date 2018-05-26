package com.cloud.service.feign.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.service.feign.kafka.producer.MsgProducer;
import com.cloud.service.feign.service.UserFeignClient;
@RestController
public class UserController{
	
	@Autowired
	private UserFeignClient userFeignClient;
	
	@Autowired
    private KafkaTemplate<Integer, String> kafkaTemplate;
	
	@Autowired
	private MsgProducer msgProducer;
	
	@ResponseBody
	@RequestMapping(value="/find",method=RequestMethod.GET)
	public String findByUserid(@RequestParam int userid){
		
		//String findByUserid = userFeignClient.findByUserid(userid);
		String findByUserid = userFeignClient.find(userid);
		ListenableFuture<SendResult<Integer, String>> sendDefault = kafkaTemplate.sendDefault(String.valueOf(userid));
		sendDefault.toString();
		return findByUserid;
	}
	
}