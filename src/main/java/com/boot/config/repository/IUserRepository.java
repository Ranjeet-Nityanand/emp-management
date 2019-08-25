package com.boot.config.repository;

import java.util.List;

import login.CartDomain;
import login.Product;
import login.User;

public interface IUserRepository {
	public User validateUser(User user);

	public Long registerUser(User user);

	public List<User> getAllEmployee(User user);

	public int validateRegister(User user);

	public int updateemployeeStatus(User user);

	public int editEmployee(User user);

	public int addEmployee(User user);

	public int addProduct(Product product);

	public List<Product> getAllProduct(Product product);

	public int editProduct(Product user);

	public List<User> addUserItem(User user);

	public void addItems(Product additem);

	public int addCardData(CartDomain cartdomain);

	public int removeCardData(CartDomain cartdomain);

	public List<CartDomain> getAllCartData(CartDomain crd);

	int itemCount(CartDomain additem);

	public void updateCartItem(CartDomain cartdomain);

	public User sendEmail(User user);

	public int validateEmployee(User addemp);
}
