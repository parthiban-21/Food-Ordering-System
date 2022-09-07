package com.chainsys.foodorderproject.dto;

import org.springframework.stereotype.Repository;

@Repository
public class MenuDto {
	private int menuID;
	private String menuName;
	private String menuType;
	private float menuPrice;
	private byte[] menuImg;
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
	public String getMenuType() {
		return menuType;
	}
	public void setMenuType(String menuType) {
		this.menuType = menuType;
	}
	public float getMenuPrice() {
		return menuPrice;
	}
	public void setMenuPrice(float menuPrice) {
		this.menuPrice = menuPrice;
	}
	
	public byte[] getMenuImg() {
		return menuImg;
	}
	public void setMenuImg(byte[] menuImg) {
		this.menuImg = menuImg;
	}
	@Override
	public String toString() {
		return "MenuDto [menuID=" + menuID + ", menuName=" + menuName + ", menuType=" + menuType + ", menuPrice="
				+ menuPrice + "]";
	}
}
