package com.chainsys.foodorderproject.model;

import java.util.Arrays;

import org.springframework.stereotype.Repository;

@Repository
public class Menu {
	private int itemID;
	private String itemName;
	private String itemType;
	private float itemPrice;
	private  byte[] itemIMG;
	private String imgPath;
	
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
	public String getItemType() {
		return itemType;
	}
	public void setItemType(String itemType) {
		this.itemType = itemType;
	}
	public float getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(float itemPrice) {
		this.itemPrice = itemPrice;
	}
	public byte[] getItemIMG() {
		return itemIMG;
	}
	public void setItemIMG(byte[] itemIMG) {
		this.itemIMG = itemIMG;
	}
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	@Override
	public String toString() {
		return "Menu [itemID=" + itemID + ", itemName=" + itemName + ", itemType=" + itemType + ", itemPrice="
				+ itemPrice + ", itemIMG=" + Arrays.toString(itemIMG) + ", imgPath=" + imgPath + "]";
	}
}
