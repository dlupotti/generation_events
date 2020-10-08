package com.generation.events.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.events.entities.User;

public interface IUserRepository extends JpaRepository<User, Integer> {
	
	public User findByEmail(String email);
//	User findByUserId(String userId);
	
}
