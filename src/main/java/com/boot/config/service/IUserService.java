package com.boot.config.service;

import java.util.List;

import login.Product;
import login.User;

public interface IUserService {

public int validateRegister(User user);

public User validateUser(User user);

	public User addUser(User user);

	public List<User> getAllEmployee(User user);

	public List<User> updateemployeeStatus(User user);

	public List<User> editEmployee(User user);

	public List<User> addEmployee(User user);

	public List<Product> addProduct(Product product);

	public List<Product> getAllProduct(Product product);

	public List<Product> editProduct(Product product);

	public List<Product> addItems(Product additem);

}
