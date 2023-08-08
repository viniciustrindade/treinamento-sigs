<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
    <title>Seja bem-vindo!</title>
</head>
	<body>
		<div class="container mt-3">
			<%-- comentário em JSP aqui: nossa primeira página JSP --%>
			<% String mensagem = "<h2>Seja bem-vindo ao sistema de agenda do FJ-21!</h2>"; %>
			<% out.println(mensagem); %>
			<br>
			<% String desenvolvido = "<p>Desenvolvido por (Alex Amor Divino dos Santos).</p>"; %>
			<%= desenvolvido %>
			<br>
			<% System.out.println("Tudo foi executado!"); %>
		</div>
	</body>
</html>