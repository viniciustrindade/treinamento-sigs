<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>500</title>
</head>
<body>

<c:import url="cabecalho/cabecalho.jsp" />
	<h1 style="color: red; font-weight: bold;">500 - Internal Server Error</h1>
	<h1>Problemas no Servidor.</h1>
	<h1>Entre em contato com a STI através do ramal 6100</h1>
	
	<form action="index.jsp">
			<input type="submit" value="Inicio" style="padding: 10px;" />
	</form>
	
	<c:import url="rodape/rodape.jsp" />
</body>
</html>