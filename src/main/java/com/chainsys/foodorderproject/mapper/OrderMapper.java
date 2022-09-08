package com.chainsys.foodorderproject.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.chainsys.foodorderproject.model.Orders;

public class OrderMapper implements RowMapper<Orders>{

	@Override
	public Orders mapRow(ResultSet rs, int rowNum) throws SQLException {
		Orders orders = new Orders();
		orders.setOrderID(rs.getString("ORDER_ID"));
		orders.setCustomerID(rs.getInt("CUSTOMER_ID"));
		orders.setOrderDate(rs.getDate("ORDER_DATE"));
		orders.setTotalPrice(rs.getFloat("TOTAL_PRICE"));
		orders.setOrderStatus(rs.getString("ORDER_STATUS"));
		orders.setOrderType(rs.getString("ORDER_TYPE"));
		return orders;
	}

}
