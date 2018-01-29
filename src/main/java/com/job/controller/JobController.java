package com.job.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.job.modal.Employer;
import com.job.modal.EmployerType;
import com.job.modal.Job;
import com.job.modal.User;
import com.job.service.CustomUserDetail;
import com.job.service.EmployerService;
import com.job.service.JobService;
import com.job.service.UserService;

@CrossOrigin
@RestController
@RequestMapping("/jobs")
public class JobController {

	@Autowired
	private UserService userService;

	@Autowired
	private JobService jobService;

	@Autowired
	private EmployerService employerService;

	@RequestMapping(value = "", method = RequestMethod.POST)
	public Job postNewJob(@RequestBody Job job, @AuthenticationPrincipal CustomUserDetail userDetail) {
		// save user reference with the job
		User user = userDetail.getUser();
		job.setUser(user);
		
		return jobService.recordJob(job);
		
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<Job> getallJobs(@AuthenticationPrincipal CustomUserDetail userDetail) {
		User user = userDetail.getUser();
		return jobService.getJobByUser(user);
	}

	@RequestMapping(value = "/recruiters", method = RequestMethod.GET)
	public List<Employer> getAllRecruiters() {
		return employerService.getEmployerBytype(EmployerType.RECRUITER);
	}

	@RequestMapping(value = "/directHires", method = RequestMethod.GET)
	public List<Employer> getAllDirectHires() {
		return employerService.getEmployerBytype(EmployerType.DIRECTHIRE);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Job getJobById(@PathVariable("id") String id) {
		return jobService.getJobById(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteById(@PathVariable("id") String id) {
		jobService.deleteJobById(id);
	}

	@RequestMapping(value = "/disable/{id}", method = RequestMethod.GET)
	public void disableJobById(@PathVariable("id") String id) {
		jobService.disableJob(id);
	}

	@RequestMapping(value = "/enable/{id}", method = RequestMethod.GET)
	public void enableJobById(@PathVariable("id") String id) {
		jobService.enableJob(id);
	}

	// public List<Employers> getEmployersByAddress()

}
