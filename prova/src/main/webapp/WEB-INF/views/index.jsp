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
			<img src="<c:url value="/static/resources/img/wmt_logo.jpg"/>" />
		</div>

		<ul class="nav nav-tabs">
			<sec:authorize access="hasRole('ROLE_ADMIN')">
				<li id="lnk-clientes"><a href="#">Clientes</a></li>
			</sec:authorize>
			
			
			<sec:authorize access="hasAnyRole('ROLE_USER', 'ROLE_ADMIN')">
			<li id="lnk-produtos"><a href="#">Produtos</a></li>
			</sec:authorize>
			<li><a href="<c:url value="/j_spring_security_logout" />">
					Logout</a></li>
		</ul>

		<div class="row" id="content">
		</div>		
	</div>


	<script type="text/javascript">
		$("#lnk-clientes").click(function() {
			$("#lnk-produtos").removeClass("active");
			$(this).addClass("active");
			$("#content").load("/prova/members");
		});

		$("#lnk-produtos").click(function() {
			$("#lnk-clientes").removeClass("active");
			$(this).addClass("active");
			$("#content").load("/prova/products");
		});
	</script>
</body>
</html>