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
		
		int itemID = rs.getInt("ITEM_ID");
		String itemName = rs.getString("ITEM_NAME");
		String itemType = rs.getString("ITEM_TYPE");
		float itemPrice = rs.getFloat("ITEM_PRICE");
		byte[] itemimages = rs.getBytes("ITEM_IMG");
        String base64Image = Base64.getEncoder().encodeToString(itemimages);
		
		m.setItemID(itemID);
		m.setItemName(itemName);
		m.setItemType(itemType);
		m.setItemPrice(itemPrice);
		m.setItemIMG(itemimages);
		m.setImgPath(base64Image);
		
		return m;
	}

}
