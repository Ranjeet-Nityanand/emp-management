package com.boot.config.controller;

import java.util.List;

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
		 
		if(email!= null && password!= null) {
		 User login=new User();
		 login.setEmail(email);
		 login.setPassword(password);
		
		 
		 User user1 = iUserService.validateUser(login);
		 if(user1!=null) {
		 if(user1.getRoll_id()==1) {
		 view.addObject("ranjeet",user1);
		 view.setViewName("view/adminprofile");
			 }
		 if(user1.getRoll_id()==2) {
				 view.addObject("ranjeet",user1);
				 view.setViewName("view/userprofile");
			 }
		
		 }else {
				view.addObject("message","Sorry You Wrong entries!!!");
				//view.setViewName("redirect:/");
				view.setViewName("view/index");
		 }
		}
		else {
			view.addObject("message","Email or Password Cannot be Blank");
			view.setViewName("view/index");
		}
		 return view;
		 }
		
	@RequestMapping("/viewallEmployee")
	public ModelAndView allUser() {
		ModelAndView view= new ModelAndView();
		User user = new User();
		List<User> allemployee = iUserService.getAllEmployee(user);
		System.err.println(allemployee.isEmpty());
		view.addObject("allUser",allemployee);
		System.err.println("Testing");
		view.setViewName("view/viewallemployee");
		return view;
	}
}

