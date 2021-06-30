package com.xxt.spring.ioc.config;

import com.xxt.spring.ioc.domain.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xxt
 * @description
 * @date 2021-06-30 11:22
 **/
@Configuration
public class SimpleConfig {

	@Bean
	public User user(){
		return new User("xgimi", 10);
	}

}
