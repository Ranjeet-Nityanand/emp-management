package com.boot.config.service;

import java.util.List;
import login.User;


public interface IUserService {
public User validateUser( User user);


public User addUser(User user);
public List<User> getAllEmployee( User user);


public int validateRegister(User user);




}
