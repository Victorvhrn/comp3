<%@page import="entidades.CPF"%>
<%@page import="entidades.Titulo"%>
<%@page import="entidades.Sexo"%>
<%@page import="entidades.Consumidor"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Alterar Consumidor</title>
</head>
<body>
<form action="AlterarConsumidor" method = "post">
<% String erro = (String) request.getAttribute("mensagem");
			
		   if(erro != null)
		   {%>
				<%=erro %>   
		   
		 <%}else
		 	{%>
				<% Consumidor consumidor =  (Consumidor)request.getAttribute("consumidores");%>
				  	<table>
					<tr>
						<td>Nome:</td> 
						<td><input type = "text" name = "nome" value =""></td>
					</tr>
					<tr>
						<td>Matricula:</td> 
						<td><input type = "text" name = "matricula" value =""></td>
					</tr>
					<tr>
						<td> Ano de ingresso:</td> 
						<td><input type = "text" name = "anoIngresso" value =""></td>
					</tr>
					<tr>
							<td>Sexo:</td> 
							<td><input type="radio" name="sexo" value="masculino">Masculino</td>
	      					<td><input type="radio" name="sexo" value="feminino">Feminino</td>
					</tr>
					<tr>
						<td>Titulo:</td>
						<td><input type ="hidden" name ="titulo" value="<%=consumidor.getTitulo()%>"><%=consumidor.getTitulo()%></td>
					</tr>
					<tr> 
						<td>CPF:</td> 
						<td><input type = "hidden" name = "cpf" value ="<%=consumidor.getCpf()%>"><%=consumidor.getCpf()%></td>
					</tr>
					<tr>
						<td><input type="submit" name ="acaoAlterar" value = "Atualizar"></td>
						<td><input type="submit" name ="acaoAlterar" value = "Cancelar"></td>
					</tr>
				   </table>
		   <%}%>
		  

</form>
</body>
</html>