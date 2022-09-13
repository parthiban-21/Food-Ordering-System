package com.chainsys.foodorderproject.validation;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.chainsys.foodorderproject.mapper.ItemIDMapper;
import com.chainsys.foodorderproject.mapper.MailIDMapper;
import com.chainsys.foodorderproject.model.Cart;
import com.chainsys.foodorderproject.model.User;

@Repository
public class UserValidation {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	//Check Mail-ID Exist or Not
	public boolean checkMailID(String mailID) {
		String getMailIDQuery = "select MAIL_ID,PHONE_NO from CUSTOMER where MAIL_ID=?";
		Object[] value = {mailID};
		List<User> id = jdbcTemplate.query(getMailIDQuery,new MailIDMapper(),value);
		if(id.isEmpty()) 
			return true;//Required
		else 
			return false;
	}
	
	//Check Mobile Number Exist or Not*
	public boolean checkMobileNumber(String mobileNumber) {
		String getMailIDQuery = "select MAIL_ID,PHONE_NO from CUSTOMER where PHONE_NO=?";
		Object[] value = {mobileNumber};
		List<User> id = jdbcTemplate.query(getMailIDQuery,new MailIDMapper(),value);
		if(id.isEmpty()) 
			return true; //Required
		else 
			return false;
	}
	
	//Check ItemID in Cart
	public boolean isItemInCart(int itemID,int userID) {
		String getItemIDQuery = "select ITEM_ID from CART where CUSTOMER_ID=? and ITEM_ID=? and ORDER_STATUS='In Cart'";
		Object[] value = {userID,itemID};
		List<Cart> id = jdbcTemplate.query(getItemIDQuery,new ItemIDMapper(),value);
		if(id.isEmpty())
			return true;//Required
		else
			return false;
	}
	
	//Check ItemID in Cart
	public boolean checkItemQuantity(int userID,int itemID,int itemQuantity) {
		if(itemQuantity>1)
			return true; //Required
		else
			return false;
	}

	public boolean checkName(String name) {
		String userPattern = "^(?!.*\\d)(?=.*[a-z])(?=.*[A-Z])(?!.*[!@#&()–[{}]:;',?/*~$^+=<>]).{4,20}$";
		Pattern pattern = Pattern.compile(userPattern);
		Matcher match = pattern.matcher(name);
		return match.matches();
	}

	//Validate Mail-ID
	public boolean checkEmailID(String mailID) {
		String userPattern = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
		Pattern pattern = Pattern.compile(userPattern);
		Matcher match = pattern.matcher(mailID);
		return match.matches();
	}

	//Validate Phone Number
	public boolean checkPhoneNo(String phoneNo) {
		String userPattern = "^(0/91)?[7-9]\\d{9}$";
		Pattern pattern = Pattern.compile(userPattern);
		Matcher match = pattern.matcher(phoneNo);
		return match.matches();
	}

	//Validate Address 
	public boolean checkAddress(String address) {
		String userPattern = "^(?!.*\\d)(?=.*[a-z])(?=.*[A-Z])(?!.*[!@#&()–[{}]:;',?/*~$^+=<>]).{4,20}$";
		Pattern pattern = Pattern.compile(userPattern);
		Matcher match = pattern.matcher(address);
		return match.matches();
	}
	
	//Validate Password 
	public boolean checkPassword(String password) {
		String userPattern = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{4,20}$";
		Pattern pattern = Pattern.compile(userPattern);
		Matcher match = pattern.matcher(password);
		return match.matches();
	}
}
