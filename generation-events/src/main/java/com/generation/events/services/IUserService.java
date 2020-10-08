package com.generation.events.services;

import com.generation.events.entities.User;

public interface IUserService{
	
	User findOne(int userId);
	User findByEmail(String email);

}
