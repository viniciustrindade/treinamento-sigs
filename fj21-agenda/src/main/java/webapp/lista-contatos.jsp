
<body>
<c:import	url="cabecalho.jsp"	/>
<table>
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
						<td>${contato.endereco}
						
						<fmt:formatDate	value="${contato.dataNascimento.time}"
						pattern="dd/MM/yyyy"/></tr>
		</c:forEach>

</table>
<c:import	url="rodape.jsp"	/>
<body>