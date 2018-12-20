package com.boot.config.repository;

import login.User;

public interface IUserRepository {
	public User validateUser(User user);
}