package com.chainsys.foodorderproject.model;

import org.springframework.stereotype.Repository;

@Repository
public class Cart {
	private int userID;
	private int menuID;
	private String menuName;
	private int quantity;
	private String orderType;
	private String orderStatus;
	private float perPrice;
	private float totalPrice;
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public int getMenuID() {
		return menuID;
	}
	public void setMenuID(int menuID) {
		this.menuID = menuID;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getOrderType() {
		return orderType;
	}
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public float getPerPrice() {
		return perPrice;
	}
	public void setPerPrice(float perPrice) {
		this.perPrice = perPrice;
	}
	public float getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}
	@Override
	public String toString() {
		return "Cart [userID=" + userID + ", menuID=" + menuID + ", menuName=" + menuName + ", quantity=" + quantity
				+ ", orderType=" + orderType + ", orderStatus=" + orderStatus + ", perPrice=" + perPrice
				+ ", totalPrice=" + totalPrice + "]";
	}
}
