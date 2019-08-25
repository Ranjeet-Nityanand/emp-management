package com.boot.config.resultmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import login.Product;

public class ProductMapper implements RowMapper<Product> {

	@Override
	public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
		Product product = new Product();
		product.setId(rs.getInt("id"));
		product.setName(rs.getString("product_name"));
		product.setPrice(rs.getFloat("price"));
		product.setQuantity(rs.getInt("quantity"));
		product.setFilename(rs.getString("file_name"));
		return product;
	}

}
