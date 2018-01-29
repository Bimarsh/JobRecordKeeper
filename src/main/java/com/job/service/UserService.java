package com.job.service;

import com.job.modal.User;

public interface UserService {
	public User getUserByEmail(String email);

	public User saveUser(User user);
}
