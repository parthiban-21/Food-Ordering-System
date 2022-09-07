package com.chainsys.foodorderproject.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.chainsys.foodorderproject.dao.MainDAO;
import com.chainsys.foodorderproject.dto.MainDto;
import com.chainsys.foodorderproject.dto.MenuDto;
import com.chainsys.foodorderproject.dto.SignInDto;
import com.chainsys.foodorderproject.dto.SignUpDto;
import com.chainsys.foodorderproject.model.Cart;
import com.chainsys.foodorderproject.model.Menu;
import com.chainsys.foodorderproject.model.User;
import com.chainsys.foodorderproject.service.MainService;
import com.chainsys.foodorderproject.validation.UserValidation;

@Controller
public class MainController {
	
	@Autowired
	User user;
	
	@Autowired
	MainDto dto;
	
	@Autowired
	SignInDto inDto;
	
	@Autowired
	SignUpDto upDto;
	
	@Autowired
	MenuDto mDto;
	
	@Autowired
	MainDAO dao;
	
	@Autowired
	MainService service;
	
	@Autowired
	UserValidation val;
	
	List<User> info;
	List<Menu> menuInfo;
	List<Cart> cartInfo;
	
	@GetMapping("/signIn")
	public String login(@RequestParam("emailID") String mailID,@RequestParam("password") String password,Model model) {
		inDto.setUserMailID(mailID);
		inDto.setPassword(password);
		
		//Admin Login
		if(inDto.getUserMailID().equals(user.getAdminMailID()) && inDto.getPassword().equals(user.getAdminPassword())) {
			return "/admin";
		}
		else {
			//User Login
			if(dao.checkLogin(mailID, password)) {
				info = dao.getUserDetails(mailID, password);
				model.addAttribute("userDetails",info);
				return "/user";
			}
			else {
				model.addAttribute("errMsg", "Invalied Login");
				return "login.jsp";
			}
		}
	}
	
	@GetMapping("/admin")
	public String admin(Model model) {
		menuInfo = dao.getAllMenuDetails();
		model.addAttribute("menuDetails",menuInfo);
		return "adminPanel.jsp";
	}
	
	@GetMapping("/user")
	public String user(Model model) {
		menuInfo = dao.getMenuDetails();
		model.addAttribute("menuDetails",menuInfo);
		cartInfo = dao.getCart(info.get(0).getId());
		model.addAttribute("cartDetails", cartInfo);
		return "userPanel.jsp";
	}
	
	@GetMapping("/logout")
	public String logout() {
		inDto.setUserMailID(null);
		inDto.setPassword(null);
		return "login.jsp";
	}
	
	@PostMapping("/signUp")
	public String signUp(@RequestParam("name") String name,@RequestParam("emailID") String mailID,@RequestParam("mobileno") String phoneNo,@RequestParam("address") String address,@RequestParam("password") String password,Model model) {
		upDto.setUserName(name);
		upDto.setUserPhoneNo(phoneNo);
		upDto.setUserAddress(address);
		upDto.setUserPassword(password);
		if(val.checkMailID(mailID)) {
			upDto.setUserMailID(mailID);
			service.signUpService(upDto);
			return "login.jsp";
		}
		else {
			model.addAttribute("errMsg", " * Mail-ID Already Exists, Try Other");
			return "signup.jsp";
		}
	}
	
	@PostMapping("/updateInfo")
	public String updateInfo(@RequestParam("name") String name,@RequestParam("mobileno") String phoneNo,@RequestParam("address") String address,@RequestParam("password") String password) {
		dto.setUserName(name);
		dto.setUserPhoneNo(phoneNo);
		dto.setUserAddress(address);
		dto.setUserPassword(password);
		service.updateService(info,dto);
		return "/user";
	}
	
	@PostMapping("/addMenu")
	public String addMenu(@RequestParam("menuName") String name,@RequestParam("menuType") String type,@RequestParam("menuPrice") float price, @RequestParam("menuImg") MultipartFile img,Model model) throws IOException {
		mDto.setMenuName(name);
		mDto.setMenuType(type);
		mDto.setMenuPrice(price);
		
		String path = "C:\\Users\\part3269\\Documents\\foodorderproject\\foodorderproject\\src\\main\\webapp\\images\\";
        String filename = img.getOriginalFilename();
        FileInputStream fin = new FileInputStream(path+filename);
        byte[] images = fin.readAllBytes();
        mDto.setMenuImg(images);
		service.menuService(mDto);
		return "adminPanel.jsp";
	}
	
//	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
//	@ResponseBody
//	public String deleteMenu(@PathVariable("id") int menuID) {
//		dao.deleteMenu(menuID);
//		System.out.println("Delete MenuID: "+menuID);
//		return "Deleted Successfully";
//	}
	
	@GetMapping("/delete")
	public String deleteMenu(@RequestParam("id") int menuID) {
		dao.deleteMenu(menuID);
		System.out.println("Delete MenuID: "+menuID);
		return "adminPanel.jsp";
	}
}
