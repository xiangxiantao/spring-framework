package com.xxt.spring.ioc.dependency.circular;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author xxt
 * @description
 * @date 2021-07-12 15:29
 **/
@Component
public class CircularBeanA {

	public CircularBeanA() {
	}

	@Autowired
	public CircularBeanA(CircularBeanB circularBeanB) {
		this.circularBeanB = circularBeanB;
	}

	private CircularBeanB circularBeanB;

	public CircularBeanB getCircularBeanB() {
		return circularBeanB;
	}

	public void setCircularBeanB(CircularBeanB circularBeanB) {
		this.circularBeanB = circularBeanB;
	}
}
