package com.boot.config.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
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

					
				String sql="select ed.id,ed.email,ed.password,ed.name,ed.roll_id,ed.status_id,ed.emp_id,ed.mobileno,ed.address,rm.roll_value from employee_details ed, roll_master rm where ed.roll_id = rm.roll_id and ed.email='"+user.getEmail().trim()+
						"'and binary ed.password='"+user.getPassword().trim()+"'and ed.status_id=1";
			System.err.println("Validate User SQL --  "+sql);
				user=jdbcTemplate.queryForObject(sql, new UserMapper());
				return user;
			}catch(Exception e) {
				System.out.println(e);
				return null;
			}
			
		}
		
		public User register(User user) {
			try {
				String sql="INSERT INTO ";
			}
			
			catch(Exception e)
			{ 
				System.err.print("error===" +e);
			}
			
			return null;
			
		}

		@Override
		public List<User> getAllEmployee(User user) {
			try {
				String sql ="select ed.id,ed.email,ed.password,ed.name,ed.roll_id,ed.status_id,ed.emp_id,ed.mobileno,ed.address,rm.roll_value from employee_details ed, roll_master rm"+
			      " where ed.roll_id = rm.roll_id ";
				if(user!=null && user.getId()>0) {
					sql+= " and ed.id = "+user.getId();
				}
				
				List<User> employeeList = jdbcTemplate.query(sql, new UserMapper());
				return employeeList;	
			} catch (DataAccessException e) {
				return null;
			}
		}

}
