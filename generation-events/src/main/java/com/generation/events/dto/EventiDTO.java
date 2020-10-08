package com.generation.events.dto;

import java.io.IOException;
import java.sql.Time;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;
import com.generation.events.entities.Eventi;
import com.generation.events.services.StorageService;

public class EventiDTO {
	//DTO => DataTransferObject
	
	//@Autowired
	private StorageService storage;
	
	private static final String PATH_PREFIX="src/main/resources/static/";
	private static final String PREFIX_RELATIVE_SERVER = "events/";
	
	//private int eventoId;
	private int eventoId;
	private String titolo;
	private String descrizione;
	private String citta;	
	private String luogo;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataInizio;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataFine;
	private int ora;
	private int minuti;
	private MultipartFile immagine;
	private String paginaWeb; 
	private MultipartFile locandina;
	private String pathImg;
	private String pathPdf;
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
	public void setDataFine(LocalDate dataFine) {
		this.dataFine = dataFine;
	}
	public String getPaginaWeb() {
		return paginaWeb;
	}
	public void setPaginaWeb(String paginaWeb) {
		this.paginaWeb = paginaWeb;
	}
	public static String getPathprefix() {
		return PATH_PREFIX;
	}
	public MultipartFile getImmagine() {
		return immagine;
	}
	public String getPathImg() {
		return pathImg;
	}
	public String getPathPdf() {
		return pathPdf;
	}
	public void setImmagine(MultipartFile immagine) {
		this.immagine = immagine;
		if (this.immagine != null) {
			this.writeImg();
		}
	}
	public MultipartFile getLocandina() {
		return locandina;
	}
	public void setLocandina(MultipartFile locandina) {
		this.locandina = locandina;
		if (this.locandina != null) {
			this.writePdf();
		}
	}
	public int getOra() {
		return ora;
	}
	public void setOra(int ora) {
		this.ora = ora;
	}
	public int getMinuti() {
		return minuti;
	}
	public void setMinuti(int minuti) {
		this.minuti = minuti;
	}
	
	public void setPathImg(String pathImg) {
		this.pathImg = pathImg;
	}
	public void setPathPdf(String pathPdf) {
		this.pathPdf = pathPdf;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "EventiDTO [eventoId=" + eventoId + ", titolo=" + titolo + ", descrizione=" + descrizione + ", citta="
				+ citta + ", luogo=" + luogo + ", dataInizio=" + dataInizio + ", dataFine=" + dataFine + ", ora=" + ora
				+ ", minuti=" + minuti + ", paginaWeb=" + paginaWeb + ", pathImg=" + pathImg + ", pathPdf=" + pathPdf
				+ ", userID=" + userId + "]";
	}
	
	private void writeImg() {
		StorageService stSv = new StorageService();
		String extensionFile = stSv.getExtensionFile(immagine);
		if(extensionFile.equals("jpeg")) {
			this.pathImg = PREFIX_RELATIVE_SERVER + this.titolo + "." + extensionFile;
			this.writeFile(this.pathImg, this.immagine);
		}else {
			this.pathImg = "-1";
		}
	}
	
	private void writePdf() {
		StorageService stSv = new StorageService();
		String extensionFile = stSv.getExtensionFile(locandina);
		if(extensionFile.equals("pdf")) {
			this.pathPdf = PREFIX_RELATIVE_SERVER + this.titolo + "." + extensionFile;
			this.writeFile(this.pathPdf, this.locandina);
		}else {
			this.pathPdf = "-1";
		}
	}
	
	public void writeFile(String pathRelative, MultipartFile file) {
		try {
			storage = new StorageService();
			storage.write((PATH_PREFIX + pathRelative), file);
		} catch (IOException e) {
			System.out.println(e);
		}
	}
	
	public Eventi makeObjEventi() {
		Eventi e = new Eventi();
		e.setEventoId(this.eventoId);
		e.setTitolo(this.titolo);
		e.setDescrizione(this.descrizione);
		e.setCitta(this.citta);
		e.setLuogo(this.luogo);
		e.setDataInizio(this.dataInizio);
		e.setDataFine(this.dataFine);
		e.setImmagine(this.pathImg);
		e.setPaginaWeb(this.paginaWeb);
		e.setLocandina(this.pathPdf);
		e.setOra(Time.valueOf(this.ora + ":" + this.minuti + ":00"));
		e.setUserId(this.userId);
		return e;
	}
	
	@SuppressWarnings("deprecation")
	public static EventiDTO makeObjEventiDTO(Eventi e) {
		EventiDTO eDTO = new EventiDTO();
		eDTO.setEventoId(e.getEventoId());
		eDTO.setTitolo(e.getTitolo());
		eDTO.setDescrizione(e.getDescrizione());
		eDTO.setCitta(e.getCitta());
		eDTO.setLuogo(e.getLuogo());
		eDTO.setDataInizio(e.getDataInizio());
		eDTO.setDataFine(e.getDataFine());
		eDTO.setPathImg(e.getImmagine());
		eDTO.setPaginaWeb(e.getPaginaWeb());
		eDTO.setPathPdf(e.getLocandina());
		eDTO.setOra(e.getOra().getHours());
		eDTO.setOra(e.getOra().getMinutes());
		eDTO.setUserId(e.getUserId());
		return eDTO;
	}




}
