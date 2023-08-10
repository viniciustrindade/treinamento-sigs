<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="ufba"%>
<!DOCTYPE html>
<html lang="pt-br">
	<head>
	    <meta charset="utf-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
	    <link rel="icon" type="image/x-icon" href="imagens/favicon.ico">
	    <title>Adiciona Contatos</title>
	</head>
	<body>
		<div class="container mt-3">
				
			<c:import url="cabecalho.jsp"/>
			
			<h3>Adiciona Contatos</h3>
			
			<form action="adicionarContato" method="post" accept-charset="utf-8">
				<ufba:campoTexto id="nome" rotulo="Nome"/>
				<ufba:campoTexto id="email" rotulo="Email"/>
				<ufba:campoTexto id="endereco" rotulo="Endereço"/>
				<ufba:campoData id="dataNascimento" rotulo="Data de Nascimento"/>
			  	<button type="submit" class="btn btn-primary">Gravar</button>
			</form>
			
			<c:import url="rodape.jsp"/>
			
		</div>
	</body>
</html>