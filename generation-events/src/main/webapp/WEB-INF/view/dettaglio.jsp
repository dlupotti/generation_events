<%@ include file="header.jsp"%>
<div class="main" style="width: 70%; margin:auto;">  
	
	<div class="jumbotron" >

		<div class="card" style="margin-top:-1.3rem;">
			  <img id="immagine" style="border-radius:1rem; position:relative; top:-0.5rem;" src="/${evento.immagine}" class="card-img-top">
			  <div class="card-body">
			  	<ul>
			  		<h1 class="display-4">${evento.titolo}</h1>
			  		<hr class="my-4">
         			<li>Città: ${evento.citta}</li>
         			<li>Luogo: ${evento.luogo}</li>
         			<li>Data inizio: ${evento.dataInizio}, Ora:${evento.ora}</li>
         			<li>Data fine: ${evento.dataFine}</li>
         			<li><a href="${evento.paginaWeb}">Link alla pagina dell'evento</a></li>
			   </ul>
			</div>
		</div>

		<div>
			<p class="lead">${evento.descrizione}</p>
		</div>
	   


	<p class="lead">
	  <a class="btn btn-primary btn-lg" href="/${evento.locandina}" role="button">Locandina</a>
	</p>
  </div>
</div>


<%@ include file="libJs.jsp"%>

<script type="text/javascript">
	var img= 'url("' + $("#immagine").attr("src") + '")';
	$("body").css("background-image", img).css("background-position:","center");
</script>

<%@ include file="footer.jsp"%>