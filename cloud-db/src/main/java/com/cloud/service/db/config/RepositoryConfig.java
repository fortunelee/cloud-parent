package com.cloud.service.db.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;
import com.cloud.service.db.pojo.User;



@Configuration
public class RepositoryConfig extends RepositoryRestConfigurerAdapter {
	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {

//		config.exposeIdsFor(AccessToken.class);
		config.exposeIdsFor(User.class);
	}
}
