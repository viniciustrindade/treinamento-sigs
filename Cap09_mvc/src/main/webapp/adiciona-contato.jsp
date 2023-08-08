<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@	taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@	taglib tagdir="/WEB-INF/tags" prefix="treina"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Add contato</title>

<link href="css/jquery-ui.css" rel="stylesheet">
<script src="js/jquery.js"></script>
<script src="js/jquery-ui.js"></script>
</head>
<body>

	<c:import url="cabecalho/cabecalho.jsp" />


	<c:choose>
		<c:when test="${not empty contatoEdicao}">
		
		
		<form action="mvc?logica=AdicionaContatoLogica&id=${contatoEdicao.id}" method="post" style="padding: 10px;">
				<fieldset>
					<legend style="font-weight: bold;">Editar Contato</legend>
					
					Nome: <input value="${contatoEdicao.getNome()}" type="text" name="nome" style="padding: 10px;" required="required"/> <br /> 
					E-mail: <input value="${contatoEdicao.getEmail()}" type="text" name="email" style="padding: 10px;" required="required"/> <br /> 
					Endereço: <input value="${contatoEdicao.getEndereco()}" type="text" name="endereco" style="padding: 10px;" required="required"/> <br /> 
					Data de nascimento: <input value="${contatoEdicao.getDataNascimento().getTime()}" type="text" name="dataNascimento" placeholder="dd/MM/yyyy"
						style="padding: 10px;" /> <br /> 
					<input type="submit" value="Atualizar" style="padding: 10px;" />
				</fieldset>
		</form>
	
		</c:when>
		<c:otherwise>
		
			<form action="mvc?logica=AdicionaContatoLogica&id=${0}" method="post" style="padding: 10px;">
			<fieldset>
				<legend style="font-weight: bold;">Contato</legend>
				Nome: <input type="text" name="nome" style="padding: 10px;" required="required" /> <br /> 
				E-mail: <input type="text" name="email" style="padding: 10px;" required="required" /> <br />
				Endereço: <input type="text" name="endereco" style="padding: 10px;" required="required" /> <br /> 
				Data de nascimento: <treina:campoData id="dataNascimento" />
				
			<!-- <input type="text" name="dataNascimento" placeholder="dd/MM/yyyy" style="padding: 10px;" /> <br /> -->

			<input type="submit" value="Gravar" style="padding: 10px;" />
			
		</fieldset>
	</form>
		
		</c:otherwise>
	</c:choose>

	<div style="width: 50%; display: inline-block;">
		<form action="index.jsp" method="post">
			<input type="submit" value="Inicio" style="padding: 10px;" />
		</form>
		<form action="mvc?logica=ListaContatosLogica" method="post">
			<input type="submit" value="Contatos" style="padding: 10px;" />
		</form>
	</div>


	<c:import url="rodape/rodape.jsp" />
</body>
</html>