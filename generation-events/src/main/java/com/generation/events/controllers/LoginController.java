package com.generation.events.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.generation.events.dto.UserDTO;
import com.generation.events.entities.User;
import com.generation.events.model.IUser;
import com.generation.events.services.ILoginService;
import com.generation.events.services.IUserService;

@Controller()
@RequestMapping("/login")
public class LoginController implements IUser {

	@Autowired
	private ILoginService loginService;
	
	@Autowired
	private IUserService userService;
	
	@RequestMapping("")
	public String login() {
		return "redirect:/login/pannelloDiControllo";
	}
	
	@RequestMapping("/pannelloDiControllo")
	public String checkUser() {
		if(loginService.isLogged()) {
			if(loginService.isUserAmmistrator() || loginService.isUserExpert()) {
				return "pannelloDiControllo";
			}else {
				return "errore";
			}
		}else {
			return "login";
		}
	}
	
	@PostMapping("/check")	
	//public String login(@RequestParam("email") String email, @RequestParam("password") String password) {
	public String login(@ModelAttribute UserDTO uDTO) {
		User u = userService.findByEmail(uDTO.getEmail().toLowerCase());
		if(u!=null && loginService.checkPassword(u, uDTO)){
			loginService.saveSessionUser(u);
			return "redirect:/login/pannelloDiControllo";
		}else 
			return "loginErrato";
	}
	
	@GetMapping("/logout")
	public String logout() {
		loginService.removeUserSession();
		return "redirect:/";
	}
}
