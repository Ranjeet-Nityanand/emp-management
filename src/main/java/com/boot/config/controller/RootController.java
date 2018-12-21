package com.boot.config.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.boot.config.service.IUserService;

import login.User;

@Controller
public class RootController {
	@Autowired
	IUserService iUserService;
	@RequestMapping("/")
	public ModelAndView indexController() {
		ModelAndView view= new ModelAndView();
		view.setViewName("view/index");
		return view;
	}
	
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	 public ModelAndView indexController(@RequestParam ("email") String email,@RequestParam("password") String password) {
		 ModelAndView view=new ModelAndView();
		 User login=new User();
		 login.setEmail(email);
		 login.setPassword(password);
		 System.err.println(login.getPassword());
		 System.err.println(login.getEmail());
		 User user1 = iUserService.validateUser(login);
		 if(user1!=null) {
		 view.addObject("ranjeet",user1);
		 view.setViewName("view/adminprofile");
		 }else {
			 view.addObject("message","Sorry User or Password Wrong!!!");
			 view.setViewName("view/index");
		 }
		 return view;
	}
	@RequestMapping(value="/register",method=RequestMethod.POST)
	 public ModelAndView register(@RequestParam("email") String email,@RequestParam("name") String name,@RequestParam("contact") String contact,@RequestParam("password") String password,@RequestParam("dob") String dob,
				@RequestParam("address")String address,@RequestParam("gender") String gender) {
		ModelAndView view=new ModelAndView();
		User register=new User();
		register.setName(name);
		register.setEmail(email);
		register.setDob(dob);
		register.setAddress(address);
		register.setGender(gender);
		register.setPassword(password);
		register.setContact(contact);
		
		return view;
		
	
	}
}
