package com.chainsys.foodorderproject.controller;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.chainsys.foodorderproject.dao.AdminDAO;
import com.chainsys.foodorderproject.dao.UserDAO;
import com.chainsys.foodorderproject.dto.MainDTO;
import com.chainsys.foodorderproject.dto.MenuDTO;
import com.chainsys.foodorderproject.dto.SignInDTO;
import com.chainsys.foodorderproject.dto.SignUpDTO;
import com.chainsys.foodorderproject.exception.ItemNotFoundException;
import com.chainsys.foodorderproject.model.Cart;
import com.chainsys.foodorderproject.model.Menu;
import com.chainsys.foodorderproject.model.Orders;
import com.chainsys.foodorderproject.model.User;
import com.chainsys.foodorderproject.service.MainService;
import com.chainsys.foodorderproject.validation.UserValidation;

@Controller
public class MainController {
	
	@Autowired
	User user;
	
	@Autowired
	MainDTO mainDTO;
	
	@Autowired
	SignInDTO signInDTO;
	
	@Autowired
	SignUpDTO signUpDTO;
	
	@Autowired
	MenuDTO menuDTO;
	
	@Autowired
	UserDAO userDAO;
	
	@Autowired
	AdminDAO adminDAO;
	
	@Autowired
	MainService mainService;
	
	@Autowired
	UserValidation userValidation;
	
	@Autowired
	ServletContext context;
	
	List<User> userInfo;
	List<Menu> menuInfo;
	List<Cart> cartInfo;
	
	//Redirection
	String adminHome = "/admin";
	String userHome = "/user";
	String userOrders = "/orders";
	String loginPage = "login.jsp";
	String adminPanel = "adminPanel.jsp";
	String userPanel = "userPanel.jsp";
	
	String errorMessage = "errMsg";
	String menuDetails = "menuDetails";
	String cartDetails = "cartDetails";
	
	//Login or Sign-In
	@PostMapping("/signIn")
	public String login(@RequestParam("emailID") String mailID,@RequestParam("password") String password,Model model) {
		signInDTO.setUserMailID(mailID);
		signInDTO.setPassword(password);
		
		//Admin Login
		if(signInDTO.getUserMailID().equals(user.getAdminMailID()) && signInDTO.getPassword().equals(user.getAdminPwd())) {
			menuInfo = adminDAO.getAllMenuDetails();
			model.addAttribute(menuDetails,menuInfo);
			return adminPanel;
		}
		else {
			//User Login
			if(userDAO.checkLogin(mailID, password)) {
				userInfo = userDAO.getUserDetails(mailID, password);
				model.addAttribute("userDetails",userInfo);
				menuInfo = userDAO.getMenuDetails();
				model.addAttribute(menuDetails,menuInfo);
				cartInfo = userDAO.getCart(userInfo.get(0).getId());
				model.addAttribute(cartDetails, cartInfo);
				int pincode = userDAO.extractPincode(userInfo.get(0).getAddress());
				model.addAttribute("userPincode", pincode);
				return userPanel;
			}
			else {
				model.addAttribute(errorMessage, "Invalid Login");
				return loginPage;
			}
		}
	}
	
	//Admin Home
	@GetMapping("/admin")
	public String admin(Model model) {
		try {
			menuInfo = adminDAO.getAllMenuDetails();
			model.addAttribute(menuDetails,menuInfo);
			return adminPanel;
		}
		catch (Exception e) {
			return loginPage;
		}
	}
	
	//User Home
	@GetMapping("/user")
	public String user(Model model) {
		try {
			userInfo = userDAO.getUserDetails(userInfo.get(0).getMailID(), userInfo.get(0).getPassword());
			model.addAttribute("userDetails",userInfo);
			menuInfo = userDAO.getMenuDetails();
			model.addAttribute(menuDetails,menuInfo);
			cartInfo = userDAO.getCart(userInfo.get(0).getId());
			model.addAttribute(cartDetails, cartInfo);
			int pincode = userDAO.extractPincode(userInfo.get(0).getAddress());
			model.addAttribute("userPincode", pincode);
			return userPanel;
		}
		catch (Exception e) {
			return loginPage;
		}
	}
	
	//Search Item
	@GetMapping("/searchItem")
	public String searchItem(@RequestParam("itemName") String itemName, Model model) {
		try {
			if(itemName.isEmpty()) {
				throw new ItemNotFoundException();
			}
			menuInfo = userDAO.getMenuDetails(itemName);
			model.addAttribute(menuDetails,menuInfo);
			cartInfo = userDAO.getCart(userInfo.get(0).getId());
			model.addAttribute(cartDetails, cartInfo);
			return userPanel;
		}
		catch (Exception e) {
			return loginPage;
		}
	}
	
	//Logout
	@GetMapping("/logout")
	public String logout() {
		try {
		userInfo.get(0).setMailID(null);
		userInfo.get(0).setPassword(null);
		return loginPage;
		}
		catch (Exception e) {
			return loginPage;
		}
	}
	
	//User Sign-Up
	@PostMapping("/signUp")
	public String signUp(@RequestParam("name") String name,@RequestParam("emailID") String mailID,@RequestParam("mobileno") String phoneNo,@RequestParam("address") String address,@RequestParam("password") String password,Model model) {
		signUpDTO.setUserName(name);
		signUpDTO.setUserAddress(address);
		signUpDTO.setUserPassword(password);
		int check=0;
		if(userValidation.checkMobileNumber(phoneNo)) {
			signUpDTO.setUserPhoneNo(phoneNo);
			check+=1;
		}
		else {
			model.addAttribute("errMsgPhoneNumber", " * Phone Number Already Exists, Try Other");
		}
		if(userValidation.checkMailID(mailID)) {
			signUpDTO.setUserMailID(mailID);
			check+=1;
		}
		else {
			model.addAttribute(errorMessage, " * Mail-ID Already Exists, Try Other");
		}
		if(check==2) {
			mainService.signUpService(signUpDTO);
			return loginPage;
		}
		else
			return "signup.jsp";
	}
	
	//Update User Info
	@GetMapping("/updateInfo")
	public String updateInfo(@RequestParam("name") String name,@RequestParam("mobileno") String phoneNo,@RequestParam("address") String address,@RequestParam("password") String password,Model model) {
		mainDTO.setUserName(name);
		mainDTO.setUserPhoneNo(phoneNo);
		mainDTO.setUserAddress(address);
		mainDTO.setUserPassword(password);
		mainDTO.setUserPhoneNo(phoneNo);
		mainService.updateService(userInfo,mainDTO);
		return userHome;
	}
	
	//Forgot Password - User
	@PostMapping("/forgotPassword")
	public String forgotPassword(@RequestParam("emailID") String mailID,@RequestParam("password") String password,Model model) {
		if(userValidation.checkMailID(mailID)) {
			model.addAttribute(errorMessage, "No Mail-ID Found");
			return "forgotPassword.jsp";
		}
		else {
			userDAO.forgotPassword(mailID, password);
			return loginPage;
		}
	}
	
	//Add Item - Admin
	@PostMapping("/addMenu")
	public String addMenu(@RequestParam("menuName") String name,@RequestParam("menuType") String type,@RequestParam("menuPrice") float price, @RequestParam("menuImg") MultipartFile img,Model model) {
		try {
			menuDTO.setMenuName(name);
			menuDTO.setMenuType(type);
			menuDTO.setMenuPrice(price);
			
			String applicationPath = context.getRealPath("");
			String rpath = applicationPath + File.separator + "images"+ File.separator;
	        String filename = img.getOriginalFilename();
	        FileInputStream fin = new FileInputStream(rpath+filename);
	        byte[] images = fin.readAllBytes();
	        menuDTO.setMenuImg(images);
	        mainService.menuService(menuDTO);
	        
	        menuInfo = adminDAO.getAllMenuDetails();
			model.addAttribute(menuDetails,menuInfo);
			return adminPanel;
		}
		catch (Exception e) {
			model.addAttribute("fileError","File Not Found");
			menuInfo = adminDAO.getAllMenuDetails();
			model.addAttribute(menuDetails,menuInfo);
			return adminPanel;
		}
	}
	
	//Edit Item
	@GetMapping("/editItem")
	public String editItem(@RequestParam("itemID") int itemID,@RequestParam("itemName") String itemName,@RequestParam("itemType") String itemType,@RequestParam("itemPrice") float itemPrice) {
		menuDTO.setMenuName(itemName);
		menuDTO.setMenuType(itemType);
		menuDTO.setMenuPrice(itemPrice);
		mainService.editItemService(itemID,menuDTO); 
		return adminHome;
	}
	
	//Delete Item - Admin
	@GetMapping("/delete")
	public String deleteMenu(@RequestParam("id") int itemID) {
		adminDAO.deleteItem(itemID);
		return adminPanel;
	}
	
	//Confirms Items in CART
	@GetMapping("/confirmOrder")
	public String confirmOrder(@RequestParam("orderType") String orderType,Model model) {
		try {
			int userID=userInfo.get(0).getId();
			userDAO.confirmOrder(userID,orderType);
			return userOrders;
		}
		catch (Exception e) {
			return loginPage;
		}
	}
	
	//Increase Quantity in CART
	@GetMapping("/incQuantity")
	public String incQuantity(@RequestParam("itemID") int itemID,@RequestParam("itemQuantity") int itemQuantity) {
		try {
			int userID=userInfo.get(0).getId();
			userDAO.incQuantity(userID,itemID,itemQuantity);
			return userHome;
		}
		catch (Exception e) {
			return loginPage;
		}
	}
	
	//Decrease Quantity in CART
	@GetMapping("/decQuantity")
	public String decQuantity(@RequestParam("itemID") int itemID,@RequestParam("itemQuantity") int itemQuantity,Model model) {
		try {
			int userID=userInfo.get(0).getId();
			if(userValidation.checkItemQuantity(userID, itemID,itemQuantity))
				userDAO.decQuantity(userID,itemID,itemQuantity);
			else
				model.addAttribute(errorMessage, "Item Cannot be Less than 1");
			return userHome;
		}
		catch (Exception e) {
			return loginPage;
		}
	}
	
	//Add item to CART
	@GetMapping("/addToCart")
	public String addToCart(@RequestParam("userID") int userID,@RequestParam("itemID") int itemID,Model model) {
		if(userValidation.isItemInCart(itemID, userID))
			userDAO.addToCart(userID, itemID);
		else
			model.addAttribute(errorMessage, "Already in Cart");
		return userHome;
	}
	
	//Drop All Item from Cart
	@GetMapping("/dropAll")
	public String dropAll(@RequestParam("userID") int userID) {
		userDAO.dropAllItems(userID);
		return userHome;
	}
	
	//Drop Item from Cart
	@GetMapping("/dropItem")
	public String dropItem(@RequestParam("userID") int userID,@RequestParam("itemID") int itemID) {
		userDAO.dropItem(userID, itemID);
		return userHome;
	}
	
	
	@GetMapping("/orders")
	public String getUserOrders(Model model){
		try {
			int userID=userInfo.get(0).getId();
			List<Orders> orderInfo = userDAO.getUserOrders(userID);
			model.addAttribute("orderDetails",orderInfo);
			List<Orders> completedOrders = userDAO.getCompletedOrders(userID);
			model.addAttribute("completedOrderDetails", completedOrders);
			return "userOrders.jsp";
		}
		catch (Exception e) {
			return loginPage;
		}
	}
	
	@GetMapping("/orderItems")
	public String getOrderItemDetail(@RequestParam("orderID") String orderID,@RequestParam("orderType") String orderType,Model model) {
		List<Cart> orderItems = userDAO.getOrderItemDetails(orderID);
		model.addAttribute("orderItemDetails", orderItems);
		model.addAttribute("orderType", orderType);
		return userOrders;
	}
	
	@GetMapping("/cancelOrder")
	public String cancelOrder(@RequestParam("orderID") String orderID) {
		userDAO.cancelOrder(orderID);
		return userOrders;
	}
	
	@GetMapping("/adminOrders")
	public String getOrdersDetails(Model model) {
		try {
		List<Orders> orderInfo = adminDAO.getOrders();
		model.addAttribute("adminOrderDetails", orderInfo);
		List<Orders> completeOrders = adminDAO.getCompletedOrders();
		model.addAttribute("completedOrderDetails", completeOrders);
		return "orders.jsp";
		}
		catch (Exception e) {
			return loginPage;
		}
	}
	
	//Admin
	@GetMapping("/userOrderItems")
	public String getUserOrderItemDetail(@RequestParam("orderID") String orderID,@RequestParam("orderType") String orderType,Model model) {
		List<Cart> orderItems = adminDAO.getOrderItemDetails(orderID);
		model.addAttribute("userOrderItemDetails", orderItems);
		model.addAttribute("orderType", orderType);
		return "/adminOrders";
	}
	
	//Update Order
	@GetMapping("/updateOrderStatus")
	public String updateOrderStatus(@RequestParam("orderID") String orderID) {
		adminDAO.updateOrderStatus(orderID);
		return "/adminOrders";
	}
}
