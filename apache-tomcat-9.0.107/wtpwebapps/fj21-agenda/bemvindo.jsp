<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- Comentário em JSP: Minha primeira página JSP --%>
	<%@ page import="br.com.caelum.servlet.ContatoDao" %>
	<%@ page import="br.com.caelum.servlet.Contato" %>
	<%@ page import="java.util.*" %>
	
	<%
		String mensagem = "Bem vindo ao sistema de agenda do FJ-21.";
	%>
	<%= mensagem %><br/>
	
	<%
		String desenvolvido = "Desenvolvido por Maurício Matchal";
	%>
	<% out.println(desenvolvido); %><br/>
	
	<%
		System.out.println("Tudo foi executado");
	%>
	
	<% 
		ContatoDao dao = new ContatoDao();
		List<Contato> contatos = dao.getLista();
		
		for (Contato contato : contatos) {
	%>
		<li><%=contato.getNome()%>, <%=contato.getEmail()%>, 
		<%=contato.getEndereco()%></li>
	<%
		}
	%>
</body>
</html>