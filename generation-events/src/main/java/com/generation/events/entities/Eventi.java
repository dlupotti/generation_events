package com.generation.events.entities;


import java.sql.Time;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "eventi")
public class Eventi {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="evento_id")
	private int eventoId;
	private String titolo;
	private String descrizione;
	private String citta;	
	private String luogo;
	@Column(name="data_inizio")
    private LocalDate dataInizio;
	private Time ora;
	@Column(name="data_fine")
    private LocalDate dataFine;
    private String immagine; //Path file
    private String paginaWeb; 
    private String locandina; //Path file
    @Column(name="user_id")
    private int userId;
    
	public int getEventoId() {
		return eventoId;
	}
	public void setEventoId(int eventoId) {
		this.eventoId = eventoId;
	}
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public String getCitta() {
		return citta;
	}
	public void setCitta(String citta) {
		this.citta = citta;
	}
	public String getLuogo() {
		return luogo;
	}
	public void setLuogo(String luogo) {
		this.luogo = luogo;
	}
	public LocalDate getDataInizio() {
		return dataInizio;
	}
	public void setDataInizio(LocalDate dataInizio) {
		this.dataInizio = dataInizio;
	}
	public LocalDate getDataFine() {
		return dataFine;
	}
	
	public Time getOra() {
		return ora;
	}
	
	public void setOra(Time ora) {
		this.ora=ora;
	}
	
	public void setDataFine(LocalDate dataFine) {
		this.dataFine = dataFine;
	}
	public String getImmagine() {
		return immagine;
	}
	public void setImmagine(String immagine) {
		this.immagine = immagine;
	}
	public String getPaginaWeb() {
		return paginaWeb;
	}
	public void setPaginaWeb(String paginaWeb) {
		this.paginaWeb = paginaWeb;
	}
	public String getLocandina() {
		return locandina;
	}
	public void setLocandina(String locandina) {
		this.locandina = locandina;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "Eventi [eventoId=" + eventoId + ", titolo=" + titolo + ", descrizione=" + descrizione + ", citta="
				+ citta + ", luogo=" + luogo + ", dataInizio=" + dataInizio + " ora: "+ ora+ ", dataFine=" + dataFine + ", immagine="
				+ immagine + ", paginaWeb=" + paginaWeb + ", locandina=" + locandina + ", userID=" + userId + "]";
	}
	
}