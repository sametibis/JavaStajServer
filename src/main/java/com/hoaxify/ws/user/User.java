package com.hoaxify.ws.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Entity
public class User {
	
	@Id
	@GeneratedValue
	private long id;
	
	@NotNull
	@Size(min = 4, max = 25)
	@UniqueUserName
	private String userName;
	
	@NotNull
	@Size(min = 4, max = 25)
	private String displayName;
	
	@NotNull
	@Size(min = 8, max = 255)
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$" )
	private String password;
	

	public User() {
		super();
	}

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
