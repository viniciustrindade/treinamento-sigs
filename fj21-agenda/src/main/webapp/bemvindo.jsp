<html>
<body>
	<%-- comentário em JSP aqui: nossa primeira página JSP --%>
	<%
		String mensagem = "Bem vindo ao sistema de agenda do FJ-21!";
	%>
	<% out.println(mensagem); %>
	
	<br/>

	<%
		String desenvolvido = "Desenvolvido por (SEU NOME AQUI)";
	%>
	<%= desenvolvido %>
	
	<br/>
	
	<%
		System.out.println("Tudo foi executado!");
	%>
</body>