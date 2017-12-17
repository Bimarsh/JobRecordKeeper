package com.job.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.job.modal.Employer;
import com.job.modal.EmployerType;
import com.job.modal.Job;
import com.job.service.EmployerService;
import com.job.service.JobService;

@CrossOrigin
@RestController
@RequestMapping("/jobs")
public class JobController {
	
	@Autowired
	private JobService jobService;
	
	@Autowired
	private EmployerService employerService;
	
	@RequestMapping(value="",method=RequestMethod.POST)
	public Job postNewJob(@RequestBody Job job)
	{
		return jobService.recordJob(job);
	}
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public List<Job> getallJobs()
	{
		return jobService.getallJobs();
	}
	
	@RequestMapping(value="/recruiters",method=RequestMethod.GET)
	public List<Employer> getAllRecruiters()
	{
		return employerService.getEmployerBytype(EmployerType.RECRUITER);
	}
	
	@RequestMapping(value="/directHires",method=RequestMethod.GET)
	public List<Employer> getAllDirectHires()
	{
		return employerService.getEmployerBytype(EmployerType.DIRECTHIRE);
	}
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public Job getJobById(@PathVariable("id")String id)
	{
		return jobService.getJobById(id);
	}
	//public List<Employers> getEmployersByAddress()

}
