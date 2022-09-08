package com.chainsys.foodorderproject.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.chainsys.foodorderproject.model.Cart;

@Repository
public class CartMapper implements RowMapper<Cart> {

	@Override
	public Cart mapRow(ResultSet rs, int rowNum) throws SQLException {
		Cart cart = new Cart();
		int userID = rs.getInt("CUSTOMER_ID");
		int menuID = rs.getInt("ITEM_ID");
		String menuName = rs.getString("ITEM_NAME");
		int quantity = rs.getInt("QUANTITY");
		String orderType = rs.getString("ORDER_TYPE");
		String orderStatus = rs.getString("ORDER_STATUS");
		float unitPrice = rs.getFloat("ITEM_PRICE");
		float totalPrice = rs.getFloat("TOTAL");
		
		cart.setUserID(userID);
		cart.setItemID(menuID);
		cart.setItemName(menuName);
		cart.setQuantity(quantity);
		cart.setOrderType(orderType);
		cart.setOrderStatus(orderStatus);
		cart.setUnitPrice(unitPrice);
		cart.setTotalPrice(totalPrice);
		
		return cart;
	}

}
