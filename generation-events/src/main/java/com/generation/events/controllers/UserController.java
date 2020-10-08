package com.generation.events.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.generation.events.entities.User;
import com.generation.events.services.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private IUserService service;
	
	//@RequestMapping(value="/find/{email}", method = RequestMethod.GET)
	@RequestMapping("/find/{email}")
	@ResponseBody
	public User find(@PathVariable("email")String email) {
		
		return service.findByEmail(email);
	}
}
