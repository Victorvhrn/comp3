<%@page import="java.util.ArrayList"%>
<%@page import="entidades.Curso"%>
<%@page import="java.util.Collection"%>
<%@page import="entidades.Departamento"%>
<%@page import="entidades.Consumidor"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Criar Consumidor</title>
</head>
 
<body>
	<form action="CriarConsumidor" method = "post">
	Criar consumidor <br>
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
		<td><input type="radio" name="titulo" value="especializacao">Especialização</td>
		<td><input type="radio" name="titulo" value="mestrado">Mestrado</td>
		<td><input type="radio" name="titulo" value="doutorado">Doutorado</td>
	</tr>
	<tr> 
		<td>CPF:</td> 
		<td><input type = "text" name = "cpf" value =""></td>
	</tr>
	<tr>
	<%  
	ArrayList<Departamento> listaDepartamentos = new ArrayList<Departamento>();
	listaDepartamentos = (ArrayList<Departamento>) request.getAttribute("departamentos");
	  for (Departamento dept: listaDepartamentos){
	%>
	<td><input type="radio" name="tipo" value="funcionario">Funcionario</td>
	 <select>
  		<option name ="departamento" value ="<%=dept.getId()%>" ><%=dept.getNome()%></option>
	 </select> 
	</tr>
	<%} %>
	<%ArrayList<Curso> cursos = new ArrayList<Curso>();
	  cursos = (ArrayList<Curso>) request.getAttribute("cursos");
		
	  for (Curso curso: cursos){
	%>
	<td><input type="radio" name="tipo" value="aluno">Aluno</td>
	 <select>
  		<option name ="curso" value ="<%=curso.getId()%>" ><%=curso.getNome()%></option>
	 </select> 
	</tr>
	<%}%>
	<tr>
	<td><input type="submit" name ="acaoCriar" value = "Criar"></td>
	</tr>
	</table>
	</form>
	
</body>

</html>
