package com.chainsys.foodorderproject.model;

import java.sql.Date;

import org.springframework.stereotype.Repository;

@Repository
public class Orders {
	private String orderID;
	private int customerID;
	private int itemID;
	private String itemName;
	private int quantity;
	private float unitPrice;
	private String orderType;
	private Date orderDate;
	private String orderStatus;
	private float totalPrice;
	
	public String getOrderID() {
		return orderID;
	}
	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	public int getItemID() {
		return itemID;
	}
	public void setItemID(int itemID) {
		this.itemID = itemID;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(float unitPrice) {
		this.unitPrice = unitPrice;
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
	public float getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	@Override
	public String toString() {
		return "Orders [orderID=" + orderID + ", customerID=" + customerID + ", itemID=" + itemID + ", itemName="
				+ itemName + ", quantity=" + quantity + ", perPrice=" + unitPrice + ", orderType=" + orderType
				+ ", orderDate=" + orderDate + ", orderStatus=" + orderStatus + ", totalPrice=" + totalPrice + "]";
	}
}
