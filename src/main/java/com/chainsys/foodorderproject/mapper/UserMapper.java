package com.chainsys.foodorderproject.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.chainsys.foodorderproject.model.User;

@Repository
public class UserMapper implements RowMapper<User>{
	
	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User u = new User();
		int id = rs.getInt("CUSTOMER_ID");
		String name = rs.getString("CUSTOMER_NAME");
		String mailID = rs.getString("MAIL_ID");
		String phoneNumber = rs.getString("PHONE_NO");
		String address = rs.getString("ADDRESS");
		String password = rs.getString("PASSWORD");
		
		u.setId(id);
		u.setName(name);
		u.setMailID(mailID);
		u.setPhoneNumber(phoneNumber);
		u.setAddress(address);
		u.setPassword(password);
		
		return u;
	}

}
