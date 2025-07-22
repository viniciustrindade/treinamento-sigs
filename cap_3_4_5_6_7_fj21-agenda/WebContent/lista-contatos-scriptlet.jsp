<%@ page import="java.util.*,
	br.com.caelum.servlet.dao.*,
	br.com.caelum.servlet.modelo.*,
	java.text.*" %>

<html>
	<body>
	<table>
		<th>Nome</th>
		<th>Email</th>
		<th>Endereço</th>
		<th>Nome</th>
			<%
				ContatoDao dao = new ContatoDao();
				List<Contato> contatos = dao.getLista();
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				for (Contato contato : contatos ) {
			%>
			
				<tr>
					<td><%=contato.getNome() %></td>
					<td><%=contato.getEmail() %></td>
					<td><%=contato.getEndereco() %></td>
					<td><%= sdf.format(contato.getDataNascimento().getTime()) %></td>
				</tr>
			<%
				}
			%>
	</table>
	</body>
</html>