package org.spring.framework.xxt.ioc.container;

import org.spring.framework.xxt.ioc.domain.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 探究spring启动流程
 */
public class AnnotationConfigApplicationContextDemo {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(SimpleConfig.class);
		User user = applicationContext.getBean(User.class);
		System.out.println(user);
	}
}
