<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>FJ21-Agenda - Tomcat-9</title>
</head>
<body>

<c:import url="cabecalho/cabecalho.jsp" />
	

	<h1>Bem-Vindo (a) - Treinamento SIGAA</h1>
	<form action="mvc?logica=NovoContatoLogica" method="post" style="padding: 10px;">
		<fieldset style="width: 10%; padding: 10px">
			<input type="submit" value="Adicionar contato" />
		</fieldset>
	</form>
	<form action="mvc?logica=ListaContatosLogica" method="post" style="padding: 10px;">
		<fieldset style="width: 10%; padding: 10px">
			<input type="submit" value="Exibir contatos" />
		</fieldset>
	</form>

<c:import url="rodape/rodape.jsp" />
</body>
</html>