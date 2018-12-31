package com.boot.config.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.boot.config.resultmapper.UserMapper;

import login.User;

@Repository
public class UserRepositoryImplementation implements IUserRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public User validateUser(User user) {
		try {

			String sql = "select ed.id,ed.email,ed.password,ed.name,ed.roll_id,ed.status_id,ed.emp_id,ed.mobileno,ed.address,rm.roll_value from employee_details ed, roll_master rm where ed.roll_id = rm.roll_id and ed.email='"
					+ user.getEmail().trim() + "'and binary ed.password='" + user.getPassword().trim()
					+ "'and ed.status_id=1";
			// System.err.println("Validate User SQL -- " + sql);
			user = jdbcTemplate.queryForObject(sql, new UserMapper());
			return user;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}

	}

	public Long registerUser(User user) {
		try {
			// System.err.println("NAME=======" + user.getName());
			String insertsql = "INSERT INTO employee_details(email,name,password,mobileno,gender,dob,address) VALUES(?,?,?,?,?,?,?)";
			KeyHolder holder = new GeneratedKeyHolder();
			jdbcTemplate.update(new PreparedStatementCreator() {

				@Override
				public java.sql.PreparedStatement createPreparedStatement(java.sql.Connection con) throws SQLException {
					PreparedStatement ps = con.prepareStatement(insertsql, Statement.RETURN_GENERATED_KEYS);
					ps.setString(1, user.getEmail());
					ps.setString(2, user.getName());
					ps.setString(3, user.getPassword());
					ps.setString(4, user.getContact());
					ps.setString(5, user.getGender());
					ps.setString(6, user.getDob());
					ps.setString(7, user.getAddress());
					return ps;
				}
			}, holder);

			System.err.println("holder.getKey().longValue()   " + holder.getKey().longValue());
			return holder.getKey().longValue();

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public List<User> getAllEmployee(User user) {
		try {
			String sql = "select ed.id,ed.email,ed.password,ed.name,ed.roll_id,ed.status_id,ed.emp_id,ed.mobileno,ed.address,rm.roll_value from employee_details ed, roll_master rm"
					+ " where ed.roll_id = rm.roll_id ";
			if (user != null && user.getId() > 0) {
				System.err.println("-------User Id  FInd " + user.getId());
				sql += " and ed.id = " + user.getId();
			}

//			System.err.println("Fetching Query " + sql);

			List<User> employeeList = jdbcTemplate.query(sql, new UserMapper());
			return employeeList;
		} catch (DataAccessException e) {
			return null;
		}
	}

	@Override
	public int updateemployeeStatus(User user) {
		try {
			String sql = "update employee_details set status_id='" + user.getStatus_id() + "' where email='"
					+ user.getEmail() + "' ";
			return jdbcTemplate.update(sql);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}

	}

//<===== Edit Employee Using Prepared Statement======>
	@Override
	public int editEmployee(User user) {
		try {
			String updatesql = "update employee_details set name= ?,email= ?,mobileno= ?,address= ?,roll_id= ? where id= ?";
			jdbcTemplate.update(new PreparedStatementCreator() {
				@Override
				public java.sql.PreparedStatement createPreparedStatement(java.sql.Connection con) throws SQLException {
					PreparedStatement ps = con.prepareStatement(updatesql);
					ps.setString(1, user.getName());
					ps.setString(2, user.getEmail());
					ps.setString(3, user.getContact());
					ps.setString(4, user.getAddress());
					ps.setInt(5, user.getRoll_id());
					ps.setInt(6, user.getId());
					return ps;
				}
			});

			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}

	}
	/*
	 * <=====Edit Employee Using Statement=====>
	 * 
	 * @Override public int editEmployee(User user) {
	 * 
	 * try { String sql = "update employee_details set name='" + user.getName() +
	 * "',email='" + user.getEmail() + "',mobileno='" + user.getContact() +
	 * "',address='" + user.getAddress() + "',roll_id='" + user.getRoll_id() +
	 * "' where id='" + user.getId() + "'"; System.err.println("sql query" + sql);
	 * return jdbcTemplate.update(sql); } catch (Exception e) { return 0; } }
	 */

	@Override
	public int addEmployee(User user) {
		try {
			System.err.println("NAME=======" + user.getName());
			String insertsql = "INSERT INTO employee_details(emp_id,name,email,password,mobileno,gender,dob,address,roll_id,status_id) VALUES(?,?,?,?,?,?,?,?,?,?)";
			jdbcTemplate.update(new PreparedStatementCreator() {
				@Override
				public java.sql.PreparedStatement createPreparedStatement(java.sql.Connection con) throws SQLException {
					PreparedStatement ps = con.prepareStatement(insertsql);
					ps.setString(1, user.getEmp_id());
					ps.setString(2, user.getName());
					ps.setString(3, user.getEmail());
					ps.setString(4, user.getPassword());
					ps.setString(5, user.getContact());
					ps.setString(6, user.getGender());
					ps.setString(7, user.getDob());
					ps.setString(8, user.getAddress());
					ps.setInt(9, user.getRoll_id());
					ps.setInt(10, user.getStatus_id());

					return ps;
				}
			});

			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}

	}
}