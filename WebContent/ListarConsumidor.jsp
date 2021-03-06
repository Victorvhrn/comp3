<%@page import="entidades.Curso"%>
<%@page import="entidades.Departamento"%>
<%@page import="entidades.CPF"%>
<%@page import="entidades.Titulo"%>
<%@page import="entidades.Sexo"%>
<%@ page import="java.util.Collection" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="entidades.Consumidor" %>
<%@ page import="entidades.Aluno" %>
<%@ page import="entidades.Funcionario" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listando consumidores</title>
</head>

<body>

<%! 

%>

<%@include file="messagePage.jsp" %>

	<form action="ListarConsumidor" method="post">
		
		<table width="80%">
		<% String erro = (String) request.getAttribute("mensagem");
			
		   if(erro != null){%>
			<%=erro %>   
		   
		<%} else{%>
		  <tr>
		 	<th>&nbsp </th>
		 	<th>Nome </th>
		 	<th>Matricula </th>
		 	<th>Ano de Ingresso</th>
		 	<th>Sexo</th>
		 	<th>Título</th>
		 	<th>CPF</th>
		 	<th>Departamento/Curso</th>
		 	
		  </tr>
		  		  <%
		  		  
		  		  ArrayList<Consumidor> consumidoresDisponiveis = new ArrayList<Consumidor>();			        
		  		  consumidoresDisponiveis = (ArrayList<Consumidor>)request.getAttribute("consumidores");
		  		 
		  		  
		  		  
		  		  
				  for (Consumidor consumidori: consumidoresDisponiveis)
				  {
				  %>
				  <tr align="center">
				  <td><input type = "radio" name = "id" value = "<%=consumidori.getId()%>"></td>
				  <td><%=consumidori.getNome()%></td>
				  <td><%=consumidori.getMatricula()%></td>
				  <td><%=consumidori.getAnoIngresso()%></td>
				  <td><%=consumidori.getSexo()%></td>
				  <td><%=consumidori.getTitulo()%></td>
				  <td><%=consumidori.getCpf()%></td>
				  <td><%if(consumidori instanceof Aluno){%>
				  		<%= ((Aluno)consumidori).getCurso().getSigla()%>
				  		<%}else{%>
				  		<%=((Funcionario)consumidori).getDepartamento().getSigla()%></td>
				  		<%} %>
				  </tr>	 
				  <%}%>
		</table>
		<br>		
		<center>  
		<input type="submit" name ="acaoListar" value = "Criar">
		<input type="submit" name ="acaoListar" value = "Atualizar">
		<%}%>		
		<td><input type="submit" name ="acaoListar" value = "Voltar"></td>
		</center>
	</form>
</body>

</html>
