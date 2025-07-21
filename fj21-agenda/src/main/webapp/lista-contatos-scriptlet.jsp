<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<%@ page import="java.util.*, br.com.caelum.servlet.*, java.text.*" %>
		<%
			ContatoDao dao = new ContatoDao();
			List<Contato> contatos = dao.getLista();
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			
			
			for (Contato contato : contatos) {
			String dataFormatada = dateFormat.format(contato.getDataNascimento().getTime());
		%>
			<tr>
				<td><%="Nome: " + contato.getNome()%></td>					
				<td><%="Email: " + contato.getEmail()%></td>					
				<td><%="Endereco: " + contato.getEndereco()%></td>					
				<td><%="Data de nascimento: " + dataFormatada%></td>					
			</tr>
		<%
			}
		%>
	</table>
</body>
</html>