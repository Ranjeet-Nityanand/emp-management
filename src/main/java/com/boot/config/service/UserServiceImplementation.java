package com.boot.config.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.config.repository.IUserRepository;

import login.Product;
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

				
				int emailcount = iUserRepository.validateRegister(user);
				System.err.println("emailcount========"+emailcount);
				if (emailcount ==0) {
					
				user.setStatus_id(1);
				if (user.getRoll_id() == null) {
					user.setRoll_id(3);
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
				else
					return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int validateRegister(User user) {
		int emailcount = 0;
		try {
		 emailcount = iUserRepository.validateRegister(user);
		System.err.println("====count========"+emailcount);
		
	
				int register = iUserRepository.registerUser(user).intValue();
				user.setId(register);
				List<User> userList = iUserRepository.getAllEmployee(user);
				System.err.println("After DB ISERT " + userList.isEmpty());
				if (userList != null) {

					User dbuser = userList.get(0);
					return emailcount;
				}

				return null;
			}

			else
				return null;
		} catch (Exception e) {
			return null;
		}
		 catch (Exception e) {
			e.printStackTrace();
		
		
	
		 }
		return emailcount;
	
		}
		

	}

//For change Status.
	@Override
	public List<User> updateemployeeStatus(User user) {

		try {
			iUserRepository.updateemployeeStatus(user);

		} catch (Exception e) {
			e.printStackTrace();
		}
		List<User> alluser = iUserRepository.getAllEmployee(user);
		return alluser;
	}

	@Override
	public List<User> editEmployee(User user) {

		try {
			if (user != null && user.getEmail() != null && user.getEmail().trim() != null && user.getName() != null
					&& user.getAddress() != null && user.getContact() != null && user.getRoll_id() != 0
					&& user.getId() != 0) {
				iUserRepository.editEmployee(user);
			} else
				return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		try {
			List<User> user2 = iUserRepository.getAllEmployee(user);
			return user2;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<User> addEmployee(User user) {

		try {
			if (user != null && user.getEmail() != null && user.getEmail().trim() != null) {
				iUserRepository.addEmployee(user);
			} else
				return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		try {
			List<User> user2 = iUserRepository.getAllEmployee(user);
			return user2;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public List<Product> addProduct(Product product) {
		try {
			if (product != null && product.getName() != null && product.getName().trim() != null
					&& product.getPrice() != null) {
				iUserRepository.addProduct(product);
			} else
				return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		try {
			List<Product> product1 = iUserRepository.getAllProduct(product);
			return product1;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Product> getAllProduct(Product product) {
		List<Product> allproduct = iUserRepository.getAllProduct(product);
		return allproduct;
	}

	@Override
	public List<Product> editProduct(Product product) {
		try {
			if (product != null && product.getName() != null && product.getName().trim() != null
					&& product.getPrice() != null) {
				iUserRepository.editProduct(product);
			} else
				return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		try {
			List<Product> product2 = iUserRepository.getAllProduct(product);
			return product2;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public List<Product> addItems(Product additem) {
		try
		{
			if(additem !=null)
			{
				iUserRepository.addItems(additem);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}

