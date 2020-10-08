package com.generation.events.services;

import com.generation.events.dto.UserDTO;
import com.generation.events.entities.User;

public interface ILoginService {

	void saveSessionUser(User u);
	
	User getUserSession();
	
	void removeUserSession();
	
	boolean isLogged();
	
	boolean isUserAmmistrator();
	
	boolean isUserExpert();
	
	boolean checkPassword(User u, UserDTO uDTO);
}
