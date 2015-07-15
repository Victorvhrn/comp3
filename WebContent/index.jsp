<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>

<head>



<title id="title">Sistema Gerenciador do Restaurante Universitário</title>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>


<body >

<style type="text/css" >

body{
background-color:#FFFFF;
}

#Consumidor
{
width:300px;
margin:10px;

}
#Departamento
{
width:300px;
margin:10px;
}
#Curso
{
width:300px;
margin:10px;
}
#Refeicao
{
width:300px;
margin:10px;
}
#Ticket
{
width:300px;
margin:10px;
}
</style>

<script language= "JavaScript">

function redirecionar(nome){
		id = document.getElementById(nome);
	location.href = id.name;
}
</script>

<div align="center" class="jumbotron">
<h1>Sistema RU</h1>
</div>

<div class="container">
<table align="center" class="tabela">

 <tr>
  <td><div class="btn-group btn-group-lg"><button id="Consumidor" name="ListarConsumidor" type="button" class="btn btn-primary" onclick="redirecionar('Consumidor') " >Gerenciar Consumidores</button></div></td>
 </tr>
 <tr>
  <td><div class="btn-group btn-group-lg"><button id="Departamento" name="ListarDepartamento" type="button" class="btn btn-primary" onclick="redirecionar('Departamento')" >Gerenciar Departamento</button></div></td>
 </tr>
 <tr>
  <td><div class="btn-group btn-group-lg"><button id="Curso" name="ListarCurso" type="button" class="btn btn-primary" onclick="redirecionar('Curso')" >Gerenciar Cursos</button></div></td>
 </tr>
 <tr>
  <td><div class="btn-group btn-group-lg"><button id="Refeicao" name="ListarRefeicao" type="button" class="btn btn-primary" onclick="redirecionar('Refeicao')" >Gerenciar Refeição</button></div></td>
 </tr>
 <tr>
  <td><div class="btn-group btn-group-lg"><button id="Ticket" name="ListarTicket" type="button" class="btn btn-primary" onclick="redirecionar('Ticket')" >Gerenciar Ticket</button></div></td>
 </tr>
</table>


<div class="navbar navbar-inverse navbar-fixed-bottom" role="navigation">
 <div class="container">
  <p style="color:#FFFFFF" align="center"> @CcompUFRRJ Sleep not found</p>
  </div>
  </div>

<body>



<form action="index" method="post">


</form>
</body></a>
</html>
