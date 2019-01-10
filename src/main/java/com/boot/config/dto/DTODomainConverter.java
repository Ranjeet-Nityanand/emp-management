package com.boot.config.dto;

import login.CartDomain;
import login.Product;
import login.User;

public class DTODomainConverter {
	public static User convertRegiterDTOToDomain(RegisterDTO register) {
		User user = new User();
		user.setName(register.getName());
		user.setEmail(register.getEmail());
		user.setDob(register.getDob());
		user.setContact(register.getContact());
		user.setGender(register.getGender());
		user.setAddress(register.getAddress());
		user.setPassword(register.getPassword());
//		user.setCpassword(register.getCpassword());

		return user;

	}

	public static RegisterDTO convertDomainToRegisterDTO(User user) {
		RegisterDTO registerdto = new RegisterDTO();
		registerdto.setName(user.getName());
		registerdto.setEmail(user.getEmail());
		registerdto.setAddress(user.getAddress());
		registerdto.setContact(user.getContact());
		registerdto.setDob(user.getDob());
		registerdto.setGender(user.getGender());
		registerdto.setPassword(user.getPassword());

		return registerdto;

	}

	public static Product convertProductDTOToDomain(ProductDTO prd) {
		Product product = new Product();
		product.setName(prd.getName());
		product.setPrice(prd.getPrice());
		product.setQuantity(prd.getQuantity());
		product.setId(prd.getId());
		return product;
	}

	public static ProductDTO convertProductDomainToDTO(Product product) {
		ProductDTO prdo = new ProductDTO();
		prdo.setName(product.getName());
		prdo.setPrice(product.getPrice());
		prdo.setQuantity(product.getQuantity());
		prdo.setId(product.getId());
		return prdo;
	}

	public static User convertAddEmployeeDTOToDomain(EmployeeDTO addempdto) {
		User user = new User();
		user.setEmp_id(addempdto.getEmpid());
		user.setAddress(addempdto.getAddress());
		user.setContact(addempdto.getContact());
		user.setDob(addempdto.getDob());
		user.setEmail(addempdto.getEmail());
		user.setGender(addempdto.getGender());
		user.setStatus_id(addempdto.getStatus());
		user.setName(addempdto.getName());
		user.setPassword(addempdto.getPassword());
		user.setRoll_id(addempdto.getRole());
		user.setId(addempdto.getId());

		return user;
	}

	public static EmployeeDTO convertAddEmployeeDomainToDTO(User user2) {
		EmployeeDTO addemployee = new EmployeeDTO();
		addemployee.setEmpid(user2.getEmp_id());
		addemployee.setAddress(user2.getAddress());
		addemployee.setContact(user2.getContact());
		addemployee.setDob(user2.getDob());
		addemployee.setEmail(user2.getEmail());
		addemployee.setGender(user2.getGender());
		addemployee.setStatus(user2.getStatus_id());
		addemployee.setName(user2.getName());
		addemployee.setPassword(user2.getPassword());
		addemployee.setRole(user2.getRoll_id());
		addemployee.setRollName(user2.getRollName());
		return addemployee;
	}

	public static CartDomain convertCartDTOToDomain(CartDTO cdto) {
		CartDomain cdomain = new CartDomain();
		cdomain.setId(cdto.getId());
		cdomain.setUserid(cdto.getUserid());
		cdomain.setItemid(cdto.getItemid());
		cdomain.setItemprice(cdto.getItemprice());
		cdomain.setItemquantity(cdto.getSelecteditem());
		cdomain.setItemname(cdto.getItemname());
		return cdomain;
	}

}
