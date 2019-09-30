<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
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
		<div class="row">
			<div class="col-sm-3">
				<a href="Home.jsp" class="nav_btn left">Home</a>
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
					<b>My Reported Events</b>
				</h4>
			</div>

		</div>
		<div class="row">
			<div class="col-sm-12">
				<table class="table table-condensed table-striped ">
					<thead class="thead-light">
						<tr>
							<th>Case#</th>
							<th>Date</th>
							<th>Location</th>
							<th>Description</th>
							<th>Status</th>
						</tr>
					</thead>
					<tbody>
						<!-- Loop through each report and display the values in tabular form -->
						<c:forEach items="${eventReportList}" var="report">
							<fmt:formatDate value="${report.reportingTime}"
								var="formattedTime" type="both" timeStyle="short" />
							<tr>
								<td><c:out value="${report.incidentId}" /></td>
								<td><c:out value="${formattedTime}" /></td>
								<td><c:out value="${report.locationText}" /></td>
								<td><c:out
										value="${fn: substring(report.description,0,30)}" /></td>
								<td><c:out value="${report.status}" /></td>
							</tr>
						</c:forEach>
						<!-- Display Custom Message if not Events are reported by user -->
						<c:if test="${ empty eventReportList}">
							<tr>
								<td colspan=5>No Events Reported.</td>
							</tr>
						</c:if>
					</tbody>
				</table>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-3">
				<input type="button" class="btn grey_btn" value="Back"
					onclick="history.back()">
			</div>
		</div>
	</div>
</body>
</html>