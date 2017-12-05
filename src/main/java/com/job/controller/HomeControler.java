package com.job.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeControler {
	
	@RequestMapping(value="/")
	String index()
	{
		return "Welcome Boy";
	}

}
