package com.job.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.job.modal.Employer;
import com.job.modal.Job;


@Repository
public interface JobRepository extends MongoRepository<Job, String> {

public List<Job> findByRegisteredDate(LocalDate registeredDate);
public List<Job> findByDateApplied(LocalDate dateApplied);

}
