package org.spring.framework.xxt.ioc.container;

import org.spring.framework.xxt.ioc.domain.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
@Lazy(value = false)
public class SimpleConfig {

	@Bean
	public User user() {
		return new User("xxt", 19);
	}

}
