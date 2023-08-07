<%@ page import="java.util.*,
br.com.caelum.agenda.dao.*,
br.com.caelum.agenda.modelo.*,
java.text.SimpleDateFormat" %>

<html>
<body>
	<table>
		<thead>
			<tr>
				<td>Nome</td>
				<td>E-mail</td>
				<td>Endereço</td>
				<td>Data de Nascimento</td>
			</tr>
		</thead>
		
		<tbody>
			<%
			SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
			ContatoDao dao = new ContatoDao();
			List<Contato> contatos = dao.getLista();
			
			for (Contato contato : contatos ) {
				String dataNasc = fmt.format(contato.getDataNascimento().getTime());
			%>
		
			<tr>
				<td><%=contato.getNome() %></td>
				<td><%=contato.getEmail() %></td>
				<td><%=contato.getEndereco() %></td>
				<td><%=dataNasc %></td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>
</body>
</html>