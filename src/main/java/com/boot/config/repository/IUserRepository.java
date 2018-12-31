package com.boot.config.repository;

import java.util.List;

import login.User;

public interface IUserRepository {
	public User validateUser(User user);

	public Long registerUser(User user);
	
	public List<User> getAllEmployee(User user);

		public int validateRegister(User user);

	public 	List<User> getAllItem(User user);


}


	

	


