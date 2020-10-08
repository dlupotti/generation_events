package com.generation.events.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.generation.events.entities.Eventi;

public interface IEventiRepository extends JpaRepository<Eventi, Integer> {
	
	public List<Eventi> findByUserId(int userId);
	
	@Query(value="SELECT * FROM eventi ORDER BY RAND() LIMIT 1", nativeQuery = true)
	public Eventi getRandomEvent();

}
