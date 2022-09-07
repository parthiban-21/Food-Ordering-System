package com.chainsys.foodorderproject.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.chainsys.foodorderproject.model.Menu;

@Repository
public class MenuMapper implements RowMapper<Menu> {

	@Override
	public Menu mapRow(ResultSet rs, int rowNum) throws SQLException {
		Menu m = new Menu();
		
		int menuID = rs.getInt("MENU_ID");
		String menuName = rs.getString("MENU_NAME");
		String menuType = rs.getString("MENU_TYPE");
		float menuPrice = rs.getFloat("PRICE");
		byte[] images = rs.getBytes("MENU_IMG");
        String base64Image = Base64.getEncoder().encodeToString(images);
		
		m.setMenuID(menuID);
		m.setMenuName(menuName);
		m.setMenuType(menuType);
		m.setMenuPrice(menuPrice);
		m.setMenuIMG(images);
		m.setImgPath(base64Image);
		
		return m;
	}

}
