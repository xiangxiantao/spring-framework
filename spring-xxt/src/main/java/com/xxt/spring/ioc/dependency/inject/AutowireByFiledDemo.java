package com.xxt.spring.ioc.dependency.inject;

import com.xxt.spring.ioc.domain.FiledUserHolder;
import com.xxt.spring.ioc.domain.SetterUserHolder;
import com.xxt.spring.ioc.domain.User;
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
public class AutowireByFiledDemo {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		AnnotatedBeanDefinitionReader reader = new AnnotatedBeanDefinitionReader(applicationContext);
		reader.register(AutowireByFiledDemo.class);

		applicationContext.refresh();

		final User user = applicationContext.getBean(User.class);
		final FiledUserHolder filedUserHolder = applicationContext.getBean(FiledUserHolder.class);
		System.out.println(user);
		System.out.println(filedUserHolder);
		System.out.println(filedUserHolder.getUser() == user);
	}

	@Bean
	public User user(){
		return new User("usb", 65);
	}
}
