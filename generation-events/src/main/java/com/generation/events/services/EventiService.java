package com.generation.events.services;

import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.generation.events.dto.EventiDTO;
import com.generation.events.entities.Eventi;
import com.generation.events.repositories.IEventiRepository;

@Service
public class EventiService implements IEventiService {

	@Autowired
	private IEventiRepository repo;
	
	@Override
	public List<Eventi> findaAll(){
		return repo.findAll(Sort.by(Sort.Direction.DESC, "dataInizio"));
	}

	@Override
	public Eventi findOne(int id) {
		return repo.findById(id).get();
	}

	@Override
	public void uploadEvent(Eventi e) {
		repo.save(e);
	}

	@Override
	public List<Eventi> findActiveEvents(LocalDate date) {
		ArrayList<Eventi> events = (ArrayList<Eventi>) repo.findAll(Sort.by(Sort.Direction.DESC, "dataInizio"));
		
		List<Eventi> activeEvents = new ArrayList<>();
		
		for (Eventi e : events) {
			if(e.getDataFine().isAfter(date) || e.getDataFine().isEqual(date)) {
				
				activeEvents.add(e);
			}
		}
		return activeEvents;
	}

	@Override
	public List<Eventi> findExpiredEvents(LocalDate date) {
		ArrayList<Eventi> events = (ArrayList<Eventi>) repo.findAll(Sort.by(Sort.Direction.DESC, "dataInizio"));
		
		List<Eventi> expiredEvents = new ArrayList<>();
		
		for (Eventi e : events) {
			if(e.getDataFine().isBefore(date)) {
				expiredEvents.add(e);
			}
		}
		return expiredEvents;
	}

	public List<Eventi> findByUserId(int userId) {
		return repo.findByUserId(userId);
	}

	@Override
	public void deleteEvento(Eventi e) {
		repo.delete(e);
	}

	@Override
	public void update(Eventi original, EventiDTO newEventi) {
		
		StorageService storageService = new StorageService();
		
		//Se preso il riferimento dell'oggetto, modificato e poi fatto un save JPSRepository effettua un update
		//original.setEventoId(newEventi.getEventoId());
		//original.setUserId(newEventi.getUserId());
		original.setEventoId(newEventi.getEventoId());
		String oldTitle = original.getTitolo();
		original.setTitolo(newEventi.getTitolo());
		original.setDescrizione(newEventi.getDescrizione());
		original.setCitta(newEventi.getCitta());	
		original.setLuogo(newEventi.getLuogo());
		original.setDataInizio(newEventi.getDataInizio());
		original.setOra(Time.valueOf(newEventi.getOra()+ ":" + newEventi.getMinuti() + ":00"));
		original.setDataFine(newEventi.getDataFine());
		original.setPaginaWeb(original.getPaginaWeb()); 
		
		/*
		 * RENAME E DELITE FILE NON FUNZIONANO.
		 * Soluzione temporanea:
		 * Nel caso venga caricata una foto nuova quella vecchia non viene eliminata.
		 * Nel caso si cambia il titolo il file non viene rinominato (nel db viene lasciato il vecchio riferimento)
		 */
//		if(!newEventi.getTitolo().equals(oldTitle)) { //se il nuovo titolo è != da quello vecchio
//			
//			if(newEventi.getPathImg().equals("-1")) {// se == -1 non è stato inserito un nuovo file
//				//cambio il nome al file
//				String newPath = original.getImmagine().substring(0, original.getImmagine().lastIndexOf("/")+1);
//				newPath += newEventi.getTitolo() +  "." + storageService.getExtensionFile(new File(original.getImmagine()));
//				try {
//					storageService.renameFile(original.getImmagine(), newPath);
//					newEventi.setPathImg(newPath);
//				} catch (IOException e) {
//					//se va in errore non vado a modificare il file
//					newEventi.setPathImg(original.getImmagine());
//					System.out.println(e);
//				}
//			}
//			original.setImmagine(newEventi.getPathImg());
//			
//			if(newEventi.getPathPdf().equals("-1")) {// se == -1 non è stato inserito un nuovo file
//				//cambio il nome al file
//				String newPath = original.getLocandina().substring(0, original.getLocandina().lastIndexOf("/")+1);
//				newPath += newEventi.getTitolo() +  "." + storageService.getExtensionFile(new File(original.getLocandina()));
//				try {
//					storageService.renameFile(original.getLocandina(), newPath);
//					newEventi.setPathPdf(newPath);
//				} catch (IOException e) {
//					//se va in errore non vado a modificare il file
//					newEventi.setPathPdf(original.getLocandina());
//					System.out.println(e);
//				}
//			}
//			original.setLocandina(newEventi.getPathPdf());
//			
//		}else { //il titolo non è variato
//			if(!newEventi.getPathImg().equals("-1")) {// è stato inserito un nuovo file
//				//EventiDTO ha già salvato il nuovo file (cancello quello vecchio)
//				try {
//					storageService.deleteFile(original.getImmagine());
//				} catch (IOException e) {
//					System.out.println(e + "impossibile cancellare vecchio file");
//				}
//				original.setImmagine(newEventi.getPathImg());
//				
//			}else {
//				//è ancora valido il path salvato nell'oggetto Eventi original
//			}
//			if(!newEventi.getPathPdf().equals("-1")) {// è stato inserito un nuovo file
//				//EventiDTO ha già salvato il nuovo file
//				try {
//					storageService.deleteFile(original.getLocandina());
//				} catch (IOException e) {
//					System.out.println(e + "impossibile cancellare vecchio file");
//				}
//				original.setLocandina(newEventi.getPathPdf());
//			}else {
//				//è ancora valido il path salvato nell'oggetto Eventi original
//			}
//		}
	    
		
		/*
		 * a causa del problema scritto sopra non eseguiamo modificche a DB sull'immagine e pdf.
		 * A meno che non viene caricato un nuovo file.
		 */
		
		if(!newEventi.getPathImg().equals("-1")) {
			original.setImmagine(newEventi.getPathImg());
		}
		if(!newEventi.getPathPdf().equals("-1")) {
			original.setLocandina(newEventi.getPathPdf());
		}
		repo.save(original);
	}
	
	public Eventi getRandomEvent() {
		return repo.getRandomEvent();
	}

}
