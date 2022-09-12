package com.chainsys.foodorderproject.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.chainsys.foodorderproject.model.Cart;

public class ItemIDMapper implements RowMapper<Cart>{

	@Override
	public Cart mapRow(ResultSet rs, int rowNum) throws SQLException {
		Cart cart = new Cart();
		cart.setItemID(rs.getInt("ITEM_ID"));
		return cart;
	}
}
