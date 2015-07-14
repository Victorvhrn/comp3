<%@page import="entidades.Turno"%>
<%@page import="entidades.Refeicao"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista de Refeições</title>
</head>
<body>
	<form action="ListarRefeicao" method="post">
	<table width="80%">
	
	<% String erro = (String) request.getAttribute("mensagem");
			
		   if(erro != null){%>
			<%=erro %>   
		   
		<%} else{%>
		  <tr>
		  	<th>&nbsp </th>
		    <th>Turno</th>
		    <th>Descrição</th>
		    <th>Opção Vegetariana</th>
		  </tr>
		  
		  <%
				ArrayList<Refeicao> refeicoesDisponiveis = new ArrayList<Refeicao>();//(ArrayList<Refeicao>) request.getAttribute("refeicoes");
				refeicoesDisponiveis.add(new Refeicao(1,Turno.TARDE,"arroz e feijão","grama"));
				refeicoesDisponiveis.add(new Refeicao(1,Turno.NOITE,"lasanha","capim"));
		  		for (Refeicao refeicoes: refeicoesDisponiveis)
				{
					  
		  %>
			  <tr align="center">
			    <td><input type = "radio" name = "id" value = "<%=refeicoes.getId()%>"></td>
			    <td><%=refeicoes.getTurno()%></td>
			    <td><%=refeicoes.getDescricao()%></td>
			    <td><%=refeicoes.getOpcaoVegan()%></td>
			  </tr>
		  <%}%>
		  	
		</table>
		<br>
		<center>
		<td><input type="submit" name ="acaoListar" value = "Criar"></td>
		<td><input type="submit" name ="acaoListar" value = "Ver"></td>
		
		<% }%>
		<td><input type="submit" name ="acaoListar" value = "Voltar"></td>
		</center>
	</form>
	
</body>
</html>