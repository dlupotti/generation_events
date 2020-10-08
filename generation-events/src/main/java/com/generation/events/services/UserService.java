package com.generation.events.services;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generation.events.entities.User;
import com.generation.events.model.IUser;
import com.generation.events.repositories.IUserRepository;

@Service
public class UserService implements IUserService {
	
	@Autowired
	private IUserRepository repo;

	@Override
	public User findOne(int userId) {
		return repo.findById(userId).get();
	}

	@Override
	public User findByEmail(String email) {
		return repo.findByEmail(email);
	}

}
