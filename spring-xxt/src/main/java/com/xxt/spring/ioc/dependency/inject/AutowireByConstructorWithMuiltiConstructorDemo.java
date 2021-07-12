package com.xxt.spring.ioc.dependency.inject;

import com.xxt.spring.ioc.domain.Admin;
import com.xxt.spring.ioc.domain.ManyUserHolder;
import com.xxt.spring.ioc.domain.User;
import com.xxt.spring.ioc.domain.UserHolder;
import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 *探究当由多个构造器标注了@Autowired时，用哪个
 * 结论：会报错BeanCreationException
 *
 * @author xxt
 * @description 通过构造器进行依赖注入的方式
 * @date 2021-07-07 14:27
 **/
@ComponentScan(value = {"com.xxt.spring.ioc.domain"})
public class AutowireByConstructorWithMuiltiConstructorDemo {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		AnnotatedBeanDefinitionReader reader = new AnnotatedBeanDefinitionReader(applicationContext);
		reader.register(AutowireByConstructorWithMuiltiConstructorDemo.class);

		applicationContext.refresh();

		final User user = applicationContext.getBean(User.class);
		final ManyUserHolder manyUserHolder = applicationContext.getBean(ManyUserHolder.class);
		System.out.println(user);
		System.out.println(manyUserHolder);
		System.out.println(manyUserHolder.getUser() == user);
	}

	@Bean
	public User user(){
		return new User("usb", 3);
	}

	@Bean
	public Admin admin(){
		return new Admin("admin", 22);
	}

}
