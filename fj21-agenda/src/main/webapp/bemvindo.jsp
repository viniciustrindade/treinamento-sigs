<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bem-vindo</title>
</head>
	<body>
		<%-- comentário em JSP: nossa primeira página JSP --%>
		
		<%
			String mensagem = "Bem vindo ao sistema de agenda do FJ-21!";
		%>
		<% out.println(mensagem); %>
		
		<br/>
		
		<%
			String desenvolvido = "Desenvolvido por Rian";
		%>
		<%= desenvolvido %>
		
		<br/>
		
		<%
			System.out.println("Tudo foi executado!");
		%>
	</body>
</html>