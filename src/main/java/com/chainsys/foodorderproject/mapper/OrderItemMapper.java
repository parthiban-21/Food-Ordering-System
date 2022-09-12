package com.chainsys.foodorderproject.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.chainsys.foodorderproject.model.Cart;

public class OrderItemMapper implements RowMapper<Cart> {

	@Override
	public Cart mapRow(ResultSet rs, int rowNum) throws SQLException {
		Cart cart = new Cart();
		cart.setItemName(rs.getString("ITEM_NAME"));
		cart.setUnitPrice(rs.getFloat("ITEM_PRICE"));
		cart.setQuantity(rs.getInt("QUANTITY"));
		cart.setTotalPrice(rs.getFloat("TOTAL"));
		return cart;
	}

}
