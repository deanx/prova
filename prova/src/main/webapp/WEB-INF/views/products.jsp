<%@ page session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<link href="<c:url value="/static/resources/css/bootstrap.min.css"/>"
	rel="stylesheet" />

<link
	href="<c:url value="/static/resources/css/bootstrap-responsive.min.css"/>"
	rel="stylesheet">

<script type="text/javascript"
	src="<c:url value="/static/resources/js/jquery.js" />"></script>
<style type="text/css">
body {
	padding-top: 60px;
	padding-bottom: 40px;
}
</style>
<meta charset="utf-8">
<title>WallMart</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

</head>
<body>

	<div class="container">






		<div class="row">
			<form:form commandName="newProduct" id="reg" class="well form-inline">

				<form:input type="text" class="input-small" placeholder="Id"
					path="id" />

				<form:input type="text" class="input-small" placeholder="Nome"
					path="nome" />
				<button type="button" class="btn" id="btn-add">Adicionar</button>
			</form:form>

		</div>

		<div class="row">
			<c:choose>
				<c:when test="${products.size()==0}">
						Sem produtos
					</c:when>
				<c:otherwise>
				</c:choose>
					<table class="table table-striped" id="lst-produtos">
						<thead>
							<tr>
								<th>Id</th>
								<th>Nome</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${products}" var="product">
								<tr>
									<td>${product.id}</td>
									<td>${product.nome}</td>
									<td><a href="<c:url value="/products/${product.id}"/>">/products/${product.id}</a></td>
							</c:forEach>
						</tbody>

					</table>
				
			
		</div>
		<div class="row">/
			Ou em REST... <a href="<c:url value="/rest/products"/>">/rest/products</a>
		</div>
	</div>


	<script type="text/javascript">
		$("#lnk-clientes").click(function() {
			$("#lnk-produtos").removeClass("active");
			$(this).addClass("active");
		});

		$("#lnk-produtos").click(function() {
			$("#lnk-clientes").removeClass("active");
			$(this).addClass("active");
		});

		$("#btn-add")
				.click(
						function() {
							var vid = $("#id").val();
							var vnome = $("#nome").val();
							
							$
									.post("/prova/products", {
										id : vid,
										nome : vnome
									})
									.done(
											function(produtos) {
												$("#lst-produtos > tbody")
														.empty();
												for (i = 0; i < produtos.length; i++) {

													$("#lst-produtos > tbody")
															.append(
																	"<tr><td>"
																			+ produtos[i].id
																			+ "</td>"
																			+ "<td>"
																			+ produtos[i].nome
																			+ "</td>"
																			+ "<td><a href='<c:url value="/products/"/>"
																			+ produtos[i].id
																			+ "'>/products/"
																			+ produtos[i].id
																			+ "</td></tr>");
												}
											});
						});
	</script>
</body>
</html>