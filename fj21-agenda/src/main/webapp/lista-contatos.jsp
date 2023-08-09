<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@	page import="java.util.*, 
				java.text.SimpleDateFormat,
				java.util.Calendar,
				br.com.caelum.jdbc.*, 
				br.com.caelum.jdbc.dao.*,
				br.com.caelum.jdbc.modelo.*" %>
				
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
		
			<c:import url="cabecalho.jsp"/>
					
<!--  			<h3>Lista de Contatos</h3> -->
			
			<!-- cria o DAO -->
			<jsp:useBean id="dao" class="br.com.caelum.jdbc.dao.ContatoDao"/>
			
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
			    	<c:forEach var="contato" items="${dao.lista}">
						<tr>
							<td>${contato.nome}</td>
							<td>
								<c:choose>
									<c:when test="${not empty contato.email}">
										<a href="mailto:${contato.email}">${contato.email}</a>
									</c:when>
									<c:otherwise>E-mail não informado</c:otherwise>
								</c:choose>
							</td>
							<td>${contato.endereco}</td>
							<td><fmt:formatDate value="${contato.dataNascimento.time}" pattern="dd/MM/yyyy"/></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			
			<c:import url="rodape.jsp"/>
			
		</div>
	</body>
</html>