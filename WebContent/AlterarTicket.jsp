<%@page import="entidades.CPF"%>
<%@page import="entidades.Titulo"%>
<%@page import="entidades.Sexo"%>
<%@page import="entidades.Turno"%>
<%@page import="entidades.Refeicao"%>
<%@page import="entidades.Consumidor"%>
<%@page import="entidades.Ticket"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Alterar Ticket</title>
</head>
<body>
<form action = "ListarTicket" method = "post">
<table width="80%">
<% String erro = (String) request.getAttribute("mensagem");
			
		   if(erro != null){%>
			<%=erro %>   
		   
		<%}else{%>
		<b><center>Alterar Ticket</center></b>
		<br>
		<tr>
		 	<th>Pago</th>
		 	<th>Consumidor </th>
		 	<th>Refeicao</th>

		 	
		  </tr>
		<%Ticket ticket = (Ticket) request.getAttribute("ticket");%>
		<tr align="center">
		  <td><select><option value = "true">Sim
		  		  <option value = "false">Não
		  </select></td>
		  <td><%= ticket.getConsumidor().getMatricula()%></td>
		  <td><%= ticket.getRefeicao().getDescricao()%></td>
		  
		</tr>
		
		<%}%>
</table>
 		  <br>
 		  <input type="submit" name="acaoAlterar" value="Alterar">
		  <input type="submit" name="acaoAlterar" value="Cancelar">
</form>
</body>
</html>
