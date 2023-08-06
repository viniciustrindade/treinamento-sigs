<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Editar contato</title>
</head>
<body>

	<c:import url="cabecalho/cabecalho.jsp" />


	<form action="editarContato" method="post" style="padding: 10px;">

		<fieldset>
			<legend style="font-weight: bold;">Contato</legend>
			Nome: <input type="text" name="nome" style="padding: 10px;" /> <br />

			E-mail: <input type="text" name="email" style="padding: 10px;" /> <br />

			Endereço: <input type="text" name="endereco" style="padding: 10px;" />
			<br /> Data de nascimento: <input type="text" name="dataNascimento"
				placeholder="dd/MM/yyyy" style="padding: 10px;" /> <br /> <input
				type="submit" value="Gravar" style="padding: 10px;" />
		</fieldset>
	</form>

	<div style="width: 50%; display: inline-block;">
		<form action="index.jsp">
			<input type="submit" value="Inicio" style="padding: 10px;" />
		</form>
		<form action="lista-contatos.jsp">
			<input type="submit" value="Contatos" style="padding: 10px;" />
		</form>
	</div>


	<c:import url="rodape/rodape.jsp" />
</body>
</html>