package com.job.modal;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;

public class User {
	
	@Id
	private String id;
	@Indexed(unique=true)
	private String email;
	private String password;
	private String firstName;
	private String lastName;

	private List<Job> listofJob = new ArrayList<>();
	private List<Role> listofRole= new ArrayList<>();

	public List<Role> getListofRole() {
		return listofRole;
	}

	public void setListofRole(List<Role> listofRole) {
		this.listofRole = listofRole;
	}

	public List<Job> getListofJob() {
		return listofJob;
	}

	public void setListofJob(List<Job> listofJob) {
		this.listofJob = listofJob;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
}
