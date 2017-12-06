package com.job.service;

import java.util.List;

import com.job.modal.Employer;
import com.job.modal.EmployerType;

public interface EmployerService {
	
	public List<Employer> getEmployerBytype(EmployerType emptype);
	public List<Employer> getAllEmployers();
	public List<Employer> getEmployerByState(String state);

}
