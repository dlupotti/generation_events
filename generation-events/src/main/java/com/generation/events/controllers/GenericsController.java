package com.generation.events.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GenericsController {
	
	@RequestMapping("/")
	public String home() {
		return "index";
	}
}
