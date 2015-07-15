<%@page import="entidades.Departamento"%>
<%@page import="java.util.ArrayList"%>
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
		<%String erro = (String) request.getAttribute("mensagem");
			
			if(erro != null){
		%>
		<%= erro %>
		<%}else { %>
		  <tr>
		    <th>&nbsp;</th>
		    <th>Nome</th>
		    <th>Departamento</th>
		  </tr>
		  
		  <%
				  Departamento dp1 = new Departamento(1,"Departamento de Ciência da Computação","DCC");
		  		  Departamento dp2 = new Departamento(2,"Departamento de Tecnologias e Linguagens","DTL");
				  ArrayList<Curso> cursosDisponiveis = new ArrayList<Curso>();//(ArrayList<Curso>)request.getAttribute("cursos");
				  cursosDisponiveis.add(new Curso(1,"Ciência da Computação","CC",dp1));
				  cursosDisponiveis.add(new Curso(2,"Matemática","MAT",dp2));
				  
				  for (Curso cursoi: cursosDisponiveis){
					  
		  %>
			  <tr align="center">
			    <td><input type="radio" name='curso' value="<%cursoi.getId();%>"></td>
			    <td><%=cursoi.getNome()%></td>
			    <td><%=cursoi.getDepartamento().getNome()%></td>
			  </tr>
		  <%
				  }	 
		  %>
		</table>
		<br>
		<center>
		<td><input type="submit" name ="acaoListar" value = "Criar"></td>
		<td><input type="submit" name ="acaoListar" value = "Atualizar"></td>
		<td><input type="submit" name ="acaoListar" value = "Ver"></td>
		<% }%>
		<td><input type="submit" name ="acaoListar" value = "Voltar"></td>
		</center>
	</form>
</body>

</html>