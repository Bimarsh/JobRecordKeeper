package com.job.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.job.modal.Job;
import com.job.modal.User;
import com.job.reports.ExcelView;
import com.job.service.CustomUserDetail;
import com.job.service.JobService;

@Controller
@RequestMapping(value="/excelReport")
public class ReportController {
	
	@Autowired
	private JobService jobService;

	@RequestMapping(value="", method=RequestMethod.GET)
	public ExcelView returnExcel(Model model, @AuthenticationPrincipal CustomUserDetail customUserDetail)
	{
		User user= customUserDetail.getUser();
		List<Job> listofJob= jobService.getJobByUser(user);
		model.addAttribute("jobs", listofJob);
		model.addAttribute("user", user);
		return new ExcelView();
	}
}
