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
			if (user != null && user.getEmail() != null && user.getEmail().trim() != null && user.getPassword() != null
					&& user.getPassword().trim() != null) {
				User useradmin = iUserRepository.validateUser(user);
				return useradmin;
			} else {
				return null;
			}
		} catch (Exception e) {
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
			if (user != null && user.getEmail() != null && user.getEmail().trim() != null) {

				user.setStatus_id(1);
				if (user.getRoll_id() == null) {
					user.setRoll_id(2);
				}
				int register = iUserRepository.registerUser(user).intValue();
				System.err.println("LAST ID===" + register);
				user.setId(register);
				List<User> userList = iUserRepository.getAllEmployee(user);

				
				if (userList != null) {

					User dbuser = userList.get(0);
					System.err.println("value============================" + dbuser.getId());
					return dbuser;
				}
			}

			return null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
