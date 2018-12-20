package com.boot.config.repository;

import org.springframework.beans.factory.annotation.Autowired;
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
				String sql="select * from employee_manage.emp_details where email='"+user.getEmail().trim()+
						"' and binary password='"+user.getPassword().trim()+"' ";
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

}
