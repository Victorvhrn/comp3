<%@page import="entidades.Sexo"%>
<%@page import="entidades.Titulo"%>
<%@page import="entidades.CPF"%>
<%@page import="entidades.Turno"%>
<%@page import="entidades.Refeicao"%>
<%@page import="entidades.Consumidor"%>
<%@page import="entidades.Ticket"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista de Tickets</title>
</head>
<body>
<form action = "ListarTicket" method = "post">
<table width="80%">

<% String erro = (String) request.getAttribute("mensagem");
			
		   if(erro != null){%>
			<%=erro %>   
		   
		<%} else{%>
		  <tr>
		 	<th>&nbsp </th>
		 	<th>Pago</th>
		 	<th>Consumidor </th>
		 	<th>Refeicao</th>
		 	<th>Valor</th>
		 	<th>Turno</th>
		 	
		  </tr>
		  		  <%
		  		  
		  		  ArrayList<Ticket> listaDeTickets = new ArrayList<Ticket>(); 
		  		  listaDeTickets = (ArrayList<Ticket>) request.getAttribute("tickets");
		  		  String pago;
		  		  
				  for (Ticket ticketi: listaDeTickets)
				  {
				  %>
				  <tr align="center">
				  <td><input type = "radio" name = "id" value = "<%=ticketi.getId()%>"></td>
				  <td><%if(ticketi.isPago() == true){ 
					  	  pago = "sim";%>
				  	   	  <%=pago%>
				  	  <%}else{ 
				  		  pago = "não";%>
				  	  	  <%=pago%>
				  	  	  <%} %></td>
				  <td><%=ticketi.getConsumidor().getMatricula()%></td>
				  <td><%=ticketi.getRefeicao().getDescricao()%></td>
				  <td><%=ticketi.getRefeicao().getTurno().getValorAluno()%></td>
				  <td><%=ticketi.getRefeicao().getTurno()%></td>
				 
				  </tr>	 
				  <%}%>
		</table>
		<br>		
		<center>  
		<input type="submit" name ="acaoListar" value = "Criar">
		<input type="submit" name ="acaoListar" value = "Alterar">
		<%}%>		
		<td><input type="submit" name ="acaoListar" value = "Voltar"></td>
		</center>

</form>

</body>
</html>
