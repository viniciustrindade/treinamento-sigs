<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.*,
br.com.treinamento.servlet.*" %>

<html>
<body>
<table>
<%
ContatoDAO dao = new ContatoDAO();
List<Contato> contatos = dao.getLista();
for (Contato contato : contatos ) {
%>
<tr>
<td><%=contato.getNome() %></td>
<td><%=contato.getEmail() %></td>
<td><%=contato.getEndereco() %></td>
<td><%=contato.getDataNascimento().getTime() %></td>
</tr>
<%
}
%>
</table>
</body>
</html>