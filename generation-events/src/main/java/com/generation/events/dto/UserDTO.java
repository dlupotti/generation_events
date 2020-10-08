package com.generation.events.dto;

import com.generation.events.entities.User;

public class UserDTO {
	//Oggetto passato al client per salvarlo sul sessionStorage
	private String nome;
	private String cognome;
	private String email;
	private String password;
	private int userId;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String name) {
		this.nome = name;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setValues(User u) {
		this.setNome(u.getNome());
		this.setCognome(u.getCognome());
		this.setNome(u.getNome());
		this.setUserId(u.getUserId());
		this.setPassword(u.getPassword());
		this.setEmail(u.getEmail());
	}




}
