package com.chainsys.foodorderproject.dto;

import org.springframework.stereotype.Repository;

@Repository
public class SignInDTO {
	private String userMailID;
	private String password;
	public String getUserMailID() {
		return userMailID;
	}
	public void setUserMailID(String userMailID) {
		this.userMailID = userMailID;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
