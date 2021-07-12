package com.xxt.spring.ioc.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author xxt
 * @description
 * @date 2021-07-07 17:28
 **/
@Component
public class FiledUserHolder {

	@Autowired
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
