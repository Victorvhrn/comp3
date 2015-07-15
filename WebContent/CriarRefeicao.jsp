<%@page import="entidades.Turno"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cadastrar refeição</title>
</head>
<body>
	<% String erro = (String) request.getAttribute("mensagem");
	   if(erro != null){%>
	   <%= erro %>
	   <%} else {%>
	<b> Cadastrar Refeição</b>
	
	<form action="CriarRefeicao" method="post">
	<br>
	Turno:<select name = "turno">
	<option value =<%=Turno.MANHA%>>Manha</option>
	<option value =<%=Turno.TARDE%>>Tarde</option>
	<option value =<%=Turno.NOITE%>>Noite</option>
	</select>
	<br><br>
	Descrição:<input type = "text" name = "descricao" value = "">
	Opção Vegetariana:<input type = "text" name = "opcaoVegan" value = "">
	<br><br>
	<input type="submit" name="acaoCriar" value="Criar">
	<input type="submit" name="acaoCriar" value="Cancelar">
	<%} %>
	</form>
</body>
</html>
