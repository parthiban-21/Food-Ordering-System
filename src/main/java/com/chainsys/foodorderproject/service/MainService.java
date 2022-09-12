package com.chainsys.foodorderproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.chainsys.foodorderproject.dao.AdminDAO;
import com.chainsys.foodorderproject.dao.UserDAO;
import com.chainsys.foodorderproject.dto.MainDTO;
import com.chainsys.foodorderproject.dto.MenuDTO;
import com.chainsys.foodorderproject.dto.SignUpDTO;
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
	
	public void signUpService(SignUpDTO signUpDTO) {
		user.setName(signUpDTO.getUserName());
		user.setMailID(signUpDTO.getUserMailID());
		user.setPhoneNumber(signUpDTO.getUserPhoneNo());
		user.setAddress(signUpDTO.getUserAddress());
		user.setPassword(signUpDTO.getUserPassword());
		userDAO.createUser(user);
	}
	
	public void updateService(List<User> info,MainDTO mainDTO) {
		if(info.get(0).getPassword().equals(mainDTO.getUserPassword())) {
			user.setName(mainDTO.getUserName());
			user.setPhoneNumber(mainDTO.getUserPhoneNo());
			user.setAddress(mainDTO.getUserAddress());
			
			//To Filter In DB
			user.setMailID(info.get(0).getMailID());
			user.setPassword(info.get(0).getPassword());
			
			userDAO.updateUserDetails(user);
		}
		else {
			System.out.println("error");
		}
	}
	
	public void menuService(MenuDTO menuDTO) {
		menu.setItemName(menuDTO.getMenuName());
		menu.setItemType(menuDTO.getMenuType());
		menu.setItemPrice(menuDTO.getMenuPrice());
		menu.setItemIMG(menuDTO.getMenuImg());
		adminDAO.addItem(menu);
	}
	public void editItemService(int itemID,MenuDTO menuDTO) {
		menu.setItemName(menuDTO.getMenuName());
		menu.setItemType(menuDTO.getMenuType());
		menu.setItemPrice(menuDTO.getMenuPrice());
		adminDAO.editItem(itemID,menu);
	}
}
