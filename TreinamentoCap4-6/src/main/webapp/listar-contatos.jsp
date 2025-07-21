<%@ page import="dao.ContatoDao" %>
<%@ page import="modelo.Contato" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.SimpleDateFormat" %>


<html>

<head>
<meta charset="utf-8"/>
<title>Lista de contatos</title>
</head>

<body>

<table border="1" cellpadding="5">


<tr>
	<th>Id</th>
    <th>Nome</th>
    <th>Email</th>
    <th>Endereço</th>
    <th>Data de nascimento</th>
</tr>

<%

try {

	ContatoDao dao = new ContatoDao();
    List<Contato> contatos = dao.buscarTodos();
	
    SimpleDateFormat formatarData = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
              
    for (Contato contato : contatos) {
%>



<tr>
	<td><%=contato.getId() %></td>
	<td><%=contato.getNome() %></td>
	<td><%=contato.getEmail() %></td>
	<td><%=contato.getEndereco() %></td>
	<td><%=formatarData.format(contato.getDataNascimento().getTime()) %></td>
</tr>

<%
 	}// fim do for

    } catch (Exception e) {
        out.println("<tr><td>Erro ao buscar contatos: " + e.getMessage() + "</td></tr>");
    }
%>

</table> <br/> <br/>

<p><a href="./">Voltar ao inicio </a> </p>

</body>
</html>


