package com.job.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.job.modal.User;

public interface UserRepository extends MongoRepository<User, String> {
public User findByEmail(String email);
}
