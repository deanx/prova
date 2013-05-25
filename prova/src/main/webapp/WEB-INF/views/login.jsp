<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
<link href="<c:url value="/static/resources/css/bootstrap.min.css"/>"
	rel="stylesheet"/>
	
<link href="<c:url value="/static/resources/css/bootstrap-responsive.min.css"/>"
	rel="stylesheet">
	
	<script type="text/javascript" src="<c:url value="/static/resources/js/jquery.js" />"></script>
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
<body onload='document.f.j_username.focus();'>
<div class="container">
	
<div class="row"><img src="<c:url value="/static/resources/img/wmt_logo.jpg"/>"/></div>

	<c:if test="${not empty error}">
		<p class="text-error">
			Problemas no login<br /> Erro :
			${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
			<br/>
		</p>
	</c:if>
	
	<form name='f' action="<c:url value='j_spring_security_check' />"
		method='POST' class="form-horizontal">
		<div class="control-group">
			<label class="control-label" for="j_username">Usuario</label>
			<div class="controls">
				<input type="text" id="j_username" name="j_username"/>
			</div>
		</div>
		
		<div class="control-group">
			<label class="control-label" for="j_password">Senha</label>
			<div class="controls">
				<input type="text" id="j_password" name="j_password"/>
			</div>
		</div>	
			
		<div class="control-group">
			<div class="controls">
				<input type="submit" value="login"/>
			</div>
		</div>	
						

	</form>
	</div>
</body>
</html>