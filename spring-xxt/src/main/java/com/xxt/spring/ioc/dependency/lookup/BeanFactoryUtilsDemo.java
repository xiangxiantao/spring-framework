package com.xxt.spring.ioc.dependency.lookup;

import com.xxt.spring.ioc.domain.User;
import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

/**
 * @author xxt
 * @description
 * @date 2021-07-07 14:01
 **/
public class BeanFactoryUtilsDemo {

	public static void main(String[] args) {

		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
		final AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition(User.class).addConstructorArgValue("zsh").addConstructorArgValue("50").getBeanDefinition();
		beanFactory.registerBeanDefinition("user", beanDefinition);

		final User user = BeanFactoryUtils.beanOfType(beanFactory, User.class);

		System.out.println(user);
	}

}
