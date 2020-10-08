<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Eventi</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">

<link rel="stylesheet" href="/css/generic.css">

</head>
<body>
	<nav id="navBar" class="navbar navbar-expand-md navbar-dark bg-dark fixed-top"><!--fixed-top-->
          <a class="navbar-brand" href="/">Eventi</a>
          <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>

          <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
              <li class="nav-item">
                <a class="nav-link" href="/">Home</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="/#calendario">Calendario</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" id="pannelloDiControllo" href="/login/pannelloDiControllo">Pannello di controllo</a>
              </li><!-- 
              <li class="nav-item">
                <a class="nav-link" href="registrati.html">Registrati</a>
              </li> -->
            </ul>
            <a href="/login" id="link-btn-login-out">
              <button id="btn-login-out" class="btn btn-outline-success my-2 my-sm-0" type="submit">Login</button>
            </a>
          </div>
        </nav>
        <div style="display:block;height:3.5rem;"></div>
        <!-- Div vuoto che serve per coprire lo spazio della nav-bar (posizionata fixed quindi fuori dal flusso della pagina) -->
	<div class="container">