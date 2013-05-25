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
			<form:form commandName="newMember" id="reg" class="well form-inline">

				<form:input type="text" class="input-small" placeholder="Nome"
					path="name" />

				<form:input type="text" class="input-small" placeholder="Email"
					path="email" />

				<form:input type="text" class="input-small" placeholder="Telefone"
					path="phoneNumber" />

				<form:input type="text" class="input-small" placeholder="Senha"
					path="password" />

				<select name="role" id="role">
					<option value="ROLE_USER">-- role --</option>
					<option value="ROLE_USER">Usuario</option>
					<option value="ROLE_ADMIN">Admin</option>
				</select>
				<button type="button" class="btn" id="btn-add">Adicionar</button>
			</form:form>

		</div>

		<div class="row">
			<c:choose>
				<c:when test="${members.size()==0}">
						Sem membros
					</c:when>
				<c:otherwise>
					<table class="table table-striped" id="lst-membros">
						<thead>
							<tr>
								<th>Id</th>
								<th>Nome</th>
								<th>E-mail</th>
								<th>Telefone</th>
								<th>Senha</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${members}" var="member">
								<tr>
									<td>${member.id}</td>
									<td>${member.name}</td>
									<td>${member.email}</td>
									<td>${member.phoneNumber}</td>
									<td>${member.password}</td>
									<td><a href="<c:url value="/rest/members/${member.id}"/>">/rest/members/${member.id}</a></td>
							</c:forEach>
						</tbody>

					</table>
				</c:otherwise>
			</c:choose>
		</div>
		<div class="row">
			Ou em REST... <a href="<c:url value="/rest/members"/>">/rest/members</a>
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
							var vname = $("#name").val();
							var vemail = $("#email").val();
							var vtel = $("#phoneNumber").val();
							var vpassword = $("#password").val();
							var vRole = $("#role").val();
							$
									.post("/prova/members", {
										name : vname,
										email : vemail,
										phoneNumber : vtel,
										password : vpassword,
										role: vRole
									})
									.done(
											function(membros) {
												$("#lst-membros > tbody")
														.empty();
												for (i = 0; i < membros.length; i++) {

													$("#lst-membros > tbody")
															.append(
																	"<tr><td>"
																			+ membros[i].id
																			+ "</td>"
																			+ "<td>"
																			+ membros[i].name
																			+ "</td>"
																			+ "<td>"
																			+ membros[i].email
																			+ "</td>"
																			+ "<td>"
																			+ membros[i].phoneNumber
																			+ "</td>"
																			+ "<td>"
																			+ membros[i].password
																			+ "</td>"
																			+ "<td><a href='<c:url value="/rest/members/"/>"
																			+ membros[i].id
																			+ "'>/rest/members/"
																			+ membros[i].id
																			+ "</td></tr>");
												}
											});
						});
	</script>
</body>
</html>