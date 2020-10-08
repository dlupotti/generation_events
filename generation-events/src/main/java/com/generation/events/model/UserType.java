package com.generation.events.model;

public enum UserType {
	AMMINISTRATORE("A"), ESPERTO("E"), BASE("B");
	
	String letterType;

	
	private UserType(String letterType) {
		this.letterType = letterType;
		
	}
	
	public String getLetterType() {
		return this.letterType;
	}
	
}
