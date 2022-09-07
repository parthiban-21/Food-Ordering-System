package com.chainsys.foodorderproject.dao;

import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.chainsys.foodorderproject.mapper.CartMapper;
import com.chainsys.foodorderproject.mapper.MenuMapper;
import com.chainsys.foodorderproject.mapper.UserMapper;
import com.chainsys.foodorderproject.model.Cart;
import com.chainsys.foodorderproject.model.Menu;
import com.chainsys.foodorderproject.model.User;

@Repository
public class MainDAO {
	
	@Autowired
	JdbcTemplate jdbc;
	
	//Create New User
	public void createUser(User u) {
		String query = "insert into CUSTOMER(CUSTOMER_ID,CUSTOMER_NAME,MAIL_ID,PHONE_NO,ADDRESS,PASSWORD)"
				+ " values(CUSTOMERID.nextval,?,?,?,?,?)";
		Object[] val = {u.getName(),u.getMailID(),u.getPhoneNo(),u.getAddress(),u.getPassword()};
		jdbc.update(query,val);
	}
	
	//Update User Details
	public void updateUserDetails(User u) {
		String query = "update CUSTOMER set CUSTOMER_NAME=?,PHONE_NO=?,ADDRESS=? where MAIL_ID=? and PASSWORD=?";
		Object[] val = {u.getName(),u.getPhoneNo(),u.getAddress(),u.getMailID(),u.getPassword()};
		jdbc.update(query,val);
	}
	
	//Get User Details from DB
	public List<User> getUserDetails(String mailID,String password){
		String query = "select CUSTOMER_ID,CUSTOMER_NAME,MAIL_ID,PHONE_NO,ADDRESS,PASSWORD from CUSTOMER where MAIL_ID=? and PASSWORD=?";
		Object[] val = {mailID,password};
		List<User> userDetails = jdbc.query(query,new UserMapper(),val);
		return userDetails;
	}
	
	//Checks User Available or Not 
	public Boolean checkLogin(String mailID,String password) {
		String query = "select CUSTOMER_ID from CUSTOMER where MAIL_ID=? and PASSWORD=?";
		Object[] val = {mailID,password};
		int userID = 0;
		try {
			userID = jdbc.queryForObject(query,int.class,val);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}
	/*
	//Check Mail-ID Exist or Not
	public Boolean checkMailID(String mailID) {
		String query = "select CUSTOMER_ID from CUSTOMER where MAIL_ID=?";
		Object[] val = {mailID};
		int userID=0;
		try {
			userID = jdbc.queryForObject(query,int.class,val);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}*/
	
	//Gets all Menu Details
	public List<Menu> getAllMenuDetails(){
		String query = "select * from MENU";
		List<Menu> menuDetails = jdbc.query(query,new MenuMapper());
		return menuDetails;
	}
	
	//Gets all Menu Details By Time
	public List<Menu> getMenuDetails(){
		String query = "select * from MENU where MENU_TYPE=? or MENU_TYPE=?";
		String time = getTime();
		Object[] val = {time,"snacks"};
		List<Menu> menuDetails = jdbc.query(query,new MenuMapper(),val);
		return menuDetails;
	}
	
	//Get Date
	public String getTime() {
		LocalTime today = LocalTime.now();
		int hrs = today.getHour();
		if(hrs>=1 && hrs<=12){
			return "breakfast";
		}
		else if(hrs>=12 && hrs<=16){
			return "lunch";
		}
		else if(hrs>=16 && hrs<=24){
			return "dinner";
		}
		else
			return null;
	}
	
	//Add Menu
	public void addMenu(Menu m) {
		String query = "insert into MENU(MENU_ID,MENU_NAME,MENU_TYPE,PRICE,MENU_IMG) values(MENUID.nextval,?,?,?,?)";
		Object[] val = {m.getMenuName(),m.getMenuType(),m.getMenuPrice(),m.getMenuIMG()};
		jdbc.update(query,val);
	}
	
	//Delete Menu
	public void deleteMenu(int menuID) {
		String query = "delete from MENU where MENU_ID=?";
		Object[] val = {menuID};
		jdbc.update(query,val);
	}
	
	//Display Cart
	public List<Cart> getCart(int userID) {
		String query = "select CART.CUSTOMER_ID,CART.MENU_ID,CART.QUANTITY,CART.ORDER_STATUS,CART.ORDER_TYPE,MENU.MENU_NAME,MENU.PRICE,CART.QUANTITY*MENU.PRICE as TOTAL from CART INNER JOIN MENU ON CART.MENU_ID=menu.menu_id where CUSTOMER_ID=? and ORDER_STATUS=?";
		Object[] val = {userID,"In Cart"};
		List<Cart> cartDetails = jdbc.query(query,new CartMapper(),val);
		return cartDetails;
	}
}
