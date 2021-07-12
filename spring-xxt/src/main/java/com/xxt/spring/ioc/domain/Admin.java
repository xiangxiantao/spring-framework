package com.xxt.spring.ioc.domain;

/**
 * @author xxt
 * @description
 * @date 2021-06-30 11:23
 **/
public class Admin {

	private String name;

	private Integer age;

	public Admin(String name, Integer age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "User{" +
				"name='" + name + '\'' +
				", age=" + age +
				'}';
	}
}
