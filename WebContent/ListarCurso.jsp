<%@page import="entidades.Departamento"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entidades.Curso"%>
<%@ page import="java.util.Collection" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

<meta charset="utf-8">
 <meta name="viewport" content="width=device-width, initial-scale=1">
 <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
 <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<title>Listando cursos</title>
</head>

<body>
<div align="center" class="jumbotron">
<h1>Sistema RU</h1>
</div>
<h4 align="center">Curso</h4>

<%@include file="messagePage.jsp" %>

	<form action="ListarCurso" method="post">
	
		<table width="80%" align="center">
		<%String erro = (String) request.getAttribute("mensagem");
			
			if(erro != null){
		%>
		<%= erro %>
		<%}else { %>
		 
		  
		  <tr>
		    <th>&nbsp;</th>
		    <th>&nbsp; Nome</th>
		    <th>&nbsp; &nbsp; Departamento</th>
		  </tr>
		  
		  <%
				  
				  ArrayList<Curso> cursosDisponiveis = new ArrayList<Curso>(); 
				  cursosDisponiveis = (ArrayList<Curso>)request.getAttribute("cursos");
				  
				
				  for (Curso cursoi: cursosDisponiveis){
					  
		  %>
			  <tr>
			  <td>
			 
			    <td class="breadcrumb"><%=cursoi.getNome()%></td>
			    <td class="breadcrumb"><%=cursoi.getDepartamento().getNome()%></td>
			  </tr>
		  <%}%>
		</table>
		<br>
		<center>
		<td><button id= "btn" type="submit" class="btn btn-primary" name="acaoListar" value="Criar">Criar</button></td>
		<% }%>
		<td><button id= "btn" type="submit" class="btn btn-primary" name="acaoListar" value="Voltar">Voltar</button></td>
		</center>
	</form>
	<div class="navbar navbar-inverse navbar-fixed-bottom" role="navigation">
 <div class="container">
  <p style="color:#FFFFFF" align="center"> @CcompUFRRJ Sleep not found</p>
  </div>
  </div>
</body>

</html>
