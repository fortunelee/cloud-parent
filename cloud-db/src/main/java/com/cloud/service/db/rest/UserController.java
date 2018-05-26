package com.cloud.service.db.rest;

import java.util.List;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.service.db.kafka.consumer.MsgConsumer;
import com.cloud.service.db.pojo.User;
import com.cloud.service.db.repository.UserRepository;

@RestController
public class UserController {
	
	Logger logger = Logger.getLogger(UserController.class);
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private MsgConsumer msgConsumer;
	
	@RequestMapping(value = "/find", method = RequestMethod.GET)
	public String findUser(@RequestParam("userid") String userid) {
		
		List<User> findAll = userRepository.findAll();
		return "ok";
	}

}