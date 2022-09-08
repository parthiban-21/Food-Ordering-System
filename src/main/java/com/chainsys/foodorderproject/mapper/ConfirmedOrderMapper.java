package com.chainsys.foodorderproject.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.chainsys.foodorderproject.model.Orders;

public class ConfirmedOrderMapper implements RowMapper<Orders>{

	@Override
	public Orders mapRow(ResultSet rs, int rowNum) throws SQLException {
		Orders orders = new Orders();
		orders.setOrderID(rs.getString("ORDER_ID"));
		orders.setCustomerID(rs.getInt("CUSTOMER_ID"));
		orders.setItemID(rs.getInt("ITEM_ID"));
		orders.setItemName(rs.getString("ITEM_NAME"));
		orders.setPerPrice(rs.getFloat("ITEM_PRICE"));
		orders.setQuantity(rs.getInt("QUANTITY"));
		orders.setOrderType(rs.getString("ORDER_TYPE"));
		orders.setOrderDate(rs.getDate("ORDER_DATE"));
		orders.setOrderStatus(rs.getString("ORDER_STATUS"));
		orders.setTotalPrice(rs.getFloat("TOTAL"));
		return orders;
	}

}
