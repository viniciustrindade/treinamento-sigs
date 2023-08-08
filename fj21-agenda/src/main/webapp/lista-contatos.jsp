<html>
	<body>
		<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
		
		<c:import url="cabecalho.jsp" />
		
		<!-- cria o DAO -->
		<jsp:useBean id="dao" class="br.com.caelum.agenda.dao.ContatoDao"/>
		
		<table>
			<thead>
				<tr>
					<td>Nome</td>
					<td>E-mail</td>
					<td>Endereço</td>
					<td>Data de Nascimento</td>
				</tr>
			</thead>
		
			<tbody>
			<!-- percorre contatos montando as linhas da tabela -->
			<c:forEach var="contato" items="${dao.lista}" varStatus="id">
				<tr bgcolor="#${id.count % 2 == 0 ? 'aaee88' : 'ffffff' }">
					<td>${contato.nome}</td>
					<td>
					<c:choose>
						<c:when test="${not empty contato.email}">
							<a href="mailto:${contato.email}">${contato.email}</a>
						</c:when>
						<c:otherwise>
							E-mail não informado
						</c:otherwise>
					</c:choose>
					</td>
					<td>${contato.endereco}</td>
					<td><fmt:formatDate value="${contato.dataNascimento.time}" pattern="dd/MM/yyyy" /></td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
		
		<c:import url="rodape.jsp" />
	</body>
</html>