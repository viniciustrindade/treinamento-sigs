<%@page import="br.com.treinamento.servlet.dao.ContatoDao"%>
<%@page import="br.com.treinamento.servlet.modelo.Contato"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Bem-Vindo</title>
</head>
<body>
	Bem-Vindo (a) ao Treinamento SIGAA
	
	<%
		ContatoDao dao = new ContatoDao();
		List<Contato> contatos = dao.listarContatos();
		
		for(Contato c: contatos){
	%>
	<li><%=c.getNome() %> , <%=c.getEmail() %>: <%=c.getEndereco() %></li>
	
	<%		
		}
	%>
	
</body>
</html>