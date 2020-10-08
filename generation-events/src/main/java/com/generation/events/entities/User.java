package com.generation.events.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="archivioutenti")
public class User {
	
	@Column(name="ultima_modifica")
	private Date ultimaModifica;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	private int userId;
	private String password;
	private String firma;
	private String tipo;
	private String nome;
	private String cognome;
	private String nascita;
	private String email;
	
	@Column(name="data_iscrizione")
	private Date dataIscrizione;

	public Date getUltimaModifica() {
		return ultimaModifica;
	}

	public void setUltimaModifica(Date ultimaModifica) {
		this.ultimaModifica = ultimaModifica;
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

	public String getFirma() {
		return firma;
	}

	public void setFirma(String firma) {
		this.firma = firma;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cogonme) {
		this.cognome = cogonme;
	}

	public String getNascita() {
		return nascita;
	}

	public void setNascita(String nascita) {
		this.nascita = nascita;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDataIscrizione() {
		return dataIscrizione;
	}

	public void setDataIscrizione(Date dataIscrizione) {
		this.dataIscrizione = dataIscrizione;
	}

	@Override
	public String toString() {
		return "User [ultimaModifica=" + ultimaModifica + ", userID=" + userId + ", password=" + password + ", firma="
				+ firma + ", tipo=" + tipo + ", nome=" + nome + ", cogonme=" + cognome + ", nascita=" + nascita
				+ ", email=" + email + ", dataIscrizione=" + dataIscrizione + "]";
	}

}
