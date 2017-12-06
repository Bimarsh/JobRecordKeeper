package com.job.modal;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;

public class Job {

	@Id
	private String id;
	private String position;
	private Employer recruiter;
	private Employer directHire;
	private String jobDescription;
	private LocalDate registeredDate;
	private LocalDate dateApplied;
	private LocalDate interviewDate;

	public LocalDate getInterviewDate() {
		return interviewDate;
	}

	public void setInterviewDate(LocalDate interviewDate) {
		this.interviewDate = interviewDate;
	}

	public LocalDate getRegisteredDate() {
		return registeredDate;
	}

	public void setRegisteredDate(LocalDate registeredDate) {
		this.registeredDate = registeredDate;
	}

	public LocalDate getDateApplied() {
		return dateApplied;
	}

	public void setDateApplied(LocalDate dateApplied) {
		this.dateApplied = dateApplied;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Employer getRecruiter() {
		return recruiter;
	}

	public void setRecruiter(Employer recruiter) {
		this.recruiter = recruiter;
	}

	public Employer getDirectHire() {
		return directHire;
	}

	public void setDirectHire(Employer directHire) {
		this.directHire = directHire;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	

}
