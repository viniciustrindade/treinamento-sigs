<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Error</title>
</head>
<body>

<c:import url="cabecalho/cabecalho.jsp" />
	
	<h1 style="color: red; font-weight: bold;">Tem um erro no sistema, por favor verificar</h1>
	
	<form action="index.jsp">
			<input type="submit" value="Inicio" style="padding: 10px;" />
	</form>
	
	<c:import url="rodape/rodape.jsp" />
</body>
</html>