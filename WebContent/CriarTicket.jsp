<%@page import="entidades.Funcionario"%>
<%@page import="entidades.Curso"%>
<%@page import="entidades.Departamento"%>
<%@page import="entidades.Aluno"%>
<%@page import="entidades.Turno"%>
<%@page import="entidades.Refeicao"%>
<%@page import="entidades.CPF"%>
<%@page import="entidades.Sexo"%>
<%@page import="entidades.Titulo"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="entidades.Consumidor"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cadastrar Ticket</title>
</head>
<body>

<% String erro = (String) request.getAttribute("mensagem");
   if(erro != null){%>
   <%= erro %>
   <%} else{%>
   <center><b>Cadastrar Ticket</b></center>
   
   <form action="CriarTicket" method="post">
	<br><br>
   	
 		
	<% ArrayList<Consumidor> listaConsumidores = new ArrayList<Consumidor>();
	   ArrayList<Refeicao> listaRefeicoes = new ArrayList<Refeicao>();
	   listaConsumidores = (ArrayList<Consumidor>) request.getAttribute("consumidores");
	   listaRefeicoes = (ArrayList<Refeicao>) request.getAttribute("refeicoes");
 	   %>
	   
	   

	  	
	   <% for(Consumidor consumidores : listaConsumidores)
	   {%>	
	   	   
	   	   <%if(consumidores instanceof Aluno){%>
	   
	   		<td><input type ="radio" name = "consumidor" value ="<%=consumidores.getId()%>"></td>
	   		<b>Nome:</b>
	   		<td><%=consumidores.getNome()%></td>
	   	   	<b>Valor:</b>
	   	   	<td><%=Turno.MANHA + " " + Turno.MANHA.getValorAluno() + " " + Turno.TARDE + " " + Turno.TARDE.getValorAluno()
	   	 	+ " " + Turno.NOITE + " " + Turno.NOITE.getValorAluno()%></td>
	   	 	<b>Pago:</b>
	   	 	<td><select><option value = "true">Sim
			<option value = "false">Não </select></td>
			<b>Refeição:</b>
			<td><select name = "refeicao">
   	  		<% for(Refeicao refeicoes : listaRefeicoes)
   	   	  		{%>
   	   	  			<option value = "<%=refeicoes.getId()%>"><%=refeicoes.getTurno()+"-"+ " " +refeicoes.getDescricao()%></option>
   	      		<%}%>
   	  		</select><br></td>
	 
	   	  <%}else{%>
	   	 	
	   	  	<td><input type ="radio" name = "consumidor" value ="<%=consumidores.getId()%>"></td>
	   	  	<b>Nome:</b>
	   	  	<td><%=consumidores.getNome()%></td>
	   	  	<b>Valor:</b>
	   	  	<td><%=Turno.MANHA + " " + Turno.MANHA.getValorFuncionario() + " " + Turno.TARDE + " " + Turno.TARDE.getValorFuncionario()
 	   	 	+ " " + Turno.NOITE + " " + Turno.NOITE.getValorFuncionario()%></td>
 	   	 	<b>Pago:</b>
 	   	 	<td><select><option value = "true">Sim
			<option value = "false">Não </select></td>
			<b>Refeição:</b>
			<td><select name = "refeicao">
   	  		<% for(Refeicao refeicoes : listaRefeicoes)
   	   	  		{%>
   	   	  			<option value = "<%=refeicoes.getId()%>"><%=refeicoes.getTurno()+"-"+ " " +refeicoes.getDescricao()%></option>
   	      		<%}%>
   	  		</select></td>
	   	  <%} %>
	  <%}%> <br><br>
			<input type="submit" name="acaoCriar" value="Criar">
			<input type="submit" name="acaoCriar" value="Cancelar">
	<%} %>   
  </form>

</body>
</html>
