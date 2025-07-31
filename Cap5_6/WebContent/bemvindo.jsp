<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
<%
String mensagem = "Bem vindo ao sistema de agenda do TreinamentoSTI!";
%>
<% out.println(mensagem); %>
<br/>
<%
String desenvolvido = "Desenvolvido por Carlos Eduardo Pereira da SIlva Gramosa";
%>
<%= desenvolvido %>
<br/>
<%
System.out.println("Tudo foi executado!");
%>
</body>
</html>