package com.chainsys.foodorderproject.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserValidation {
	
	@Autowired
	JdbcTemplate jdbc;

	//Check Mail-ID Exist or Not
	public Boolean checkMailID(String mailID) {
		String query = "select CUSTOMER_ID from CUSTOMER where MAIL_ID=?";
		Object[] val = {mailID};
		int userID=0;
		try {
			userID = jdbc.queryForObject(query,int.class,val);
			if(userID!=0)
				return false;
			else {
				System.out.println("True");
				return true;
			}
		}
		catch(Exception e) {
			return true;
		}
	}
}
