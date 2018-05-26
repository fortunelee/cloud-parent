package com.cloud.service.feign.service.impl;

import org.springframework.stereotype.Component;
import com.cloud.service.feign.service.UserFeignClient;

import feign.hystrix.FallbackFactory;



@Component
/*public class UserFeignClientHystric implements UserFeignClient{
	
	// Hystric 断路器
	public String findByUserid(int userid) {
		
		return "sorry "+userid;
	}

	@Override
	public String find(int userid) {
		return null;
	}

	
}*/
public class UserFeignClientHystric implements FallbackFactory<UserFeignClient> {
	
		public UserFeignClient create(Throwable arg0) {
			return new UserFeignClient(){

			public String findByUserid(int userid) {
				return "sorry,do not visit";
			}

			public String find(int userid) {
				return "sorry,do not visit";
			}
		};
	}
}
	
