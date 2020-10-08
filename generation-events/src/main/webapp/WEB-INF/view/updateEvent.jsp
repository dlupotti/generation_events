<%@ include file="header.jsp"%>
<link rel="stylesheet" href="/css/inserisci.css">
<div class="row mt-4">
	<div class="col-md-10">
		<h2>Modulo per la modifica dell'evento:</h2>
		<h4>${evento.titolo}</h4>
	</div>
</div>
<form method="POST" action="/event/updateEvent" enctype="multipart/form-data" name="event">
       <div class="form-group">
           <div class="row mt-4">
               <div class="col-md-10">
                   <div class="input-group">
                     <div class="input-group-prepend">
                       <span class="input-group-text" id="inputGroup-sizing-default">Titolo</span>
                     </div>
                     <input type="text" name="titolo" id="titolo" required value="${evento.titolo}" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default">
                   </div>
               </div>
           </div>

           <div class="row mt-4">
               <div class="col-md-10">
                   <div class="input-group">
                     <div class="input-group-prepend">
                       <span class="input-group-text" id="inputGroup-sizing-default">Città</span>
                     </div>
                     <input type="text" name="citta" id="citta" required value="${evento.citta}" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default">
                   </div>
               </div>
           </div>

           <div class="row mt-4">
               <div class="col-md-10">
                   <div class="input-group">
                     <div class="input-group-prepend">
                       <span class="input-group-text" id="inputGroup-sizing-default">Indirizzo</span>
                     </div>
                     <input type="text" name="luogo" id="luogo" required value="${evento.luogo}" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default">
                   </div>
               </div>
           </div>


           <div class="row mt-4">
               <div class="col-md-10 col-lg-5">
                   <div class="input-group">
                     <div class="input-group-prepend">
                       <span class="input-group-text" id="inputGroup-sizing-default" style="min-width:6.5rem">Data inizio</span>
                  </div>
                  <input type="date" name="dataInizio" id="dataInizio" required value="${evento.dataInizio}" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default">
                </div>
            </div>
            <div class="col-md-10 col-lg-5">
                <div class="input-group">
                  <div class="input-group-prepend">
                    <span class="input-group-text" id="inputGroup-sizing-default" style="min-width:6.5rem">Data fine</span>
                  </div>
                  <input type="date" name="dataFine" id="dataFine" required value="${evento.dataFine}" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default">
                </div>
            </div>
        </div>
        
        <div class="row mt-4">
         <div class="col-sm-2">
         	<div class="input-group">
	  <div class="input-group-prepend">
	    <label class="input-group-text" for="ora">Ora</label>
	  </div>
	  <select name="ora" class="custom-select" id="ora">
	    <option selected value="-1">Choose...</option>
	    <option value="0">0</option><option value="1">1</option><option value="2">2</option><option value="3">3</option><option value="4">4</option><option value="5">5</option><option value="6">6</option><option value="7">7</option><option value="8">8</option><option value="9">9</option><option value="10">10</option><option value="11">11</option><option value="12">12</option><option value="13">13</option><option value="14">14</option><option value="15">15</option><option value="16">16</option><option value="17">17</option><option value="18">18</option><option value="19">19</option><option value="20">20</option><option value="21">21</option><option value="22">22</option><option value="23">23</option>
	  </select>
	</div>
         </div>
         <div class="col-sm-2">
         	<div class="input-group">
	  <div class="input-group-prepend">
	    <label class="input-group-text" for="minuti">Minuti</label>
	  </div>
	  <select name="minuti" class="custom-select" id="minuti">
	    <option selected value="-1">Choose...</option>
	    <option value="0">0</option><option value="15">15</option><option value="30">30</option><option value="45">45</option>
	  </select>
	</div>
         </div>
        </div>

        <div class="row mt-4">
            <div class="col-md-10">
                <div class="input-group">
                  <div class="input-group-prepend">
                    <span class="input-group-text">Descrizione</span>
                  </div>
                  <textarea name="descrizione" id="descrizione" required class="form-control" aria-label="With textarea">${evento.descrizione}</textarea>
                </div>
            </div>
        </div>
		
		<div class="row mt-4">
			<div class="col-md-10 col-lg-5">
	        	<p>Se non vengono inseriti i file non verranno aggiornati</p>
	        </div>
	    </div>
        <div class="row mt-4">
            <div class="col-md-10 col-lg-5">
                <div class="input-group">
                  <div class="input-group-prepend">
                    <span class="input-group-text" id="inputGroupFileAddon01">Upload IMG</span>
                  </div>
                  <div class="custom-file">
                    <input type="file" name="immagine" id="immagine" class="custom-file-input" id="inputGroupFile01" aria-describedby="inputGroupFileAddon01" accept="image/x-png,image/jpeg">
                    <label class="custom-file-label" for="inputGroupFile01">Choose file (.jpg or .png)</label>
                  </div>
                </div>
            </div>
            <div class="col-md-10 col-lg-5">
                <div class="input-group">
                  <div class="input-group-prepend">
                    <span class="input-group-text" id="inputGroupFileAddon01">Upload PDF</span>
                  </div>
                  <div class="custom-file">
                    <input type="file" name="locandina" id="locandina" class="custom-file-input" id="inputGroupFile01" aria-describedby="inputGroupFileAddon01" accept="application/pdf">
                    <label class="custom-file-label" for="inputGroupFile01">Choose file (.pdf)</label>
                  </div>
                </div>
            </div>
        </div>


        <div class="row mt-4">
            <div class="col-md-10 col-lg-5">
                <label for="paginaWeb">Event Url</label>
                <div class="input-group mb-3">
                  <div class="input-group-prepend">
                    <span class="input-group-text" id="basic-addon3">https://example.com</span>
                  </div>
                  <input type="url" name="paginaWeb" id="paginaWeb" required value="${evento.paginaWeb}" class="form-control" id="basic-url" aria-describedby="basic-addon3">
                </div>
            </div>
        </div>
    </div>
    <input type="text" name="eventoId" id="eventoId" value="${evento.eventoId}" style="display:none">
    <input type="text" name="userId" id="userId" value="" style="display:none"><!-- Scritto tramite JS -->
  <button type="submit" id="submit" class="btn btn-outline-primary btn-lg">Submit</button>
</form>


<%@ include file="libJs.jsp"%>

<script src="/scriptJS/formEvent.js"></script>

<%@ include file="footer.jsp"%>