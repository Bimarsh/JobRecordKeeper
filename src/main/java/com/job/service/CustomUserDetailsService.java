package com.job.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.job.modal.User;
import com.job.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user= userRepository.findByEmail(username);
		if(user==null)
		{
			System.out.println("Username not found");
			throw new UsernameNotFoundException("User with username: "+username+" not found");
		}
		System.out.println("Username found yeah////////////////////////////////////////////");
		return new CustomUserDetail(user);
	}

}
