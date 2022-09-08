package com.chainsys.foodorderproject.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.chainsys.foodorderproject.mapper.MenuMapper;
import com.chainsys.foodorderproject.model.Menu;

@Repository
public class AdminDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;

	//Gets all Menu Details
	public List<Menu> getAllMenuDetails(){
		String getMenuQuery = "select * from MENU";
		List<Menu> menuDetails = jdbcTemplate.query(getMenuQuery,new MenuMapper());
		return menuDetails;
	}

	//Add Menu
	public void addItem(Menu menu) {
		String addItemQuery = "insert into MENU(ITEM_ID,ITEM_NAME,ITEM_TYPE,ITEM_PRICE,ITEM_IMG) values(MENUID.nextval,?,?,?,?)";
		Object[] itemDetails = {menu.getItemName(),menu.getItemType(),menu.getItemPrice(),menu.getItemIMG()};
		jdbcTemplate.update(addItemQuery,itemDetails);
	}

	//Delete Menu*
	public void deleteItem(int itemID) {
		String deleteItemQuery = "delete from MENU where ITEM_ID=?";
		Object[] id = {itemID};
		jdbcTemplate.update(deleteItemQuery,id);
	}
}
