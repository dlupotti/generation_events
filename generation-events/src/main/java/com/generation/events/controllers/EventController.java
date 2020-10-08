package com.generation.events.controllers;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.generation.events.dto.EventiDTO;
import com.generation.events.entities.Eventi;
import com.generation.events.services.IEventiService;
import com.generation.events.services.ILoginService;

@Controller
@RequestMapping("/event")
public class EventController {
	
	@Autowired
	private IEventiService service;
	
	@Autowired
	private ILoginService loginService;
	
	@GetMapping("/addEvent")
	public String addEvent() {
		if(loginService.isUserAmmistrator() || loginService.isUserExpert()){
			return "inserisci";
		}else {
			return "redirect:/login/pannelloDiControllo";
		}
	}
	
	@PostMapping("/addEvent")
	public String addEvent(@ModelAttribute EventiDTO eventDTO) {
		Eventi eventRepo = eventDTO.makeObjEventi();
		System.out.println(eventRepo.toString());
		service.uploadEvent(eventRepo);
		
		return "redirect:/login/pannelloDiControllo";
	}
	
	@GetMapping("/modifyEvents")
	public String modifyEvent() {
		if(loginService.isUserAmmistrator() || loginService.isUserExpert()){
			return "modifyEvents";
		}else {
			return "redirect:/login/pannelloDiControllo";
		}
	}

	@GetMapping("/updateEvent/{eventId}")
	public String requiredModifyEvent(@PathVariable("eventId") int eventId, ModelMap map) {
		if(loginService.isUserAmmistrator() || loginService.isUserExpert()){
			Eventi evento = service.findOne(eventId);
			map.addAttribute("evento", evento);
			return "updateEvent";
		}else {
			return "redirect:/login/pannelloDiControllo";
		}
	}
	
	@PostMapping("/updateEvent")
	public String updateEvent(@ModelAttribute EventiDTO eventDTO) {
		//Eventi newEventi = eventDTO.makeObjEventi();
		eventDTO.setUserId(loginService.getUserSession().getUserId()); //viene anche impostato nel form(si può rimuovere)
		Eventi original = service.findOne(eventDTO.getEventoId());
		service.update(original, eventDTO);
		
		try {
			TimeUnit.SECONDS.sleep(1); //attesa per permettere la scrittura del file, prima che venga ricaricata la pagina
		} catch (InterruptedException e) {
			System.out.println(e);
		}
		
		return "redirect:/event/modifyEvents";
	}
	
	//delete è nelle api
	
	@GetMapping("/{eventId}")
	public String findOne(@PathVariable("eventId") int eventoId , ModelMap map) {
		Eventi evento = service.findOne(eventoId);
		map.addAttribute("evento", evento);
		
		return "dettaglio";
	}
	
	@RequestMapping("/")
	public String home() {
		return "index";
	}
	
}
