package com.xxt.spring.ioc.dependency.circular;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author xxt
 * @description
 * @date 2021-07-12 15:33
 **/
@ComponentScan("com.xxt.spring.ioc.dependency.circular")
public class CircularDependencyDemo {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(CircularDependencyDemo.class);
		final CircularBeanA circularBeanA = applicationContext.getBean(CircularBeanA.class);
		final CircularBeanB circularBeanB = applicationContext.getBean(CircularBeanB.class);
		System.out.println(circularBeanA);
		System.out.println(circularBeanB);
	}

}
