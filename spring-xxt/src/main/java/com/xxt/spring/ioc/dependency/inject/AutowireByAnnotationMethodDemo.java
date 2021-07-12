package com.xxt.spring.ioc.dependency.inject;

import com.xxt.spring.ioc.domain.User;
import com.xxt.spring.ioc.domain.UserHolder;
import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * 通过下面例子的结果：System.out.println(userHolder.getUser() == user); 返回ture，说明构造器依赖注入成功了
 * 第一步：先确定在初始化userHolder对象时，user对象是怎样从哪获取的，又是从哪传进去的
 *
 * @author xxt
 * @description 通过构造器进行依赖注入的方式
 * @date 2021-07-07 14:27
 **/
public class AutowireByAnnotationMethodDemo {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		AnnotatedBeanDefinitionReader reader = new AnnotatedBeanDefinitionReader(applicationContext);
		reader.register(AutowireByAnnotationMethodDemo.class);

		applicationContext.refresh();

		final User user = applicationContext.getBean(User.class);
		final UserHolder userHolder = applicationContext.getBean(UserHolder.class);
		System.out.println(user);
		System.out.println(userHolder);
		System.out.println(userHolder.getUser() == user);
	}

	@Bean
	public User user() {
		return new User("usb", 3);
	}

	@Bean
	public UserHolder userHolder(User user) {
		return new UserHolder(user);
	}

}
