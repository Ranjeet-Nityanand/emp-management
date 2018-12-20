package com.boot.config.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.config.repository.IUserRepository;

import login.User;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImplementation implements IUserService {

	@Autowired
	IUserRepository iUserRepository;
	@Override
	public User validateUser(User user) {
		try {
			if(user!=null && user.getEmail()!=null && user.getEmail().trim()!=null && user.getPassword()!=null && user.getPassword().trim()!=null){
			User useradmin=iUserRepository.validateUser(user);
			return useradmin;
			}
			else {
				return null;
			}
			
		}catch(Exception e) {
			System.out.println(e);
			return null;
		}
			
	}

}
