package com.xxt.spring.ioc.dependency.inject;

import com.xxt.spring.ioc.domain.SetterUserHolder;
import com.xxt.spring.ioc.domain.User;
import com.xxt.spring.ioc.domain.UserHolder;
import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author xxt
 * @description
 * @date 2021-07-07 17:29
 **/
@ComponentScan(value = {"com.xxt.spring.ioc.domain"})
public class AutowireBySetterDemo {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		AnnotatedBeanDefinitionReader reader = new AnnotatedBeanDefinitionReader(applicationContext);
		reader.register(AutowireBySetterDemo.class);

		applicationContext.refresh();

		final User user = applicationContext.getBean(User.class);
		final SetterUserHolder setterUserHolder = applicationContext.getBean(SetterUserHolder.class);
		System.out.println(user);
		System.out.println(setterUserHolder);
		System.out.println(setterUserHolder.getUser() == user);
	}

	@Bean
	public User user(){
		return new User("usb", 3);
	}
}
