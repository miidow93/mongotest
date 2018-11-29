package com.mongodb.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.mongodb.model.User;

public interface UserRepository extends MongoRepository<User, String> {
	@Query("{ 'username' : ?0 }")
	List<User> findByUsername(String username);
}
