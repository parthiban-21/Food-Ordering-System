package com.chainsys.foodorderproject.dto;

import java.util.Arrays;

import org.springframework.stereotype.Repository;

@Repository
public class MenuDto {
	private int itemID;
	private String itemName;
	private String itemType;
	private float itemPrice;
	private byte[] itemImage;
	
	public int getMenuID() {
		return itemID;
	}
	public void setMenuID(int itemID) {
		this.itemID = itemID;
	}
	public String getMenuName() {
		return itemName;
	}
	public void setMenuName(String itemName) {
		this.itemName = itemName;
	}
	public String getMenuType() {
		return itemType;
	}
	public void setMenuType(String itemType) {
		this.itemType = itemType;
	}
	public float getMenuPrice() {
		return itemPrice;
	}
	public void setMenuPrice(float itemPrice) {
		this.itemPrice = itemPrice;
	}
	
	public byte[] getMenuImg() {
		return itemImage;
	}
	public void setMenuImg(byte[] itemImage) {
		this.itemImage = itemImage;
	}
	@Override
	public String toString() {
		return "MenuDto [itemID=" + itemID + ", itemName=" + itemName + ", itemType=" + itemType + ", itemPrice="
				+ itemPrice + ", itemImage=" + Arrays.toString(itemImage) + "]";
	}
}
