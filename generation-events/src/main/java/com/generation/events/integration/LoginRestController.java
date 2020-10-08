package com.generation.events.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.events.dto.UserDTO;
import com.generation.events.services.ILoginService;

@RestController
@RequestMapping("/api/login")
public class LoginRestController {
	
	@Autowired
	private ILoginService loginService;
		
	@GetMapping("/getLogged")
	public UserDTO getLogged(){
		UserDTO uDTO = new UserDTO();
		if(loginService.isLogged()) {
			uDTO = new UserDTO();
			uDTO.setValues(loginService.getUserSession());
			return uDTO;
		}else {
			uDTO.setNome("none");
			uDTO.setCognome("none");
			uDTO.setUserId(-1);
			return uDTO;
		}
	}
}
