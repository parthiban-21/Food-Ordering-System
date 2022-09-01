package com.chainsys.foodorderproject.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.chainsys.foodorderproject.model.User;

@Repository
public class MainDAO {
	
	@Autowired
	JdbcTemplate jdbc;
	
	public void createUser(User u) {
//		String query = "insert into CUSTOMER(CUSTOMER_ID,CUSTOMER_NAME,MAIL_ID,PHONE_NO,ADDRESS,PASSWORD)"
//				+ " values(CUSTOMERID.nextval,?,?,?,?,?)";
		Object[] val = {u.getName(),u.getMailID(),u.getPhoneNo(),u.getAddress(),u.getPassword()};
		//jdbc.update(query,val);
		System.out.println(u);
	}
}
