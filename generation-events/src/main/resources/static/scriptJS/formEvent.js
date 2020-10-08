document.forms.event.addEventListener("submit",function(){
    var dataInizio = new Date(document.getElementById("dataInizio").value);
    var dataFine = new Date(document.getElementById("dataFine").value);
    var time = dataFine.getTime() - dataInizio.getTime();
    if (time<0){
        alert("La data di inizio deve esse superiore alla data di fine evento")
        event.preventDefault()
        return;
    }
    var ora = document.getElementById("ora").value;
    var minuti = document.getElementById("minuti").value;
    if (ora == "-1" || minuti == "-1"){
    	alert("E' obbligatorio impostare ora e minuti di inizio, dell'evento.'");
        event.preventDefault()
        return;
    }
});

$(function(){
	document.getElementById("userId").value=sessionStorage.getItem("userId");
});