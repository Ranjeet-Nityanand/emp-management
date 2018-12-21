package com.boot.config.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.boot.config.resultmapper.UserMapper;
import com.mysql.jdbc.Statement;

import login.User;
@Repository
public class UserRepositoryImplementation implements IUserRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
		@Override
		public User validateUser(User user) {
			try {


					
				String sql="select email,password,status_id,roll_id,name from employee_manage.employee_details where email='"+user.getEmail().trim()+
						"'and binary password='"+user.getPassword().trim()+"'and status_id=1";
			System.err.println("--SQL ___  "+sql);

				user=jdbcTemplate.queryForObject(sql, new UserMapper());
				user.getRoll_id();
				return user;
			}catch(Exception e) {
				System.out.println(e);
				return null;
			}
			
		}

		
		
		public Long registerUser(User user) {
				try {
					System.err.println("NAME======="+user.getName());
				  String insertsql="INSERT INTO employee_details(email,name,password,mobileno,gender,dob,address) VALUES(?,?,?,?,?,?,?)";
				  KeyHolder holder = new GeneratedKeyHolder();
				  jdbcTemplate.update(new PreparedStatementCreator() {
				
					@Override
					public java.sql.PreparedStatement createPreparedStatement(java.sql.Connection con) throws SQLException {
						PreparedStatement ps =  con.prepareStatement(insertsql, Statement.RETURN_GENERATED_KEYS);
					
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
				  
				  
				  System.err.println("holder.getKey().longValue()   "+holder.getKey().longValue());
				return  holder.getKey().longValue();
				  
			}catch (Exception e) {
				return null;
			}
			
		}

		
	}
	/*
		/*public User registerUser(User user)
		{
			try {
			System.err.println("NAME======="+user.getName());
			
				String sql="Insert INTO employee_details(email,name,password,mobileno,gender,dob,address) VALUES(?,?,?,?,?,?,?)";
				
				
				jdbcTemplate.update(sql,new Object[] {user.getEmail(),user.getName(),user.getPassword(),user.getContact(),user.getGender(),user.getDob(),user.getAddress()});
			
			 
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return null;
			
			}
			}
			
		*/


