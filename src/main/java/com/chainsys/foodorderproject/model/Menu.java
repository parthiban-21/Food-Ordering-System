package com.chainsys.foodorderproject.model;

import java.util.Arrays;

import org.springframework.stereotype.Repository;

@Repository
public class Menu {
	private int menuID;
	private String menuName;
	private String menuType;
	private float menuPrice;
	private  byte[] menuIMG;
	private String imgPath;
	
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
	
	public byte[] getMenuIMG() {
		return menuIMG;
	}
	public void setMenuIMG(byte[] menuIMG) {
		this.menuIMG = menuIMG;
	}
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	@Override
	public String toString() {
		return "Menu [menuID=" + menuID + ", menuName=" + menuName + ", menuType=" + menuType + ", menuPrice="
				+ menuPrice + ", menuIMG=" + Arrays.toString(menuIMG) + ", imgPath=" + imgPath + "]";
	}
}
