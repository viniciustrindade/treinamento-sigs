<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@	page import="java.util.*, 
				java.text.SimpleDateFormat,
				java.util.Calendar,
				br.com.caelum.jdbc.*, 
				br.com.caelum.jdbc.dao.*,
				br.com.caelum.jdbc.modelo.*" %>
				
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<body>

		<!--	cria	a	lista	-->
				<jsp:useBean	id="dao" class="br.com.caelum.jdbc.dao.ContatoDao"/>
				
			<table>
			
		<!--	for	-->
			<c:forEach	var="contato" items="${dao.lista}">
			
				<tr>
				<td>${contato.nome}</td>
				
				<td>
					<c:if	test="${not	empty	contato.email}">
						<a	href="mailto:${contato.email}">${contato.email}</a>
					</c:if>
												
					<c:if	test="${empty	contato.email}">
						E-mail	não	informado
				    </c:if>
						  
				</td>
				
					<td>${contato.endereco}</td>
					<td><fmt:formatDate	value="${contato.dataNascimento.time}" pattern="dd/MM/yyyy"	/></td>
				</tr>
				</c:forEach>
	
		</table>
		
		<footer>
		<c:import	url="rodape.jsp"/>
		</footer>
			

	
</body>
</html>