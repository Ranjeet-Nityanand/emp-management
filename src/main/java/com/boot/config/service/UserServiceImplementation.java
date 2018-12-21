package com.boot.config.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.boot.config.repository.IUserRepository;
import login.User;

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
	@Override
	public List<User> getAllEmployee(User user) {
		List<User> allemployee = iUserRepository.getAllEmployee(user);
		return allemployee;
	}
	@Override
	public User addUser(User user) {
		try {
			if(user!=null && user.getEmail()!=null && user.getEmail().trim()!=null) {
				int register=iUserRepository.registerUser(user).intValue();
				System.err.print("LAST ID==="+register);
				user.setId(register);
				List<User> userList = iUserRepository.getAllEmployee(user);
				System.err.println("After DB ISERT "+userList.isEmpty());
				if(userList!=null) {

					User dbuser=userList.get(0);
					return dbuser;
				}
				
				
		return null;
			}
		
		
		
		else
			return null;
		}
		catch (Exception e) {
		return null;
		}
	}


}
