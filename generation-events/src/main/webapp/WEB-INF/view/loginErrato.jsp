<%@ include file="header.jsp"%>
<link rel="stylesheet" href="/css/errorPage.css">
<div class="row justify-content-center">
	<div class="col-md-7 col-lg-6">
		<div id="errorMsg" class="alert alert-danger align-middle" role="alert">
			<h4 class="alert-heading">Dati non corretti.</h4>
			<p>Accesso negato.<br>sembra che i dati inseriti non siano corretti.<br/>prova a reinserirli.<p> 
			<hr>
			<p class="mb-0"><a href="/login"><button type="button" class="btn btn-outline-primary">Login</button></a></p>
		</div>
	</div>
</div>

<%@ include file="libJs.jsp"%>

<%@ include file="footer.jsp"%>