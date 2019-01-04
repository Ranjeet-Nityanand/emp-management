package com.boot.config.resultmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import login.User;

public class UserMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		user.setEmail(rs.getString("email"));
		user.setPassword(rs.getString("password"));
		user.setName(rs.getString("name"));
		user.setRoll_id(rs.getInt("roll_id"));
		user.setStatus_id(rs.getInt("status_id"));
		user.setEmp_id(rs.getString("emp_id"));
		user.setContact(rs.getString("mobileno"));
		user.setAddress(rs.getString("address"));
		user.setRollName(rs.getString("roll_value"));
		user.setId(rs.getInt("id"));
		return user;
	}

}
