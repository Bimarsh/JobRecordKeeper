package com.job.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.job.modal.Role;
import com.job.modal.User;
import com.job.service.UserService;

@Controller
public class HomeControler {
	
	@Autowired
	UserService userService;
	
//	@RequestMapping(value="/successHomepage", method=RequestMethod.GET)
//	public String returnHomePage()
//	{
//		return "index.html";
//	}
	
	@RequestMapping(value="/registerNewUser", method=RequestMethod.POST)
    public String registerNewUser(User user)
    {
		List<Role> listofRole= new ArrayList<>();
		listofRole.add(Role.USER);
		user.setListofRole(listofRole);
		userService.saveUser(user);
		return "redirect:/logout";
    }
}
