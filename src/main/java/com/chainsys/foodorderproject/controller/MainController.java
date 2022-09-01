package com.chainsys.foodorderproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.chainsys.foodorderproject.dao.MainDAO;
import com.chainsys.foodorderproject.dto.SignInDto;
import com.chainsys.foodorderproject.dto.SignUpDto;
import com.chainsys.foodorderproject.model.User;
import com.chainsys.foodorderproject.service.MainService;

@Controller
public class MainController {
	
	@Autowired
	User user;
	
	@Autowired
	SignInDto inDto;
	
	@Autowired
	SignUpDto upDto;
	
	@Autowired
	MainDAO dao;
	
	@Autowired
	MainService service;
	
	@PostMapping("/signIn")
	public String login(@RequestParam("emailID") String mailID,@RequestParam("password") String password) {
		inDto.setUserMailID(mailID);
		inDto.setPassword(password);
		if(inDto.getUserMailID().equals(user.getAdminMailID()) && inDto.getPassword().equals(user.getAdminPassword())) {
			return "adminPanel.jsp";
		}
		else {
			return "login.jsp";
		}
	}
	
	@GetMapping("/logout")
	public String logout() {
		inDto.setUserMailID(null);
		inDto.setPassword(null);
		return "login.jsp";
	}
	
	@PostMapping("/signUp")
	public String signUp(@RequestParam("name") String name,@RequestParam("emailID") String mailID,@RequestParam("mobileno") String phoneNo,@RequestParam("address") String address,@RequestParam("password") String password) {
		upDto.setUserName(name);
		upDto.setUserMailID(mailID);
		upDto.setUserPhoneNo(phoneNo);
		upDto.setUserAddress(address);
		upDto.setUserPassword(password);
		service.signUpService(upDto);
		return "login.jsp";
	}
}
