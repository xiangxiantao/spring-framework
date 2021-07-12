package com.xxt.spring.ioc.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author xxt
 * @description
 * @date 2021-07-07 14:27
 **/
//@Component
public class ManyUserHolder {

	private User user;

	private Admin admin;

	@Autowired
	public ManyUserHolder(User user) {
		this.user = user;
	}

	@Autowired
	public ManyUserHolder(User user, Admin admin) {
		this.user = user;
		this.admin = admin;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "UserHolder{" +
				"user=" + user +
				'}';
	}
}
