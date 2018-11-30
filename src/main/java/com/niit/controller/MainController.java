package com.niit.controller;

import com.niit.constants.UrlConstants;
import com.niit.constants.ViewConstants;
import com.niit.model.AdminModel;
import com.niit.model.FacultyModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

@Controller
public class MainController {

	@RequestMapping(value = "/",method = RequestMethod.GET)
	public ModelAndView sayHello(ModelAndView model) {
		model.addObject("faculty",new FacultyModel());
		model.setViewName(ViewConstants.USER_LOGIN);
		return model;
	}

	@RequestMapping(value = UrlConstants.ADMIN, method = RequestMethod.GET)
	public ModelAndView admin(@ModelAttribute("admin") AdminModel adminModel) {
		return new ModelAndView(ViewConstants.ADMIN_LOGIN,"admin",new AdminModel());
	}





}