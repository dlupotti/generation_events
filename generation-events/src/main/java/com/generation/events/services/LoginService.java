package com.generation.events.services;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generation.events.dto.UserDTO;
import com.generation.events.entities.User;
import com.generation.events.model.IUser;

@Service
public class LoginService implements ILoginService, IUser  {
	
	@Autowired
	private HttpSession session;
	
	public void saveSessionUser(User u) {
		session.setAttribute(USER_LOGGED, u);
	}
	
	public User getUserSession() {
		return (User) session.getAttribute(USER_LOGGED);
	}
	
	public void removeUserSession() {
		session.removeAttribute(USER_LOGGED);
	}
	
	public boolean isUserAmmistrator() {
		User u = this.getUserSession();
		if(u == null) {
			return false;
		}else if(u.getTipo().equals(AMMINISTRATORE)) {
			return true;
		}else
			return false;
	}
	
	public boolean isUserExpert() {
		User u = this.getUserSession();
		if(u == null) {
			return false;
		}else if(u.getTipo().equals(ESPERTO)) {
			return true;
		}else
			return false;
	}

	@Override
	public boolean isLogged() {
		User u = this.getUserSession();
		if(u == null) {
			return false;
		}else {
			return true;
		}
	}
	
	public boolean checkPassword(User u, UserDTO uDTO) {
		
		return (u.getEmail().equals(uDTO.getEmail()) && u.getPassword().equals(uDTO.getPassword()));
		
	}
}
