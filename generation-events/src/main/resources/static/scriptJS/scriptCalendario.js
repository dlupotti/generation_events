        var divScaduti = document.getElementById("eventiScadutiCard");
        var jsonScaduti;
        var printedScaduti = 0;
        
        var divDisponibili = document.getElementById("eventiDisponibiliCard");
        var jsonDisponibili;
        var printedDisponibili = 0;
        
          
        $.get("api/events/expiredEvents",function(data){
            jsonScaduti = data;
            printedScaduti = calcNEnd(jsonScaduti, printedScaduti);
            makeCard(divScaduti, jsonScaduti, 0, printedScaduti);
        });
          
        $.get("/api/events/activeEvents",function(data){
            jsonDisponibili = data;
            printedDisponibili = calcNEnd(jsonDisponibili, printedDisponibili);
            makeCard(divDisponibili, jsonDisponibili, 0, printedDisponibili);
        });
          
          function makeCard(element, data, nFrom, nEnd){
			  
              element.innerHTML = "";
              for(let i=nFrom; i<nEnd; i++){
			      var descrizione = data[i].descrizione.substring(0, 100) + "...";
                  element.innerHTML += '<div class=" col-md-6 col-lg-4"><div class="card"><img src="/' +
                      data[i].immagine + '" class="card-img-top" alt="' + data[i].titolo + '"><div class="card-body"><h5 class="card-title">' + data[i].titolo + '</h5><p class="card-text">' + descrizione + '</div><ul class="list-group list-group-flush"><li class="list-group-item">Città:' + data[i].citta + '</li><li class="list-group-item">Data inizio: ' + data[i].dataInizio + ', Ora: ' + data[i].ora.substring(0,5) + '</li><li class="list-group-item">Data fine: ' + data[i].dataFine + '</li></ul><div class="card-body"><a href="/event/' + data[i].eventoId + '"><button type="submit" id="submit" class="btn btn-primary">Vai all\'evento </button></a></div></div></div>';
                  }
          }
        
        function calcNEnd(data, nFrom){
            if((data.length-nFrom)<10){
                return (data.length);
            }else{
                return (nFrom+10);
            }
        }
        //usato solo se si torna indietro nelle card
        function goBackNFrom(nFrom){
            if((nFrom - 10)<0){
                return 0;
            }else{
				return nFrom-10;
            }
        }
    
        
        $("#scadutiSuccessivi").click(function(){
            if(printedScaduti == jsonScaduti.length){
                eventiFiniti(divScaduti);
            }else{
                var nEnd = calcNEnd(jsonScaduti, printedScaduti);
                makeCard(divScaduti, jsonScaduti, printedScaduti, nEnd);
                printedScaduti = nEnd;
            }
        });
        $("#scadutiPrecedenti").click(function(){
            printedScaduti = goBackNFrom(printedScaduti);
            var nEnd = calcNEnd(jsonScaduti, printedScaduti);
            makeCard(divScaduti, jsonScaduti, printedScaduti, nEnd);
        });
        
        $("#disponibiliSuccessivi").click(function(){
            if(printedDisponibili == jsonDisponibili.length){
                eventiFiniti(divDisponibili);
            }else{
                var nEnd = calcNEnd(jsonDisponibili, printedDisponibili);
                makeCard(divDisponibili, jsonDisponibili, printedDisponibili, nEnd);
                printedDisponibili = nEnd;
            }
        });
        $("#disponibiliPrecedenti").click(function(){
            printedDisponibili = goBackNFrom(printedDisponibili);
            var nEnd = calcNEnd(jsonDisponibili, printedDisponibili);
            makeCard(divDisponibili, jsonDisponibili, printedDisponibili, nEnd);
        });
        
        
        
        function eventiFiniti(element){
            var msg = '<div class="alert alert-success mt-5 mb-5" role="alert"><h4 class="alert-heading">Ops :(</h4><p>Sembra che per il momento non ci siano altri eventi da mostrare.<br/>Torna più tardi!</p><hr><p class="mb-0">Siamo sempre a lavoro per scovare nuovi eventi.</p></div>';
            element.innerHTML = msg;
        }