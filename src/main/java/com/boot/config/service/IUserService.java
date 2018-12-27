package com.boot.config.service;

import java.util.List;

import login.User;

public interface IUserService {
	public User validateUser(User user);

	public User addUser(User user);

	public List<User> getAllEmployee(User user);

	public List<User> updateemployeeStatus(User user);

	public List<User> editEmployee(User user);

	public List<User> addEmployee(User user);
}
