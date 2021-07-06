package com.xxt.spring.ioc.container;

import com.xxt.spring.ioc.config.SimpleConfig;
import com.xxt.spring.ioc.domain.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author xxt
 * @description
 * @date 2021-07-06 15:16
 **/
public class BeanDefinitionRegistryPostProcessorDemo {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		applicationContext.register(SimpleConfig.class);
		applicationContext.addBeanFactoryPostProcessor(new BeanDefinitionRegistryPostProcessor() {
			@Override
			public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
				System.out.println("我自己定义的postProcessBeanDefinitionRegistry被调用了");
			}

			@Override
			public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
				System.out.println("我自己定义的postProcessBeanFactory被调用了");

			}
		});
		applicationContext.refresh();
		User user = applicationContext.getBean(User.class);
		System.out.println("user:" + user);
	}

}
