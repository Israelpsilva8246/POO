<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>

<link rel="Stylesheet" href="bootstrap/css/bootstrap.min.css">
<link rel="Stylesheet" href="bootstrap/bootstrap-theme.min.css">

<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@700&display=swap" rel="stylesheet">

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<meta charset="ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" href="css/login.css">
</head>
<body id="fundo">

<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
  <div class="collapse navbar-collapse" id="navbarNavDropdown">
  <ul class="nav nav-pills">
  <li class="nav-item active">
  <a class="navbar-brand" href="">Bem-vindo(a)</a>
  
  </li>
  </ul>
  </div>
</nav>
	
	<div class="card" id="telaLogin">
  		<div class="card-body">
    		<form action="GerenciarLogin.do" method="POST">
			  <div class="row">
			  	<div class="form-group col-sm-12">
			  		<label for="login" class="control-label">Login</label>
			  		<input type="text" class="form-control" name="login" id="login" value="" placeholder="Login" required>
			  	</div>
			  </div>
			  <div class="row">
			  	<div class="form-group col-sm-12">
			  		<label for="senha" class="control-label">Senha</label>
			  		<input type="password" class="form-control" name="senha" id="senha" value="" placeholder="Senha" required>
			  	</div>
			  </div>
			  <div class="row">
			  	<button class="btn btn-primary btn-lg btn-block">Entrar</button>
			  </div>
			</form>
  		</div>
	</div>
	
</body>
</html>