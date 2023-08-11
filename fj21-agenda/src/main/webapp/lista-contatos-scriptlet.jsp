<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@	page import="java.util.*,
	br.com.caelum.jdbc.dao.*,
	br.com.caelum.jdbc.modelo.*"	
	java.util.Calendar%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista-Contatos-Scriplet</title>
</head>
<body>
		<table>
		
				<%ContatoDao	dao	=	new	ContatoDao();
					List<Contato>	contatos	=	dao.getLista();
				    for	(Contato	contato	:	contatos	)	{
				
				%>
				<tr>
						<td><%=contato.getNome()	%></td>
						<td><%=contato.getEmail()	%></td>
						<td><%=contato.getEndereco()	%></td>
						<td><%=contato.getDataNascimento().getTime() %></td>
				</tr>
				<%
						}
				%>
				
		</table>
		
</body>
</html>