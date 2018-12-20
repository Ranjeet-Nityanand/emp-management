package com.boot.config.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.boot.config.service.IUserService;

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
	
}
