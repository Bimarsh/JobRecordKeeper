package com.job.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.job.modal.Employer;
import com.job.modal.EmployerType;
import com.job.repository.EmployerRepository;

@Service
public class EmployerServiceImpl implements EmployerService {
	
	@Autowired
	private EmployerRepository employerRepository;

	@Override
	public List<Employer> getEmployerBytype(EmployerType emptype) {
		return employerRepository.findByEmployerType(emptype);
	}

	@Override
	public List<Employer> getAllEmployers() {
		return employerRepository.findAll();
	}

	@Override
	public List<Employer> getEmployerByState(String state) {
		return employerRepository.findByAddressState(state);
	}

	

}
