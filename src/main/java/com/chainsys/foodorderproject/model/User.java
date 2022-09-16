package com.chainsys.foodorderproject.model;

import org.springframework.stereotype.Repository;

@Repository
public class User {
	private int id;
	private String name;
	private String mailID;
	private String phoneNumber;
	private String address;
	private String password;
	
	private static final String ADMINID = "admin@gmail.com";
	private static final String ADMINPWD = "Admin@123";
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMailID() {
		return mailID;
	}
	public void setMailID(String mailID) {
		this.mailID = mailID;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAdminMailID() {
		return ADMINID;
	}
	public String getAdminPwd() {
		return ADMINPWD;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", mailID=" + mailID + ", phoneNumber=" + phoneNumber
				+ ", address=" + address + ", password=" + password + ", adminMailID=" + ADMINID
				+ ", adminPassword=" + ADMINPWD + "]";
	}
}
