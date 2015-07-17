<%@page import="javax.sound.midi.SysexMessage"%>
<%@page import="java.util.ArrayList"%>
<%@ page import="java.util.Collection" %>
<%@ page import="entidades.Departamento" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta charset="utf-8">
 <meta name="viewport" content="width=device-width, initial-scale=1">
 <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
 <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
 <title>Lista de departamentos</title>
 
 <style type="text/css" >
 #btn{
width:100px;
margin:10px;
 }
#span{
width:10px;
margin:0px;
}



#Criar{
margin:10px;
width:40px;
}
#Voltar{
margin:10px;
width:40px;
}
</style>

</head>

<body>
<div align="center" class="jumbotron">
<h1>Sistema RU</h1>
</div>
<h4 align="center">Departamento</h4>



<%@include file="messagePage.jsp" %>

	<form action="ListarDepartamento" method="post">
		<table width="80%" align="center">

		<% String erro = (String) request.getAttribute("mensagem");
		  
		   if(erro != null){%>
			<%=erro %>   
		   
		<%} else{%>
		  <tr>
		  	<th>&nbsp; </th>
		    <th>&nbsp; Sigla</th>
		    <th>&nbsp; &nbsp;Nome</th>
		  </tr>
		  
		  <%
				ArrayList<Departamento> departamentosDisponiveis = new ArrayList<Departamento>();
				departamentosDisponiveis = (ArrayList<Departamento>)request.getAttribute("departamentos");
			
		  		for (Departamento depti: departamentosDisponiveis)
				{
					  
		  %>
			  <tr>
			    <td>
			     
                    
			   
			    <td  class="breadcrumb"><%=depti.getSigla()%></td>
			    <td  class="breadcrumb"><%=depti.getNome()%></td>
			  </tr>
		  <%}%>
		  	
		</table>
		<br>
		<center>
		<td>
		<button id= "btn" type="submit" class="btn btn-primary" name="acaoListar" value="Criar">Criar</button></td>
		
		<% }%>
		<td>
		<button id= "btn" type="submit" class="btn btn-primary" name="acaoListar" value="Voltar">Voltar</button></td>
		</center>
	</form>
	<div class="navbar navbar-inverse navbar-fixed-bottom" role="navigation">
 <div class="container">
  <p style="color:#FFFFFF" align="center"> @CcompUFRRJ Sleep not found</p>
  </div>
  </div>
</body>

</html>
