$.get("/api/events/activeEvents",function(data){
   var carousel = document.getElementById("carousel")
	var msg="";
   for(let i=0; i<data.length; i++){
       //var date = data[i].dataInizio.substring(0, data[i].dataInizio.indexOf("T"));
		//console.log(data[i].dataInizio);
       
       if(i==0){
           msg += '<div class="carousel-item active" data-interval="4000">';
       }else{
           msg += '<div class="carousel-item"  data-interval="4000">'
       }
       msg += '<img id="img-carousel" src="/' + data[i].immagine + '" class="d-block w-100" alt=""> <div class="carousel-caption d-none d-md-block "><h5>' + data[i].titolo + '</h5><p class="align-text-top">Citta: ' + data[i].citta + ', Data: ' + data[i].dataInizio + ', Ora: ' + data[i].ora.substring(0,5) +'</p></div> </div>';
   }
   carousel.innerHTML += msg;
});