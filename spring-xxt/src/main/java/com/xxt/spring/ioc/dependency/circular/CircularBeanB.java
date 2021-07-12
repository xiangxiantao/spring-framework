package com.xxt.spring.ioc.dependency.circular;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author xxt
 * @description
 * @date 2021-07-12 15:29
 **/
@Component
public class CircularBeanB {

	public CircularBeanB() {
	}

	@Autowired
	public CircularBeanB(CircularBeanA circularBeanA) {
		this.circularBeanA = circularBeanA;
	}

	private CircularBeanA circularBeanA;

	public CircularBeanA getCircularBeanA() {
		return circularBeanA;
	}

	public void setCircularBeanA(CircularBeanA circularBeanA) {
		this.circularBeanA = circularBeanA;
	}
}
