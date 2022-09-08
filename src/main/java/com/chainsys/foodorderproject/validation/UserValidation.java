package com.chainsys.foodorderproject.validation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.chainsys.foodorderproject.mapper.MailIDMapper;
import com.chainsys.foodorderproject.model.User;

@Repository
public class UserValidation {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	//Check Mail-ID Exist or Not
	public Boolean checkMailID(String mailID) {
		String getMailIDQuery = "select MAIL_ID from CUSTOMER where MAIL_ID=?";
		Object[] value = {mailID};
		try {
			List<User> id = jdbcTemplate.query(getMailIDQuery,new MailIDMapper(),value);
			if(id.size()==0) {
				return true;//Required
			}
			else {
				return false;
			}
		}
		catch(Exception e) {
			return false;//Required
		}
	}
}
