<%@ include file="header.jsp"%>
<link rel="stylesheet" href="/css/login.css">
	<div class="row justify-content-center">
		<h3 class="display-4 mt-3">Login page</h3>
	</div>
	<div class="row justify-content-center" style="position:relative; top:4rem;">
	    <div class="col-md-6 col-lg-5">
	    <form name="login" method="POST" action="/login/check">
	        <div class="form-group">
	            <label for="email">Email</label>
	            <input type="email" class="form-control" id="email" name="email" required aria-describedby="usernameHelp" placeholder="Inserisci l'email">
	        </div>
	        <div class="form-group">
	            <label for="password">Password</label>
	            <input type="password" class="form-control" id="password" name="password" required placeholder="Inserisci la password">
	        </div>
	        <button type="submit" class="btn btn-primary">Login</button>
	    </form>
	    </div>
	</div>

<%@ include file="libJs.jsp"%>
<script src="/scriptJS/randomBackground.js"></script>
<%@ include file="footer.jsp"%>