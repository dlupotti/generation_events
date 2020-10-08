$.get("/api/login/getLogged",function(data){
   sessionStorage.setItem('nome', data.nome);
   sessionStorage.setItem('cognome', data.cognome);
   sessionStorage.setItem('userId', data.userId);
	
	if(data.userId != "-1"){ //cambio bottone nav-bar (login to logout)
		$("#btn-login-out").removeClass("btn-outline-success");
		$("#btn-login-out").addClass("btn-outline-danger");
		$("#btn-login-out").text("Logout");
		$("#link-btn-login-out").attr("href","/login/logout");
	}
});