package com.job.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.job.modal.User;
import com.job.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	
	@Override
	public User getUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}

}
