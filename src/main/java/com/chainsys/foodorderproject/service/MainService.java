package com.chainsys.foodorderproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.chainsys.foodorderproject.dao.MainDAO;
import com.chainsys.foodorderproject.dto.MainDto;
import com.chainsys.foodorderproject.dto.MenuDto;
import com.chainsys.foodorderproject.dto.SignUpDto;
import com.chainsys.foodorderproject.model.Menu;
import com.chainsys.foodorderproject.model.User;

@Repository
public class MainService {
	
	@Autowired
	User u;
	
	@Autowired
	Menu m;
	
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
	
	public void updateService(List<User> info,MainDto dto) {
		if(info.get(0).getPassword().equals(dto.getUserPassword())) {
			u.setName(dto.getUserName());
			u.setPhoneNo(dto.getUserPhoneNo());
			u.setAddress(dto.getUserAddress());
			
			//To Filter In DB
			u.setMailID(info.get(0).getMailID());
			u.setPassword(info.get(0).getPassword());
			
			dao.updateUserDetails(u);
		}
		else {
			System.out.println("error");
		}
	}
	
	public void menuService(MenuDto mdto) {
		m.setMenuName(mdto.getMenuName());
		m.setMenuType(mdto.getMenuType());
		m.setMenuPrice(mdto.getMenuPrice());
		m.setMenuIMG(mdto.getMenuImg());
		dao.addMenu(m);
	}
}
