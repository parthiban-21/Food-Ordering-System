package com.chainsys.foodorderproject.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.chainsys.foodorderproject.mapper.MenuMapper;
import com.chainsys.foodorderproject.mapper.OrderItemMapper;
import com.chainsys.foodorderproject.mapper.OrderMapper;
import com.chainsys.foodorderproject.model.Cart;
import com.chainsys.foodorderproject.model.Menu;
import com.chainsys.foodorderproject.model.Orders;

@Repository
public class AdminDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;

	//Gets all Menu Details
	public List<Menu> getAllMenuDetails(){
		String getMenuQuery = "select * from MENU";
		List<Menu> menuDetails = jdbcTemplate.query(getMenuQuery,new MenuMapper());
		return menuDetails;
	}

	//Add Menu
	public void addItem(Menu menu) {
		String addItemQuery = "insert into MENU(ITEM_ID,ITEM_NAME,ITEM_TYPE,ITEM_PRICE,ITEM_IMG) values(MENUID.nextval,?,?,?,?)";
		Object[] itemDetails = {menu.getItemName(),menu.getItemType(),menu.getItemPrice(),menu.getItemIMG()};
		jdbcTemplate.update(addItemQuery,itemDetails);
	}

	//Delete Menu*
	public void deleteItem(int itemID) {
		String deleteItemQuery = "delete from MENU where ITEM_ID=?";
		Object[] id = {itemID};
		jdbcTemplate.update(deleteItemQuery,id);
	}
	
	//Edit Menu
	public void editItem(int itemID,Menu menu){
		String editItemQuery = "update MENU set ITEM_NAME=?,ITEM_TYPE=?,ITEM_PRICE=? where ITEM_ID=?";
		Object[] values = {menu.getItemName(),menu.getItemType(),menu.getItemPrice(),itemID};
		jdbcTemplate.update(editItemQuery,values);
	}
	
	//Get Orders
	public List<Orders> getOrders() {
		String getOrdersQuery = "select ORDER_ID,CUSTOMER_ID,ORDER_DATE,TOTAL_PRICE,ORDER_STATUS,ORDER_TYPE from ORDERS where ORDER_STATUS='Order Placed'";
		List<Orders> orderDetails = jdbcTemplate.query(getOrdersQuery,new OrderMapper());
		return orderDetails;
	}
	
	//Get Orders - Completed
	public List<Orders> getCompletedOrders() {
		String getOrdersQuery = "select ORDER_ID,CUSTOMER_ID,ORDER_DATE,TOTAL_PRICE,ORDER_STATUS,ORDER_TYPE from ORDERS where ORDER_STATUS='Completed'";
		List<Orders> orderDetails = jdbcTemplate.query(getOrdersQuery,new OrderMapper());
		return orderDetails;
	}
	
	//Get User Order Details
	public List<Cart> getOrderItemDetails(String orderID){
		String getOrderItemQuery = "select MENU.ITEM_NAME,MENU.ITEM_PRICE,CART.QUANTITY,CART.QUANTITY*MENU.ITEM_PRICE as TOTAL from CART INNER JOIN MENU ON CART.ITEM_ID=MENU.ITEM_ID where CART.ORDER_ID=?";
		Object[] id = {orderID};
		List<Cart> userOrderItems = jdbcTemplate.query(getOrderItemQuery,new OrderItemMapper(), id);
		System.out.println(userOrderItems);
		return userOrderItems;
	}
	
	//Update Order Status
	public void updateOrderStatus(String orderID) {
		String editItemQuery = "update ORDERS set ORDER_STATUS=? where ORDER_ID=?";
		Object[] values = {"Completed",orderID};
		jdbcTemplate.update(editItemQuery,values);
	}
}
