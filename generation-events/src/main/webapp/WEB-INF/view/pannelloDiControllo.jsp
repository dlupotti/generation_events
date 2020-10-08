<%@ include file="header.jsp"%>
<link rel="stylesheet" href="/css/pannelloDiControllo.css">
<div class="row justify-content-center">
	<div class="col-md-7 col-lg-5">
		<div class="card text-center" id="pannello">
		  <div class="card-header">
		    <ul class="nav nav-pills card-header-pills">
		      <li class="nav-item">
		        <a class="nav-link" href="/login/logout"><button type="button" id="logout" class="btn btn-outline-danger">Logout</button></a>
		      </li> 
		    </ul>
		  </div>
		 	<div class="card-body">
		    	<h5 class="card-title">Pagina gestione eventi</h5>
		    	<p class="card-text">Clicca sui link in basso se vuoi inserire un nuovo evento o se vuoi modificarne uno esistente.</p>
		    	<a href="/event/addEvent"><button type="button" class="btn btn-outline-primary btn-lg btn-block">Inserisci un nuovo evento</button></a>
				<a href="/event/modifyEvents"><button type="button" class="btn btn-outline-secondary btn-lg btn-block">Modifica un evento esistente</button></a>	  
			</div>
		</div>
	</div>
</div>
<%@ include file="libJs.jsp"%>
<script src="/scriptJS/randomBackground.js"></script>
<%@ include file="footer.jsp"%>