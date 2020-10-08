var api = "/api/events/user/" + sessionStorage.getItem("userId");
$(function(){
	$.get(api,function(data){
		element = document.getElementById("events");
	
		for(let i=0; i<data.length; i++){
		      var descrizione = data[i].descrizione.substring(0, 100) + "...";
	          element.innerHTML += '<div class=" col-md-6 col-lg-4"><div class="card"><img src="/' +
	              data[i].immagine + '" class="card-img-top" alt="' + data[i].titolo + '"><div class="card-body"><h5 class="card-title">' + data[i].titolo + '</h5><p class="card-text">' + descrizione + '</div><ul class="list-group list-group-flush"><li class="list-group-item">Città:' + data[i].citta + '</li><li class="list-group-item">Data inizio: ' + data[i].dataInizio + ', Ora: ' + data[i].ora.substring(0,5) + '</li><li class="list-group-item">Data fine: ' + data[i].dataFine + '</li></ul><div class="card-body"><a href="/event/updateEvent/' + data[i].eventoId + '"><button type="submit" id="modifica" class="btn btn-primary mr-3">Modifica </button></a><button type="submit" linkDelete="/api/events/delete/' + data[i].eventoId + '" class="btn btn-danger elimina">Elimina </button></div></div></div>';
	          }

		activeEventElimina();
	});
});

function activeEventElimina(){
		$(".elimina").on("click",function(){
			var linkDelete = $(this).attr("linkDelete");
			if(confirm("Sicuro di voler cancellare l'evento?'")){
				$.ajax({
				    url: linkDelete,
				    type: 'GET', //GET e non put perchè succes non funziona con DELETE
				    success: function(result) {
				         location.reload();
				    }
				});
			}
		});
}