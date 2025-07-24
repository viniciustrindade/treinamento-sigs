<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:import url="cabecalho.jsp"/>

	<jsp:useBean id="dao" class="br.com.caelum.servlet.ContatoDao"/>
	<table>
		<!-- .lista chama o getLista() -->
		<c:forEach var="contato" items="${dao.lista}" varStatus="id">
			<!-- Colocar o cabeçalho emcada coluna exercicio opcional -->
			<tr bgcolor="#b4b4b4">
				<td><strong>Nome</strong></td>
				<td><strong>Email</strong></td>
				<td><strong>Endereco</strong></td>
				<td><strong>Data de nascimento</strong></td>
			</tr>
			<!-- linhas pares ficam mais azuladas e impares mais avermelhadas -->
			<tr bgcolor="#${id.count % 2 == 0 ? 'ddddee' : 'ffeeee'}">
				<td>${contato.nome}</td>
				<!-- IF E ELSE -->
				<td>
					<%-- 
					<c:if test="${not empty contato.email}">					
						<a href="mailto:${contato.email}">${contato.email}</a>
					</c:if>
					<c:if test="${empty contato.email}">
						Email não informado no cadastro.
					</c:if> --%>
					<c:choose>
						<c:when test="${not empty contato.email}">
							<a href="mailto:${contato.email}">${contato.email}</a>
						</c:when>
						<c:otherwise>
							Email não informado no cadastro.
						</c:otherwise>
					</c:choose>
				</td>
				
				<td>${contato.endereco}</td>
				<%-- <td>${contato.dataNascimento.time}</td> --%>
				<!-- O .time em dataNascimento chama getTime() do Calendar -->
				<td> <fmt:formatDate value="${contato.dataNascimento.time}" 
					pattern="dd/MM/yyyy"/> </td>
			</tr>
		</c:forEach>
	</table>
	
	<c:import url="rodape.jsp"/>
</body>
</html>