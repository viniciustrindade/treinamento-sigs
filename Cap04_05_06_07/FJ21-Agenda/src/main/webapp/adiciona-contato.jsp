<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@	page
	import="java.text.SimpleDateFormat,
				br.com.treinamento.servlet.modelo.Contato,
				br.com.treinamento.servlet.dao.ContatoDao"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@	taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Add contato</title>
</head>
<body>

	<jsp:useBean id="contato"
		class="br.com.treinamento.servlet.modelo.Contato" />
	<jsp:useBean id="dao" class="br.com.treinamento.servlet.dao.ContatoDao" />

	<%-- ID: ${param.id} --%>



	<c:import url="cabecalho/cabecalho.jsp" />


	<c:choose>

		<c:when test="${not empty param.id}">

			<%
			String idDoResponde = request.getParameter("id");

			Long idUpdate = Long.parseLong(idDoResponde);

			Contato contatoUpdate = dao.buscaPorId(idUpdate);
			
			SimpleDateFormat formataData = new SimpleDateFormat("dd/MM/yyyy"); 
			
			%>

			<form action="editarContato?id=<%=idUpdate%>" method="post" style="padding: 10px;">
				<fieldset>
					<legend style="font-weight: bold;">Editar Contato</legend>
					
					Nome: <input value="<%=contatoUpdate.getNome()%> " type="text" name="nome" style="padding: 10px;" /> <br /> 
					E-mail: <input value="<%=contatoUpdate.getEmail()%>" type="text" name="email" style="padding: 10px;" /> <br /> 
					Endereço: <input value="<%=contatoUpdate.getEndereco()%>" type="text" name="endereco" style="padding: 10px;" /> <br /> 
					Data de nascimento: <input value="<%=formataData.format(contatoUpdate.getDataNascimento().getTime()) %>" type="text" name="dataNascimento" placeholder="dd/MM/yyyy"
						style="padding: 10px;" /> <br /> 
					<input type="submit" value="Atualizar" style="padding: 10px;" />
				</fieldset>
			</form>


		</c:when>
		<c:otherwise>

			<form action="adicionaContato" method="post" style="padding: 10px;">

				<fieldset>
					<legend style="font-weight: bold;">Contato</legend>
					Nome: <input type="text" name="nome" style="padding: 10px;" /> <br />

					E-mail: <input type="text" name="email" style="padding: 10px;" />
					<br /> Endereço: <input type="text" name="endereco"
						style="padding: 10px;" /> <br /> Data de nascimento: <input
						type="text" name="dataNascimento" placeholder="dd/MM/yyyy"
						style="padding: 10px;" /> <br /> <input type="submit"
						value="Gravar" style="padding: 10px;" />
				</fieldset>
			</form>

		</c:otherwise>
	</c:choose>



	<div style="width: 50%; display: inline-block;">
		<form action="index.jsp">
			<input type="submit" value="Inicio" style="padding: 10px;" />
		</form>
		<form action="lista-contatos.jsp">
			<input type="submit" value="Contatos" style="padding: 10px;" />
		</form>
	</div>


	<c:import url="rodape/rodape.jsp" />
</body>
</html>