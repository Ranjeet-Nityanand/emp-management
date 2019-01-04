package com.boot.config.dto;

import login.User;

public class DTODomainConverter {
	public static User convertRegiterDTOToDomain(RegisterDTO register)
	{
		User user=new User();
		user.setName(register.getName());
		user.setEmail(register.getEmail());
		user.setDob(register.getDob());
		user.setContact(register.getContact());
		user.setGender(register.getGender());
		user.setAddress(register.getAddress());
		user.setPassword(register.getPassword());
		user.setCpassword(register.getCpassword());
		
				
				
		return user;
		
	}
	public static RegisterDTO convertDomainToRegisterDTO(User user)
	{
		RegisterDTO registerdto=new RegisterDTO();
		registerdto.setName(user.getName());
		registerdto.setEmail(user.getEmail());
		registerdto.setAddress(user.getAddress());
		registerdto.setContact(user.getContact());
		registerdto.setDob(user.getDob());
		registerdto.setGender(user.getGender());
		registerdto.setPassword(user.getPassword());
		
		return registerdto;
		
	}

}
