<ul class="nav nav-tabs" id="calendario" role="tablist">
  <li class="nav-item" role="presentation">
    <a class="nav-link " id="home-tab" data-toggle="tab" href="#eventiScaduti" role="tab" aria-controls="home" aria-selected="true">Eventi scaduti</a>
  </li>
  <li class="nav-item" role="presentation">
    <a class="nav-link active" id="profile-tab" data-toggle="tab" href="#eventiDisponibili" role="tab" aria-controls="profile" aria-selected="false">Eventi disponibili</a>
  </li>
</ul>
<div class="tab-content" id="calendarioContent">
    <div class="tab-pane fade " id="eventiScaduti" role="tabpanel" aria-labelledby="home-tab">
        <div class="row justify-content-center" id="eventiScadutiCard">
            <!-- JS -->
        </div>
        <div class="row justify-content-around">
	        <button type="button" id="scadutiPrecedenti" class="btn btn-outline-secondary">Precedente</button>
	        <button type="button" id="scadutiSuccessivi" class="btn btn-outline-primary">Successivo</button>
    	</div>
    </div>
    <div class="tab-pane fade show active" id="eventiDisponibili" role="tabpanel" aria-labelledby="profile-tab">
        <div class="row justify-content-center" id="eventiDisponibiliCard">
        	<!-- JS -->
        </div>
        <div class="row justify-content-around">
	        <button type="button" id="disponibiliPrecedenti" class="btn btn-outline-secondary">Precedente</button>
	        <button type="button" id="disponibiliSuccessivi" class="btn btn-outline-primary">Successivo</button>
    	</div>
    </div>
</div>

