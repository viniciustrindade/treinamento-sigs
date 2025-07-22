<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
	
		<c:import url="cabecalho.jsp" />
		
		<!-- cria o DAO -->
		<jsp:useBean id="dao" class="br.com.caelum.servlet.dao.ContatoDao"/>
		<table>
			<th>Nome</th>
			<th>Email</th>
			<th>Endereço</th>
			<th>Nome</th>
			<!-- percorre contatos montando as linhas da tabela -->
			<c:forEach var="contato" items="${dao.lista}" varStatus="index">
				<tr bgcolor="#${index.count % 2 == 0 ? 'aaee88' : 'ffffff' }">
					<td>${contato.nome}</td>
					<td>
					<c:choose>
	         
				         <c:when test = "${not empty contato.email}">
				            <a href="mailto:${contato.email}">${contato.email}</a>
				         </c:when>
				         
				         <c:when test = "${empty contato.email}">
							E-mail não informado
				         </c:when>
			    	</c:choose>
					</td>
					<td>${contato.endereco}</td>
					<td><fmt:formatDate value="${contato.dataNascimento.time}"
pattern="dd/MM/yyyy" /></td>
				</tr>
			</c:forEach>
		</table>
		
		<c:import url="rodape.jsp" />
	</body>
</html>