<%@page import="entidades.Curso"%>
<%@ page import="java.util.Collection" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listando cursos</title>
</head>

<body>

<%@include file="messagePage.jsp" %>

	<form action="ListarCurso" method="post">
		<table width="80%">
		  <tr>
		    <th>&nbsp;</th>
		    <th>Nome</th>
		    <th>Departamento</th>
		  </tr>
		  
		  <%
			  try{
				  Collection<Curso> cursosDisponiveis = (Collection<Curso>)request.getAttribute("curso");
				  for (Curso cursoi: cursosDisponiveis){
		  %>
			  <tr align="center">
			    <td><input type="radio" name='curso' value="<%cursoi.getId();%>"></td>
			    <td><%=cursoi.getNome()%></td>
			    <td><%=cursoi.getDepartamento()%></td>
			  </tr>
		  <%
				  }
			  }catch(Exception e){ }
		  %>
		</table>

		<input type="submit" name ="acaoListar" value = "Criar">
		<input type="submit" name ="acaoListar" value = "Atualizar">
		<input type="submit" name ="acaoListar" value = "Ver">
		<!-- <input type="submit" name ="acaoListar" value = "Remover"> -->
	</form>
</body>

</html>