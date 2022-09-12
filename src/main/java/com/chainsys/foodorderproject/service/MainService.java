package com.chainsys.foodorderproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.chainsys.foodorderproject.dao.AdminDAO;
import com.chainsys.foodorderproject.dao.UserDAO;
import com.chainsys.foodorderproject.dto.MainDto;
import com.chainsys.foodorderproject.dto.MenuDto;
import com.chainsys.foodorderproject.dto.SignUpDto;
import com.chainsys.foodorderproject.model.Menu;
import com.chainsys.foodorderproject.model.User;

@Repository
public class MainService {
	
	@Autowired
	User user;
	
	@Autowired
	Menu menu;
	
	@Autowired
	UserDAO userDAO;
	
	@Autowired
	AdminDAO adminDAO;
	
	public void signUpService(SignUpDto signUpDto) {
		user.setName(signUpDto.getUserName());
		user.setMailID(signUpDto.getUserMailID());
		user.setPhoneNo(signUpDto.getUserPhoneNo());
		user.setAddress(signUpDto.getUserAddress());
		user.setPassword(signUpDto.getUserPassword());
		userDAO.createUser(user);
	}
	
	public void updateService(List<User> info,MainDto mainDto) {
		if(info.get(0).getPassword().equals(mainDto.getUserPassword())) {
			user.setName(mainDto.getUserName());
			user.setPhoneNo(mainDto.getUserPhoneNo());
			user.setAddress(mainDto.getUserAddress());
			
			//To Filter In DB
			user.setMailID(info.get(0).getMailID());
			user.setPassword(info.get(0).getPassword());
			
			userDAO.updateUserDetails(user);
		}
		else {
			System.out.println("error");
		}
	}
	
	public void menuService(MenuDto menuDto) {
		menu.setItemName(menuDto.getMenuName());
		menu.setItemType(menuDto.getMenuType());
		menu.setItemPrice(menuDto.getMenuPrice());
		menu.setItemIMG(menuDto.getMenuImg());
		adminDAO.addItem(menu);
	}
	public void editItemService(int itemID,MenuDto menuDto) {
		menu.setItemName(menuDto.getMenuName());
		menu.setItemType(menuDto.getMenuType());
		menu.setItemPrice(menuDto.getMenuPrice());
		adminDAO.editItem(itemID,menu);
	}
}
