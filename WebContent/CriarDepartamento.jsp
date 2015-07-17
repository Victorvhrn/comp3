<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


<style type="text/css" >
#btn{
width:100px;
margin:10px;
}
#form{
width:400px;
}
#Criar{
margin:10px;
width:40px;
}
#Cancelar{
margin:10px;
width:40px;
}
</style>

<title>Criar departamento</title>
<meta charset="utf-8">
 <meta name="viewport" content="width=device-width, initial-scale=1">
 <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
 <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<%@include file="messagePage.jsp" %>
<body>
<div align="center" class="jumbotron">
<h1>Sistema RU</h1>
</div>
<h4 align="center">Criar Departamento</h4></h5>

<table align="center">

	<form action="CriarDepartamento" method="post">
	<tr>
	 <td><input id="form" type="text" name="nome" class="form-control" placeholder="Nome" aria-describedby="basic-addon2"></td>
	</tr>
	<tr>
	<td><input id="form" type="text" name="sigla" class="form-control" placeholder="Sigla" aria-describedby="basic-addon2"></td>
	</tr>
	</table>
	<br>
	<table align="center">
	<tr>
	  <td align="left"><button id= "btn" type="submit" class="btn btn-primary" value="Criar">Criar</button></td>
	  <td align="left"><button id= "btn" type="submit" class="btn btn-primary" value="Cancelar">Cancelar</button></td>
	</tr>
	
	
	
	</form>
	</table>
	<div class="navbar navbar-inverse navbar-fixed-bottom" role="navigation">
 <div class="container">
  <p style="color:#FFFFFF" align="center"> @CcompUFRRJ Sleep not found</p>
  </div>
  </div>
</body>

</html>
