package com.chainsys.foodorderproject.dao;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.chainsys.foodorderproject.mapper.CartMapper;
import com.chainsys.foodorderproject.mapper.MenuMapper;
import com.chainsys.foodorderproject.mapper.OrderIDMapper;
import com.chainsys.foodorderproject.mapper.OrderItemMapper;
import com.chainsys.foodorderproject.mapper.OrderMapper;
import com.chainsys.foodorderproject.mapper.ConfirmedOrderMapper;
import com.chainsys.foodorderproject.mapper.UserMapper;
import com.chainsys.foodorderproject.model.Cart;
import com.chainsys.foodorderproject.model.Menu;
import com.chainsys.foodorderproject.model.Orders;
import com.chainsys.foodorderproject.model.User;

@Repository
public class UserDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;

	//Create New User
	public void createUser(User user) {
		String insertUserQuery = "insert into CUSTOMER(CUSTOMER_ID,CUSTOMER_NAME,MAIL_ID,PHONE_NO,ADDRESS,PASSWORD)"
				+ " values(CUSTOMERID.nextval,?,?,?,?,?)";
		Object[] details = {user.getName(),user.getMailID(),user.getPhoneNumber(),user.getAddress(),user.getPassword()};
		jdbcTemplate.update(insertUserQuery,details);
	}

	//Update User Details
	public void updateUserDetails(User user) {
		String updateUserDetailQuery = "update CUSTOMER set CUSTOMER_NAME=?,PHONE_NO=?,ADDRESS=? where MAIL_ID=? and PASSWORD=?";
		Object[] details = {user.getName(),user.getPhoneNumber(),user.getAddress(),user.getMailID(),user.getPassword()};
		jdbcTemplate.update(updateUserDetailQuery,details);
	}
	
	//Update User Password - Forgot Password
	public void forgotPassword(String mailID,String newPassword) {
		String updatePasswordQuery = "update CUSTOMER set PASSWORD=? where MAIL_ID=?";
		Object[] userData = {newPassword,mailID};
		jdbcTemplate.update(updatePasswordQuery,userData);
	}

	//Get User Details from DB
	public List<User> getUserDetails(String mailID,String password){
		String getUserDetailQuery = "select CUSTOMER_ID,CUSTOMER_NAME,MAIL_ID,PHONE_NO,ADDRESS,PASSWORD from CUSTOMER where MAIL_ID=? and PASSWORD=?";
		Object[] userData = {mailID,password};
		List<User> userDetails = jdbcTemplate.query(getUserDetailQuery,new UserMapper(),userData);
		return userDetails;
	}

	//Checks User Available or Not 
	public Boolean checkLogin(String mailID,String password) {
		String checkUserQuery = "select CUSTOMER_ID from CUSTOMER where MAIL_ID=? and PASSWORD=?";
		Object[] userData = {mailID,password};
		int userID = 0;
		try {
			userID = jdbcTemplate.queryForObject(checkUserQuery,int.class,userData);
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

	//Gets all Menu Details By Time
	public List<Menu> getMenuDetails(){
		String getMenuQuery = "select ITEM_ID,ITEM_NAME,ITEM_TYPE,ITEM_PRICE,ITEM_IMG from MENU where ITEM_TYPE=? or ITEM_TYPE=?";
		String time = getTime();
		Object[] values = {time,"snacks"};
		List<Menu> menuDetails = jdbcTemplate.query(getMenuQuery,new MenuMapper(),values);
		return menuDetails;
	}
	
	//Gets Item Details By Name & Time
	public List<Menu> getMenuDetails(String itemName){
		String getMenuQuery = "select ITEM_ID,ITEM_NAME,ITEM_TYPE,ITEM_PRICE,ITEM_IMG from MENU where ITEM_NAME=? and (ITEM_TYPE=? or ITEM_TYPE=?)";
		String time = getTime();
		Object[] values = {itemName,time,"snacks"};
		List<Menu> menuDetails = jdbcTemplate.query(getMenuQuery,new MenuMapper(),values);
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

	//Display Cart
	public List<Cart> getCart(int userID) {
		String getCartQuery = "select CART.CUSTOMER_ID,CART.ITEM_ID,CART.QUANTITY,CART.ORDER_STATUS,CART.ORDER_TYPE,MENU.ITEM_NAME,MENU.ITEM_PRICE,CART.QUANTITY*MENU.ITEM_PRICE as TOTAL from CART INNER JOIN MENU ON CART.ITEM_ID=MENU.ITEM_id where CUSTOMER_ID=? and ORDER_STATUS=?";
		Object[] values = {userID,"In Cart"};
		List<Cart> cartDetails = jdbcTemplate.query(getCartQuery,new CartMapper(),values);
		return cartDetails;
	}

	//Update Confirm Order
	public void confirmOrder(int userID,String orderType) {
		String confirmOrderQuery = "update CART set ORDER_STATUS=?,ORDER_TYPE=?,ORDER_ID=?,ORDER_DATE=? where CUSTOMER_ID=? and ORDER_STATUS=?";
		LocalDate today = LocalDate.now();
		String orderID = generateOrderID(userID, today);
		Object[] values = {"Confirmed",orderType,orderID,today,userID,"In Cart"};
		jdbcTemplate.update(confirmOrderQuery,values);
		List<Orders> orderDetails = getConfirmedOrder(userID, orderID); //Gets all Confirmed Order
		insertOrder(orderDetails);// Inserts Confirmed Order into Order Table
	}

	//Generates Unique OrderID
	public String generateOrderID(int userID,LocalDate today) {
		String orderID;
		int orderNo=101;
		orderID = "OD"+userID+today+"-"+orderNo;
		while(checkOrderID(orderID))
		{
			orderNo+=1;
			orderID = "OD"+userID+today+"-"+orderNo;
		}
		return orderID;
	}

	//Check OrderID Exists or Not
	public Boolean checkOrderID(String orderID) {
		String checkOrderIDQuery = "select ORDER_ID from CART where ORDER_ID=?";
		Object[] id = {orderID};
		try {
			List<Cart> availableID = jdbcTemplate.query(checkOrderIDQuery,new OrderIDMapper(),id);
			if(availableID.size()==0) {
				return false;//Required
			}
			else
				return true;
		}
		catch(Exception e) {
			return true;
		}
	}
	
	//Update Item Quantity - Increase
	public void incQuantity(int userID,int itemID,int itemQuantity) {
		String upadateQuatityQuery = "update CART set QUANTITY=? where CUSTOMER_ID=? and ITEM_ID=? and ORDER_STATUS=?";
		itemQuantity+=1;
		Object[] values = {itemQuantity,userID,itemID,"In Cart"};
		jdbcTemplate.update(upadateQuatityQuery,values);
	}
	
	//Update Item Quantity - Decrease
	public void decQuantity(int userID,int itemID,int itemQuantity) {
		String upadateQuatityQuery = "update CART set QUANTITY=? where CUSTOMER_ID=? and ITEM_ID=? and ORDER_STATUS=?";
		itemQuantity-=1;
		Object[] values = {itemQuantity,userID,itemID,"In Cart"};
		jdbcTemplate.update(upadateQuatityQuery,values);
	}
	
	//Add item to CART
	public void addToCart(int userID,int itemID) {
		String addToCartQuery = "insert into CART(CUSTOMER_ID,ITEM_ID,QUANTITY,ORDER_STATUS) values(?,?,?,?)";
		Object[] values = {userID,itemID,1,"In Cart"};
		jdbcTemplate.update(addToCartQuery,values);
	}
	
	//Get Confirmed Order
	public List<Orders> getConfirmedOrder(int userID,String orderID) {
		String getOrderQuery="select CART.ORDER_ID,CART.CUSTOMER_ID,CART.ITEM_ID,MENU.ITEM_NAME,MENU.ITEM_PRICE,CART.QUANTITY,CART.ORDER_TYPE, CART.ORDER_DATE,CART.ORDER_STATUS,CART.QUANTITY*MENU.ITEM_PRICE as TOTAL from CART INNER JOIN MENU ON CART.ITEM_ID=MENU.ITEM_ID where CUSTOMER_ID=? and ORDER_ID=?";
		Object[] values = {userID,orderID};
		List<Orders> orderDetail = jdbcTemplate.query(getOrderQuery,new ConfirmedOrderMapper(),values);
		return orderDetail;
	}
	
	//Insert Order
	public void insertOrder(List<Orders> userOrder) {
		String insertOrderQuery = "insert into ORDERS (ORDER_ID,CUSTOMER_ID,ORDER_DATE,TOTAL_PRICE,ORDER_STATUS,ORDER_TYPE) values(?,?,?,?,?,?)";
		float grandTotal=0;
		for(int i=0;i<userOrder.size();i++) {
			grandTotal+=userOrder.get(i).getTotalPrice();
		}
		Object[] val = {userOrder.get(0).getOrderID(),userOrder.get(0).getCustomerID(),userOrder.get(0).getOrderDate(),grandTotal,"Order Placed",userOrder.get(0).getOrderType()};
		jdbcTemplate.update(insertOrderQuery,val);
	}
	
	//Drop all Item from Cart
	public void dropAllItems(int userID) {
		String dropOrderQuery = "update CART set ORDER_STATUS=? where CUSTOMER_ID=? and ORDER_STATUS=?";
		Object[] values = {"Dropped",userID,"In Cart"};
		jdbcTemplate.update(dropOrderQuery,values);
	}
	
	//Drop Item from Cart*
	public void dropItem(int userID,int itemID) {
		String dropOrderQuery = "update CART set ORDER_STATUS=? where CUSTOMER_ID=? and ITEM_ID=? and ORDER_STATUS=?";
		Object[] values = {"Dropped",userID,itemID,"In Cart"};
		jdbcTemplate.update(dropOrderQuery,values);
	}
	
	//Get User Orders
	public List<Orders> getUserOrders(int userID){
		String getUserOrderQuery = "select ORDER_ID,CUSTOMER_ID,ORDER_DATE,TOTAL_PRICE,ORDER_STATUS,ORDER_TYPE from ORDERS where CUSTOMER_ID=? and ORDER_STATUS='Order Placed'";
		Object[] id = {userID};
		List<Orders> userOrderDetails = jdbcTemplate.query(getUserOrderQuery,new OrderMapper(), id);
		return userOrderDetails;
	}
	
	//Get User Orders
	public List<Orders> getCompletedOrders(int userID){
		String getCompletedOrderQuery = "select ORDER_ID,CUSTOMER_ID,ORDER_DATE,TOTAL_PRICE,ORDER_STATUS,ORDER_TYPE from ORDERS where CUSTOMER_ID=? and ORDER_STATUS='Completed'";
		Object[] id = {userID};
		List<Orders> userOrderDetails = jdbcTemplate.query(getCompletedOrderQuery,new OrderMapper(), id);
		return userOrderDetails;
	}
	
	//Get User Order Details
	public List<Cart> getOrderItemDetails(String orderID){
		String getOrderItemQuery = "select MENU.ITEM_NAME,MENU.ITEM_PRICE,CART.QUANTITY,CART.QUANTITY*MENU.ITEM_PRICE as TOTAL from CART INNER JOIN MENU ON CART.ITEM_ID=MENU.ITEM_ID where CART.ORDER_ID=?";
		Object[] id = {orderID};
		List<Cart> userOrderItems = jdbcTemplate.query(getOrderItemQuery,new OrderItemMapper(), id);
		return userOrderItems;
	}
	
	//Cancel Order
	public void cancelOrder(String orderID) {
		String cancelOrder = "delete from orders where order_id=?";
		Object[] id = {orderID};
		jdbcTemplate.update(cancelOrder,id);
	}
}
