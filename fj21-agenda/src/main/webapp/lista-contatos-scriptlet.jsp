<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*,
    java.text.SimpleDateFormat,
    br.com.caelum.jdbc.dao.ContatoDao,
    br.com.caelum.jdbc.modelo.Contato" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>lista de contatos</title>
</head>
<body>
	<h2>Lista de Contatos</h2>
	<table border="1">
		<thead>
			<tr>
				<th>Nome</th>
				<th>Email</th>
				<th>Endereço</th>
				<th>Data de Nascimento</th>
			</tr>
		</thead>
		<tbody>
		<%
			ContatoDao dao = new ContatoDao();
			List<Contato> contatos = dao.getLista();
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			
			for(Contato contato : contatos) {
		%>	
			<tr>
				<td><%=contato.getNome() %></td>
				<td><%=contato.getEmail() %></td>
				<td><%=contato.getEndereco() %></td>
				<td><%=sdf.format(contato.getDataNascimento().getTime()) %></td>
			</tr>
		<%
			}
		%>
		</tbody>
	</table>
</body>
</html>
