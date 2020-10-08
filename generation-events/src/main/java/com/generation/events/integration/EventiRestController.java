package com.generation.events.integration;

import java.time.Clock;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.events.entities.Eventi;
import com.generation.events.entities.User;
import com.generation.events.model.UserType;
import com.generation.events.services.EventiService;
import com.generation.events.services.IEventiService;
import com.generation.events.services.IUserService;
import com.generation.events.services.UserService;

@RestController
@RequestMapping("/api/events")
public class EventiRestController {
	
	private Clock cl=Clock.systemUTC();
	
	@Autowired
	private IEventiService eventiService;
	
	@Autowired
	private IUserService userService;
	
	@GetMapping("/allEvents")
	public List<Eventi> getAllEvent(){
		return eventiService.findaAll();
	}
	
	@GetMapping("/activeEvents")
	public List<Eventi> getActiveEvent(){
		return eventiService.findActiveEvents(LocalDate.now(cl));
	}
	
	@GetMapping("/expiredEvents")
	public List<Eventi> getExpiredEvent(){
		return eventiService.findExpiredEvents(LocalDate.now(cl));
	}
	
	@GetMapping("/user/{userId}")
	public List<Eventi> findEventByUserId(@PathVariable("userId")int userId) {
		User u  = userService.findOne(userId);
		if(u.getTipo().equals(UserType.AMMINISTRATORE.getLetterType())) {
			return eventiService.findaAll();
		}else {
			return eventiService.findByUserId(userId);
		}
	}
	
	@GetMapping("/randomImgEvent")
	public Eventi randomImgEvent() {
		return eventiService.getRandomEvent();
	}
	
	//@DeleteMapping("/delete/{eventoId}")
	@GetMapping("/delete/{eventoId}")
	public void deleteEventById(@PathVariable("eventoId") int eventoId) {
		
		eventiService.deleteEvento(eventiService.findOne(eventoId));
		
		/*
		 * Il ricarico della pagina se ne occupa JS. (modifyEvents)
		 */
	}

}
