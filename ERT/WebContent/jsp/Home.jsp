<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="../css/bootstrap/bootstrap.min.css">
<link rel="stylesheet" href="../css/common.css">
<script src="../js/jquery-3.2.1.min.js" type="text/javascript"></script>
<script src="../js/bootstrap/bootstrap.min.js" type="text/javascript"></script>
<script src="../js/common.js" type="text/javascript"></script>
<script src="../js/home.js" type="text/javascript"></script>

<title>ERT Reporting</title>
</head>
<body>
	<%
		//Session check and back button disabling
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		if (session.getAttribute("userName") == null) {
			response.sendRedirect("Login.jsp");
		}
	%>

	<div class="container">
		<form name="form" action="../EventReportingServlet" method="post"
			onsubmit="return validateHome()">
			<div class="row">
				<div class="col-sm-3"></div>
				<div class="col-sm-6 app_head app_head">
					<h2>ERT</h2>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-3">
					<a href="EventResultsServlet" class="nav_btn left">My Reports</a>
				</div>
				<div class="col-sm-9">
					<span class="right">Welcome ${userName}, <a
						href="LogoutServlet" class="nav_btn"> Log out</a></span>
				</div>
			</div>
			<hr>
			<div class="row">
				<div class="col-sm-6">
					<h4>
						<b>Report an incident</b>
					</h4>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-2"></div>
				<div class="col-sm-6">
					<div class="form-group">
						<label for="category">PWD Category:</label> <select
							class="form-control float-sm-left" id="category" name="category">
							<option value="0">Road Gutter</option>
							<option value="1">Broken Pipeline</option>
							<option value="2">Illegal Garbage Disposal</option>
						</select>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-2"></div>
				<div class="col-sm-2">
					<a href="#" class="btn" onclick="getLocation()">Get Location</a>
				</div>
				<div class="col-sm-4" id="currentLocation" hidden="true"></div>
				<input type="hidden" name="department" id="department" value="PWD">
				<input type="hidden" name="latitude" id="latitude" value="">
				<input type="hidden" name="longitude" id="longitude" value="">
				<input type="hidden" name="locationText" id="locationText" value="">

			</div>
			<br>
			<div class="row">
				<div class="col-sm-2"></div>
				<div class="col-sm-6">
					<div class="form-group">
						<label for="description">Description</label> <input type="text"
							class="form-control" id="description" name="description" value="">
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-2"></div>
				<div class="col-sm-2">
					<input type="Submit" class="btn grey_btn" value="Submit">
				</div>

			</div>
			<br>
		</form>
	</div>




</body>
</html>