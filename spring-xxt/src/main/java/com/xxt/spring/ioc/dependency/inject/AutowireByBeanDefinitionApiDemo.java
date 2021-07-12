package com.xxt.spring.ioc.dependency.inject;

import com.xxt.spring.ioc.domain.User;
import com.xxt.spring.ioc.domain.UserHolder;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * @author xxt
 * 依赖注入要讨论的问题：
 * 1.单个bean如何注入
 * 2.同类型的多个bean，为何注入的是primary
 * 3.集合类型的beans是如何让自动注入的
 * 4.通过CGLIB代理机制实现延迟加载的实现技术
 *
 * @description 通过beanDefinitionApi的形式进行依赖注入
 * @date 2021-07-07 22:19
 **/
public class AutowireByBeanDefinitionApiDemo {

	public static void main(String[] args) {
		final AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

		AnnotatedBeanDefinitionReader reader = new AnnotatedBeanDefinitionReader(applicationContext);

		reader.register(AutowireByBeanDefinitionApiDemo.class);

		final BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(UserHolder.class);
		builder.addPropertyReference("user", "user");
		final AbstractBeanDefinition beanDefinition = builder.getBeanDefinition();

		applicationContext.registerBeanDefinition("userHolder", beanDefinition);

		applicationContext.refresh();

		final UserHolder userHolder = applicationContext.getBean(UserHolder.class);

		System.out.println(userHolder);
	}

	@Bean
	public User user(){
		return new User("slb", 777);
	}

}
