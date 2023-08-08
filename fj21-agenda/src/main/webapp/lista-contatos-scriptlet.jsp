<%@	page import="java.util.*, 
				java.text.SimpleDateFormat,
				java.util.Calendar,
				br.com.caelum.jdbc.*, 
				br.com.caelum.jdbc.dao.*,
				br.com.caelum.jdbc.modelo.*" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
    <title>Lista de contatos</title>
</head>
	<body>
		<div class="container mt-3">
			<h2>Lista de Contatos</h2>
			<table class="table">
				<thead>
					<tr>
						<th>Nome</th>
						<th>E-mail</th>
						<th>Endereço</th>
						<th>Data de nascimento</th>
					</tr>
			    </thead>
			    <tbody>
				<%
					ContatoDao dao = new ContatoDao();
					List<Contato> contatos = dao.getLista();
					
					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
					
					for (Contato contato : contatos) {
				%>
					<tr>
						<td><%= contato.getNome() %></td>
						<td><%= contato.getEmail() %></td>
						<td><%= contato.getEndereco() %></td>
						<td><%= contato.getDataNascimento() != null ? sdf.format(contato.getDataNascimento().getTime()) : "" %></td>
					</tr>
				<%
					}
				%>
				</tbody>
			</table>
		</div>
	</body>
</html>