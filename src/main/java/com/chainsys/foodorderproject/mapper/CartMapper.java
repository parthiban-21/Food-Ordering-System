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
		Cart c = new Cart();
		int userID = rs.getInt("CUSTOMER_ID");
		int menuID = rs.getInt("MENU_ID");
		String menuName = rs.getString("MENU_NAME");
		int quantity = rs.getInt("QUANTITY");
		String orderType = rs.getString("ORDER_TYPE");
		String orderStatus = rs.getString("ORDER_STATUS");
		float perPrice = rs.getFloat("PRICE");
		float totalPrice = rs.getFloat("TOTAL");
		
		c.setUserID(userID);
		c.setMenuID(menuID);
		c.setMenuName(menuName);
		c.setQuantity(quantity);
		c.setOrderType(orderType);
		c.setOrderStatus(orderStatus);
		c.setPerPrice(perPrice);
		c.setTotalPrice(totalPrice);
		
		return c;
	}

}
