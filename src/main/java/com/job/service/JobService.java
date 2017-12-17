package com.job.service;

import java.time.LocalDate;
import java.util.List;

import com.job.modal.Employer;
import com.job.modal.Job;

public interface JobService {
	
	public Job recordJob(Job job);
	public List<Job> getallJobs();
	public List<Job> getJobByRecruiter(Employer recruiter);
	public List<Job> getJobByDirectHire(Employer directHire);
	public List<Job> getJobByRegisteredDate(LocalDate registeredDate);
	public List<Job> getJobByDateApplied(LocalDate dateApplied);
	public Job getJobById(String id);

}
