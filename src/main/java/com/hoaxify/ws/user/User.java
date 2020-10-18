package com.hoaxify.ws.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;


@Entity
public class User {
	
	@Id
	@GeneratedValue
	private long id;
	@NotNull
	private String userName;
	@NotNull
	private String displayName;
	private String password;

	public User(String userName, String displayName, String password) {
		super();
		this.userName = userName;
		this.displayName = displayName;
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getDisplayName() {
		return displayName;
	}


	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return "User [userName=" + userName + ", displayName=" + displayName + ", password=" + password + "]";
	}
	
	
}
