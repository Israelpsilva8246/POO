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

<title>Cadastro de usuarios</title>
    
<link rel="stylesheet" href="css/Styles.css">
</head>

<body>

<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
  <a href="listar_usuarios.jsp" class="btn btn-danger">Voltar</a>
  
</nav>

	<div class="card">
    <div class="container mt-8">
    <div class="card-header">
    	
      <h1>Cadastro de usuario</h1>
      </div>
      <div class="card-body">
      <form action="GerenciarUsuario.do" method="POST" class="row g-9">
      <input type="hidden" name="idUsuario" value="${usuario.idUsuario }"/> 
        <div class="col-md-4">
          <label for="login" class="form-label">Login</label>
          <input type="text" name="login" class="form-control" id="login" value="${usuario.login }" required/>
        </div>
        
        <div class="col-md-4">
          <label for="senha" class="form-label">Senha</label>
          <input type="password" name="senha" class="form-control" id="senha" value="${usuario.senha }" required/>
        </div>
        
        <div class="col-md-4">
          <label for="nome" class="form-label">Nome</label>
          <input type="text" name="nome" class="form-control" id="nome" value="${usuario.nome }" required/>
        </div>
        
        <div class="col-md-4">
          <label for="phoneNumber" class="form-label">Telefone</label>
          <input
            type="text" name="telefone" class="form-control" id="phoneNumber" placeholder="+55(85) 98646-7447" value="${usuario.telefone }" required/>
        </div>
        
        <div class="col-md-4">
          <label for="dataInfo" class="form-label">Data de nacimento</label>
          <input type="date" class="form-control" name="data_nascimento" id="dataInfo" placeholder="dd/mm/yyyy" value="${usuario.dataNascimento }" required />
        </div>
        
        <div class="col-md-2">
          <label for="ageInfo" class="form-label">Idade</label>
          <input type="text" name="idade" class="form-control" id="ageInfo" value="${usuario.idade }" required />
        </div>

        <div class="row-g-4">
          <label class="form-label">Sexo:</label>
          

          <div class="custom-control custom-radio">
            <input class="custom-control-input" name="sexo" value="Masculino" type="radio" id="masculino" value="${usuario.sexo }" checked/>
            <label class="custom-control-label" for="masculino">Masculino</label>
          </div>

          <div class="custom-control custom-radio">
            <input class="custom-control-input" name="sexo" value="Feminino" type="radio" id="feminino" value="${usuario.sexo }" />
            <label class="custom-control-label" for="feminino">Feminino</label>
            </div>
        </div>

        <div class="col-md-7">
        <input class="btn btn-primary" type="submit" value="CADASTRAR"/>
        </div>
      </form>
      </div>
    </div>
    </div>


</body>
</html>