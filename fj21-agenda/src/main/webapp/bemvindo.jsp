<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

	<body>
	
		<%--	comentário em JSP  --%>
			<% String mensagem	=	"Bem vindo ao sistema de agenda do FJ-21!"; 	%>
			<%	out.println(mensagem);	%>
			
			<br/>
			<%String desenvolvido	=	"Desenvolvido por	(SEU NOME AQUI)";	%>
			<%=	desenvolvido	%>
			<br/>
			
			<% System.out.println("Tudo foi executado!"); %>
			
	</body>
</html>
		
