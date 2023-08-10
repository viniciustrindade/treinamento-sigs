<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="pt-br">
	<head>
	    <meta charset="utf-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
	    <link rel="icon" type="image/x-icon" href="imagens/favicon.ico">
	    <title>Captura idade</title>
	</head>
	<body>
		<div class="container mt-3">
			<h2>Informe a sua idade</h2>
			<form action="mostra-idade.jsp" method="post">
				<div class="form-floating  mt-3 mb-3">
				    <input type="number" min="0" class="form-control" id="idade" placeholder="Digite a sua idade" name="idade">
				    <label for="idade">Idade</label>
			  	</div>
			  	<button type="submit" class="btn btn-primary">Gravar</button>
			</form>
		</div>
	</body>
</html>