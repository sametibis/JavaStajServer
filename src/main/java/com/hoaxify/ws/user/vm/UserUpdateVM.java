package com.hoaxify.ws.user.vm;

public class UserUpdateVM {
	private String displayName;

	public UserUpdateVM(String displayName) {
		super();
		this.displayName = displayName;
	}

	public UserUpdateVM() {
		super();
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	
	

}
