package com.chainsys.foodorderproject.dto;

import org.springframework.stereotype.Repository;

@Repository
public class MainDTO {

	private int userID;
	private String userName;
	private String userPhoneNo;
	private String userMailID;
	private String userPassword;
	private String userAddress;

	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	
	public String getUserPhoneNo() {
		return userPhoneNo;
	}
	public void setUserPhoneNo(String userPhoneNo) {
		this.userPhoneNo = userPhoneNo;
	}
	public String getUserMailID() {
		return userMailID;
	}
	public void setUserMailID(String userMailID) {
		this.userMailID = userMailID;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
}
