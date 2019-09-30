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
</head>
<body>
	<%
		//Session check and back button disabling
		response.setHeader("Cache-Control","no-cache, no-store, must-revalidate");
		if (session.getAttribute("userName") == null) {
			response.sendRedirect("Login.jsp");
		}
		
	%>
	<div class="container">
		<div class="row">
			<div class="col-sm-3"></div>
			<div class="col-sm-6 app_head">
				<h2>ERT</h2>
			</div>
		</div>
		<hr>
		<div class="row">
			<div class="col-sm-12">
				<p>
					Thank you ${userName}, for reporting the issue.<br> An
					incident with reference number <b>${param.caseId}</b> has been
					created for your reference. Our Team is working on prioritizing and
					resolving the issue as soon as possible.
				</p>
			</div>
		</div>

		<div class="row">
			<div class="col-sm-6">
				<input type="button" class="btn grey_btn" value="Back"
					onclick="history.back()">
			</div>
		</div>
	</div>
</body>
</html>