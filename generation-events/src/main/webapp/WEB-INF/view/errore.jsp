<%@ include file="header.jsp"%>
<link rel="stylesheet" href="/css/errorPage.css">

<div class="row justify-content-center">
	<div class="col-md-7 col-lg-6">
		<div id="errorMsg" class="alert alert-secondary align-middle" role="alert">
			<div class="spinner-grow" style="width: 1rem; height: 1rem; float:left;position:relative; top:0.5rem;" role="status">
			  <span class="sr-only">Loading...</span>
			</div>
			<h4 class="alert-heading">Attenzione!</h4>
			<p>Utente Base.<br> 
			Con l'utente base potrai solo visualizzare gli eventi.<br/>
			Non è permesso accedere al pannello di controllo.</p>
			<hr>
			<p class="mb-0">
				<a href="/"><button type="button" class="btn btn-outline-primary">Home Page</button></a>
				<a href="/login/logout"><button type="button" class="btn btn-outline-danger">Logout</button></a>
			</p>
		</div>
	</div>
</div>

<%@ include file="libJs.jsp"%>

<%@ include file="footer.jsp"%>