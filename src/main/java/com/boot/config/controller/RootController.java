package com.boot.config.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.boot.config.service.IUserService;

import login.Product;
import login.User;

@Controller
public class RootController {
	@Autowired
	IUserService iUserService;
	List<User> allemployee;
	List<Product> allproduct;

	@RequestMapping("/")
	public ModelAndView indexController() {
		ModelAndView view = new ModelAndView();
		view.setViewName("view/index");
		return view;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView indexController(@RequestParam("email") String email,
			@RequestParam("password") String password) {
		ModelAndView view = new ModelAndView();

		if (email != null && password != null) {
			User login = new User();
			login.setEmail(email);
			login.setPassword(password);

			User user1 = iUserService.validateUser(login);
			if (user1 != null) {
				if (user1.getRoll_id() == 1) {
					view.addObject("ranjeet", user1);
					view.setViewName("view/adminprofile");
				}
				if (user1.getRoll_id() == 2) {
					view.addObject("ranjeet", user1);
					view.setViewName("view/userprofile");
				}

			} else {
				view.addObject("message", "Sorry You Wrong entries!!!");
				// view.setViewName("redirect:/");
				view.setViewName("view/index");
			}
		} else {
			view.addObject("message", "Email or Password Cannot be Blank");
			view.setViewName("view/index");
		}
		return view;
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView register(@RequestParam("email") String email, @RequestParam("name") String name,
			@RequestParam("contact") String contact, @RequestParam("password") String password,
			@RequestParam("dob") String dob, @RequestParam("address") String address,
			@RequestParam("gender") String gender) {
		ModelAndView view = new ModelAndView();
		System.err.println("Register User ------------------------");
		User register = new User();
		register.setName(name);
		register.setEmail(email);
		register.setDob(dob);
		register.setAddress(address);
		register.setGender(gender);
		register.setPassword(password);
		register.setContact(contact);
		User dbuser = iUserService.addUser(register);
		if (dbuser != null) {
			System.err.println("After Insert In DB Controller :" + dbuser.getId() + "" + dbuser.getMobileno());
		}

		view.setViewName("view/userinfo");
		return view;
	}

	@RequestMapping("/viewallEmployee")
	public ModelAndView allUser() {
		ModelAndView view = new ModelAndView();
		User user = new User();
		List<User> allemployee = iUserService.getAllEmployee(user);
		System.err.println(allemployee.isEmpty());
		view.addObject("allUser", allemployee);
		System.err.println("Testing");
		view.setViewName("view/viewallemployee");
		return view;
	}

	@RequestMapping(value = "/update-emp-status", method = RequestMethod.GET)
	@ResponseBody // return data as json Formate
	public List<User> updateemployeeStatus(@RequestParam("email") String email,
			@RequestParam("status") Integer status) {
		User user2 = new User();
		user2.setEmail(email);
		user2.setStatus_id(status);
		System.err.println("value=" + user2.getEmail() + "==" + user2.getStatus_id());
		List<User> alluser1 = iUserService.updateemployeeStatus(user2);
		System.err.println("Length ----" + alluser1.size());
		return alluser1;
	}

	@RequestMapping(value = "/editEmployee", method = RequestMethod.POST)
	public ModelAndView editEmployee(@RequestParam("name") String name, @RequestParam("email") String email,
			@RequestParam("contact") String contact, @RequestParam("address") String address,
			@RequestParam("role") String role, @RequestParam("id") String id) {
		ModelAndView view = new ModelAndView();

		User register = new User();
		register.setName(name);
		register.setEmail(email);
		register.setAddress(address);
		register.setContact(contact);
		try {
			register.setRoll_id(Integer.parseInt(role));
			register.setId(Integer.parseInt(id));
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.err.println("Getting Id from view all user" + id);
		List<User> dbuser = iUserService.editEmployee(register);
		// System.err.println("Retrieve from Service" + dbuser);

		if (dbuser != null) {
			User viewemp = new User();
			allemployee = iUserService.getAllEmployee(viewemp);
			System.err.println(allemployee.isEmpty());
			view.addObject("allUser", allemployee);
			view.addObject("successmsg", "Updation Successfull");
			view.setViewName("view/viewallemployee");
		} else {
			view.addObject("allUser", allemployee);
			view.addObject("message1", "Updation uncessfull");
			view.setViewName("view/viewallemployee");
		}
		return view;
	}

	@RequestMapping("/add-employee")
	public ModelAndView addEmployee() {
		ModelAndView view = new ModelAndView();
		view.setViewName("view/addemployee");
		return view;
	}

	@RequestMapping(value = "/addemployee", method = RequestMethod.POST)
	public ModelAndView editEmployee(@RequestParam("status") String statusid, @RequestParam("role") String roleid,
			@RequestParam("id") String empid, @RequestParam("email") String email, @RequestParam("name") String name,
			@RequestParam("contact") String contact, @RequestParam("password") String password,
			@RequestParam("dob") String dob, @RequestParam("address") String address,
			@RequestParam("gender") String gender) {
		ModelAndView view = new ModelAndView();
		System.err.println("Add User ------------------------");
		User addemp = new User();
		addemp.setName(name);
		addemp.setEmail(email);
		addemp.setDob(dob);
		addemp.setAddress(address);
		addemp.setGender(gender);
		addemp.setPassword(password);
		addemp.setContact(contact);
		addemp.setEmp_id(empid);
		try {
			addemp.setRoll_id(Integer.parseInt(roleid));
			addemp.setStatus_id(Integer.parseInt(statusid));
		} catch (Exception e) {
			e.printStackTrace();
		}
		List<User> employee = iUserService.addEmployee(addemp);
		if (employee != null) {
			User viewemp = new User();
			allemployee = iUserService.getAllEmployee(viewemp);
			System.err.println(allemployee.isEmpty());
			view.addObject("allUser", allemployee);
			view.addObject("successmsg", "Added Successfull");
			view.setViewName("view/viewallemployee");
		} else {
			view.addObject("allUser", allemployee);
			view.addObject("message1", "!!! Record Not Added ");
			view.setViewName("view/viewallemployee");
		}
		return view;
	}

	@RequestMapping("/add-product")
	public ModelAndView addProduct() {
		ModelAndView view = new ModelAndView();
		view.setViewName("view/addproduct");
		return view;
	}

	@RequestMapping(value = "/addproduct", method = RequestMethod.POST)
	public RedirectView addProduct(@RequestParam("name") String productname, @RequestParam("price") String productprice,
			@RequestParam("quantity") String quantity, RedirectAttributes attributes) {
		// ModelAndView view = new ModelAndView();
		Product addproduct = new Product();
		addproduct.setName(productname);

		try {
			addproduct.setQuantity(Integer.parseInt(quantity));
			addproduct.setPrice(Float.parseFloat(productprice));
		} catch (Exception e) {
			e.printStackTrace();
		}
		List<Product> product = iUserService.addProduct(addproduct);

		if (product != null) {
			Product viewproduct = new Product();
			allproduct = iUserService.getAllProduct(viewproduct);
			System.err.println(allproduct.isEmpty());
			// view.addObject("allUser", allproduct);
			// view.addObject("successmsg", "Added Successfull");
			attributes.addFlashAttribute("message", "Inserted Successfully");
			return new RedirectView("viewallProduct");
		} else {
			// view.addObject("allUser", allproduct);
			attributes.addFlashAttribute("message", "Not Inserted");
			// view.addObject("message1", "!!! Record Not Added ");
			// view.setViewName("redirect:viewallProduct");
			return new RedirectView("viewallProduct");
		}

		// return new;
	}

	@RequestMapping("/viewallProduct")
	public ModelAndView allProduct() {
		ModelAndView view = new ModelAndView();
		Product product = new Product();
		List<Product> allproduct = iUserService.getAllProduct(product);
		System.err.println(allproduct.isEmpty());
		view.addObject("allUser", allproduct);
		System.err.println(allproduct);
		view.setViewName("view/viewallproduct");
		return view;
	}

	@RequestMapping(value = "/editProduct", method = RequestMethod.POST)
	public ModelAndView editProduct(@RequestParam("name") String productname,
			@RequestParam("price") String productprice, @RequestParam("quantity") String quantity,
			@RequestParam("id") int prodid) {
		ModelAndView view = new ModelAndView();

		Product editprod = new Product();
		editprod.setName(productname);
		editprod.setId(prodid);
		try {
			editprod.setQuantity(Integer.parseInt(quantity));
			editprod.setPrice(Float.parseFloat(productprice));
		} catch (Exception e) {
			e.printStackTrace();
		}
		List<Product> prod = iUserService.editProduct(editprod);
		if (prod != null) {
			System.err.println("Edited product ================" + prod);
			Product viewprod = new Product();
			allproduct = iUserService.getAllProduct(viewprod);
			System.err.println(allproduct.isEmpty());
			view.addObject("allUser", allproduct);
			view.addObject("successmsg", "Updation Successfull");
			view.setViewName("redirect:viewallProduct");
		} else {
			view.addObject("allUser", allproduct);
			view.addObject("message1", "Updation uncessfull");
			view.setViewName("redirect:viewallProduct");
		}
		return view;
	}

//	@RequestMapping(value = "/passwordReset", method = RequestMethod.POST)
//	public ModelAndView passwordReset(@RequestParam("email") String email) {
//		ModelAndView view = new ModelAndView();
//		User user = new User();
//		user.setEmail(email);
//		User useremail = iUserService.resetPassword(user);
//		if (useremail != null) {
//			view.addObject("resetp", useremail);
//			view.setViewName("view/index");
//		} else {
//			view.addObject("resetp", "invalid credentials!!!");
//			view.setViewName("view/index");
//		}
//		return view;
//	}

}