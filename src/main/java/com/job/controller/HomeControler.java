package com.job.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeControler {
	
	@RequestMapping(value="/")
	String index()
	{
		return "index.html";
	}

}
