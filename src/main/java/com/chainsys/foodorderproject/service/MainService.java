package com.chainsys.foodorderproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.chainsys.foodorderproject.dao.MainDAO;
import com.chainsys.foodorderproject.dto.SignUpDto;
import com.chainsys.foodorderproject.model.User;

@Repository
public class MainService {
	
	@Autowired
	User u;
	
	@Autowired
	MainDAO dao;
	
	public void signUpService(SignUpDto dto) {
		u.setName(dto.getUserName());
		u.setMailID(dto.getUserMailID());
		u.setPhoneNo(dto.getUserPhoneNo());
		u.setAddress(dto.getUserAddress());
		u.setPassword(dto.getUserPassword());
		dao.createUser(u);
	}
}
