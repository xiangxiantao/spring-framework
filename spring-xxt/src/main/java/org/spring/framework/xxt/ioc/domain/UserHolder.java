package org.spring.framework.xxt.ioc.domain;

public class UserHolder {

	private User user;

	public UserHolder(User user) {
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	@Override
	public String toString() {
		return "UserHolder{" +
				"user=" + user +
				'}';
	}

	public void setUser(User user) {
		this.user = user;
	}
}
