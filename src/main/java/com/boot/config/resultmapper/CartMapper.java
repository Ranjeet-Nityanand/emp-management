package com.boot.config.resultmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import login.CartDomain;

public class CartMapper implements RowMapper<CartDomain> {

	@Override
	public CartDomain mapRow(ResultSet rs, int rowNum) throws SQLException {
		CartDomain cartdom = new CartDomain();
		cartdom.setId(rs.getInt("id"));
		cartdom.setUserid(rs.getInt("user_id"));
		cartdom.setItemid(rs.getInt("item_id"));
		cartdom.setItemquantity(rs.getInt("item_quantity"));
		cartdom.setItemprice(rs.getFloat("item_price"));
		cartdom.setItemname(rs.getString("item_name"));
		cartdom.setTotalprice(rs.getFloat("total_price"));
		return cartdom;
	}

}
