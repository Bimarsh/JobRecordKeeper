package com.job.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.job.modal.Employer;
import com.job.modal.EmployerType;

@Repository
public interface EmployerRepository extends MongoRepository<Employer, String> {
	
	public List<Employer> findByEmployerType(EmployerType emptype);
	public List<Employer> findByAddressState(String state);

}
