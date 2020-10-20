package com.hoaxify.ws.user.vm;

import com.hoaxify.ws.user.User;

public class UserVM {
	private String username;
	private String displayName;
	private String image;
	
	public UserVM() {
		super();
	}
	
	public UserVM(User user) {
		this.setUsername(user.getUsername());
		this.setDisplayName(user.getDisplayName());
		this.setImage(user.getImage());
	}
	
	public UserVM(String username, String displayName, String image) {
		super();
		this.username = username;
		this.displayName = displayName;
		this.image = image;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
}
