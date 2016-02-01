package com.gvivies.cave.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.gvivies.cave.model.User;

public interface UserRepository extends MongoRepository<User, String>{

	public User findByUsername(String username);
	public Optional<User> findOneByEmail(String email);

}