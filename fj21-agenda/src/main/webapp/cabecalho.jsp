<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- Usando caminho absoluto ao invés de relativo -->
	<img src="<c:url value="/imagens/stilogo.png"/>" style="width: 7%; margin-top: 20px;"/>
		<h2>Agenda de contatos do STI</h2>
	<hr />
</body>
</html>