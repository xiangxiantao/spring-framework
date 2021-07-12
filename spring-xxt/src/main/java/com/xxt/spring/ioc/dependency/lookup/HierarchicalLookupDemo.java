package com.xxt.spring.ioc.dependency.lookup;

import com.xxt.spring.ioc.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xxt
 * @description
 * @date 2021-07-07 10:08
 **/
public class HierarchicalLookupDemo {
	public static void main(String[] args) {
		final AnnotationConfigApplicationContext childApplicationContext = new AnnotationConfigApplicationContext();
		childApplicationContext.register(ChildConfig.class);
		childApplicationContext.getBeanFactory().setParentBeanFactory(createParentBeanFactory());
		childApplicationContext.refresh();

		System.out.println(childApplicationContext.containsBean("user"));

		lookupByType(childApplicationContext);

		lookupByName(childApplicationContext);
	}

	/**
	 * 先判断feanFactory是否有父beanFactory，并且parentBeanFactory中是否存在相应的bd
	 * containsBeanDefinition(beanName)
	 */
	private static void lookupByName(AnnotationConfigApplicationContext childApplicationContext) {
		final User user = (User) childApplicationContext.getBean("user");
		System.out.println(user);
	}

	/**
	 * 通过resolveBean，核心思路是先查找beanName，再通过getBean(beanName)查找bean
	 * 如果beanFactory没有查找到，从parentBeanFactory继续通过resolveBean查找
	 * @param childApplicationContext
	 */
	private static void lookupByType(AnnotationConfigApplicationContext childApplicationContext) {
		final User user = childApplicationContext.getBean(User.class);
		System.out.println(user);
	}


	private static BeanFactory createParentBeanFactory() {
		DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
		final AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition(User.class).addConstructorArgValue("xxt").addConstructorArgValue("20").getBeanDefinition();
		defaultListableBeanFactory.registerBeanDefinition("user", beanDefinition);
		return defaultListableBeanFactory;
	}


	@Configuration
	private static class ChildConfig {

		public ChildConfig() {
		}

	}

	@Configuration
	private static class ParentConfig {
		public ParentConfig() {
		}

		@Bean
		public User user() {
			return new User("xxt", 17);
		}
	}
}
