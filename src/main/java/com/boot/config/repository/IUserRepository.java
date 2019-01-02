package com.boot.config.repository;

import java.util.List;

import login.Product;
import login.User;

public interface IUserRepository {
	public User validateUser(User user);

	public Long registerUser(User user);

	public List<User> getAllEmployee(User user);

	public int updateemployeeStatus(User user);

	public int editEmployee(User user);

	public int addEmployee(User user);

	public int addProduct(Product product);

	public List<Product> getAllProduct(Product product);

	public int editProduct(Product user);

//	public User resetPassword(User user);
}