<%@page import="java.util.ArrayList"%>
<%@ page import="java.util.Collection" %>
<%@ page import="entidades.Departamento" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listando departamentos</title>
</head>

<body>

<%@include file="messagePage.jsp" %>

	<form action="ListarDepartamento" method="post">
		<table width="80%">

		<% String erro = (String) request.getAttribute("mensagem");
		   if(erro != null){%>
			<%=erro %>   
		   
		<%} else{%>
		  <tr>
		  	<th>&nbsp </th>
		    <th>Sigla</th>
		    <th>Nome</th>
		  </tr>
		  
		  <%

			  
				  ArrayList<Departamento> departamentosDisponiveis = (ArrayList<Departamento>)request.getAttribute("departamentos");
				  for (Departamento depti: departamentosDisponiveis)
				  {
		  %>
			  <tr align="center">
			    <td><input type = "radio" name = "id" value = "<%=depti.getId()%>"></td>
			    <td><%=depti.getSigla()%></td>
			    <td><%=depti.getNome()%></td>
			  </tr>
		  <%}%>
		  	
		</table>

		<input type="submit" name ="acaoListar" value = "Criar">
		
		
		<% }%>
		<br><input type="submit" name ="acaoListar" value = "Voltar">

	</form>
</body>

</html>