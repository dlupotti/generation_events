package com.generation.events.services;


import java.time.LocalDate;
import java.util.List;

import com.generation.events.dto.EventiDTO;
import com.generation.events.entities.Eventi;


public interface IEventiService {
	String FIND_ALL= "select * from eventi";
	String FIND_ONE= "select * from eventi where id=?";

	List<Eventi> findaAll();
	Eventi findOne(int id);
	void uploadEvent(Eventi e);
	void deleteEvento(Eventi e);
	
	List<Eventi> findActiveEvents(LocalDate date);
	List<Eventi> findExpiredEvents(LocalDate date);
	
	List<Eventi> findByUserId(int userId);
	
	void update(Eventi original, EventiDTO newEventi);
	Eventi getRandomEvent();
}



