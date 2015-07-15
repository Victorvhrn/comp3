<%@page import="entidades.Turno"%>
<%@page import="entidades.Refeicao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Alterar Refeição</title>
</head>
<body>
	<%//Refeicao refeicao = new Refeicao(1,Turno.NOITE,"lasanha","capim");
	String erro = (String) request.getAttribute("mensagem");
	erro = null;
	if(erro != null)
	{%>
	<%=erro %>
	<%}else
	{%>
	<b>Alterar Refeição</b>
	<%Refeicao refeicao = (Refeicao) request.getAttribute("refeicao");%>
	<br><br>
	Turno: <input type ="hidden" name = "turno" value ="<%=refeicao.getTurno()%>"><%=refeicao.getTurno()%>
	<br>
	Descrição:<input type = "text" name = "descricao" value = "">
	Opção Vegetariana:<input type = "text" name = "opcaoVegan" value = "">
	<br><br>
	<input type="submit" name="acaoAlterar" value="Alterar">
	<input type="submit" name="acaoAlterar" value="Cancelar">
	<%} %>
</body>
</html>
