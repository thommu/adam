<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8" content="">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="../css/bootstrap/bootstrap.min.css">
	<link rel="stylesheet" href="../css/common.css">
	<script src="../js/jquery-3.2.1.min.js" type="text/javascript"></script>
	<script src="../js/bootstrap/bootstrap.min.js" type="text/javascript"></script>
	<script src="../js/login.js" type="text/javascript"></script>

	<title>ERT - Login</title>

</head>
<body>
	<%
		//back button disabling
		response.setHeader("Cache-Control","no-cache, no-store, must-revalidate");
	%>
	<div class="container">
	<form name="form" action="../LoginServlet" method="post" onsubmit="return validateLogin()">
		<div class="row">
			<div class="col-sm-3"></div>
			<div class="col-sm-6 app_head app_head">
				<h2>ERT</h2>
			</div>
		</div>
		<hr>
		<div class="row">
			<div class="col-sm-6">
				<h4><b>Login</b></h4>
			</div>
		</div>
		<div class="form-group">
				<div class="row">
					<div class="col-sm-2"></div>
					<div class="col-sm-6">
						<span class="error">${errMsg}</span>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-2"></div>
					<div class="col-sm-6">
						<label for="username">User Name:</label> 
						<input type="text" class="form-control" id="username" name="username" maxlength="20">
					</div>
				</div>
				<div class="row">
					<div class="col-sm-2"></div>
					<div class="col-sm-6">
						<label for="password">Password:</label> 
						<input type="password" class="form-control" id="password" name="password" maxlength="20">
					</div>
				</div>
				<div class="row">&nbsp;</div>
				<div class="row">
					<div class="col-sm-2"></div>
					<div class="col-sm-6">
						<input type="submit" value="Login"> 
						<input type="reset"	value="Reset">
					</div>
				</div>
		</div>
	</form>
	</div>
</body>
</html>
<%-- session.setAttribute("errMsg", ""); --%>