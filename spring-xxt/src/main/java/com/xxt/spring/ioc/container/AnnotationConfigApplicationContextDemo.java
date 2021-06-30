package com.xxt.spring.ioc.container;

import com.xxt.spring.ioc.config.SimpleConfig;
import com.xxt.spring.ioc.domain.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author xxt
 * @description
 * @date 2021-06-30 11:21
 **/
public class AnnotationConfigApplicationContextDemo {

	public static void main(String[] args) {
		final AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(SimpleConfig.class);
		User user = applicationContext.getBean(User.class);
		System.out.println("user:" + user);
	}
}
