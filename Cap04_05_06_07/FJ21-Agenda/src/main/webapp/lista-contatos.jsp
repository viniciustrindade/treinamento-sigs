<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@	taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"	%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Contatos</title>
</head>
<body>
<jsp:useBean id="contato" class="br.com.treinamento.servlet.modelo.Contato" />
<jsp:useBean id="dao" class="br.com.treinamento.servlet.dao.ContatoDao" />

<c:import url="cabecalho/cabecalho.jsp" />


	<h2>Lista de Contatos</h2>
	<table border="2">
		<tr>
			<th></th>
			<th>Nome</th>
			<th>E-mail</th>
			<th>Endereço</th>
			<th>Data de nascimento</th>
			<th>Ações</th>
		</tr>	
		<c:forEach var="cont" items="${dao.contatos}" varStatus="id">
		<tr bgcolor="#${id.count % 2 == 0 ? 'd4e4fc' : 'ffffff'}">
			<td>${cont.id}</td>
			<td>${cont.nome}</td>
			<td>
				<c:choose>
					<c:when test="${not empty cont.email}">
						<a href="mailto:${cont.email}">${cont.email}</a>
					</c:when>
					<c:otherwise>E-mail não informado</c:otherwise>
				</c:choose>
			</td>
			<td>${cont.endereco}</td>
			<td>
				<fmt:formatDate value="${cont.dataNascimento.time}" pattern="dd/MM/yyyy"/>
			</td>
			<td>
				<a href="editarContato" >
					<input type="submit" value="Editar"/>
				</a>	
				
				<a href="removeContato?id=${cont.id}">
					<input type="submit" value="Excluir"/>
				</a>
				
				
				
			</td>
		</tr>  
		</c:forEach>

	</table>
	
	<form action="adiciona-contato.jsp" method="get" style="padding: 10px;">
		<fieldset style="width: 10%; padding: 10px">
			<input type="submit" value="Novo contato" />
		</fieldset>
	</form>
	<form action="index.jsp" method="get" style="padding: 10px;">
		<fieldset style="width: 10%; padding: 10px">
			<input type="submit" value="Voltar" />
		</fieldset>
	</form>	
	
	
	<c:import url="rodape/rodape.jsp" />
</body>










</html>