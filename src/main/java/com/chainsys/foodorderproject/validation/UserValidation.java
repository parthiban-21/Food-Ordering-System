package com.chainsys.foodorderproject.validation;

import java.util.List;

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
	public Boolean checkMailID(String mailID) {
		String getMailIDQuery = "select MAIL_ID from CUSTOMER where MAIL_ID=?";
		Object[] value = {mailID};
		try {
			List<User> id = jdbcTemplate.query(getMailIDQuery,new MailIDMapper(),value);
			if(id.size()==0) {
				return true;//Required
			}
			else {
				return false;
			}
		}
		catch(Exception e) {
			return false;
		}
	}
	
	//Check Mobile Number Exist or Not*
	public Boolean checkMobileNo(String mobileNo) {
		String getMailIDQuery = "select MAIL_ID from CUSTOMER where MAIL_ID=?";
		Object[] value = {mobileNo};
		try {
			List<User> id = jdbcTemplate.query(getMailIDQuery,new MailIDMapper(),value);
			if(id.size()==0) {
				return true;//Required
			}
			else {
				return false;
			}
		}
		catch(Exception e) {
			return false;
		}
	}
	
	//Check ItemID in Cart
	public Boolean isItemInCart(int itemID,int userID) {
		String getItemIDQuery = "select ITEM_ID from CART where CUSTOMER_ID=? and ITEM_ID=? and ORDER_STATUS='In Cart'";
		Object[] value = {userID,itemID};
		try {
			List<Cart> id = jdbcTemplate.query(getItemIDQuery,new ItemIDMapper(),value);
			if(id.size()==0)
				return true;//Required
			else
				return false;
		}
		catch (Exception e) {
			return false;
		}
	}
	
	//Check ItemID in Cart
	public Boolean checkItemQuantity(int userID,int itemID,int itemQuantity) {
//		String getItemQuantityQuery = "select QUANTITY from CART where CUSTOMER_ID=? and ITEM_ID=? and ORDER_STATUS='In Cart'";
//		Object[] value = {userID,itemID};
//		int itemQty = jdbcTemplate.queryForObject(getItemQuantityQuery,int.class,value);
		if(itemQuantity>1)
			return true; //Required
		else
			return false;
	}
}
