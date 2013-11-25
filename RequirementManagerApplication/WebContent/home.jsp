<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" 
    uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Requirement Management Application</title>
<link rel="stylesheet" type="text/css" href="//cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.0.2/css/bootstrap.css">
</head>

<body>
<div class="container">
		<div class="row">
			<div class="col-md-12 navbar" style="background-color:#8B898C; margin-top:1em">
				<div class="col-md-10">
					<div class="navbar-default">
						<a href="index.jsp"><h1 style="background-color:#8B898C; color:white">Requirement Management Application</h1></a>
					</div>
				</div>
				<div class="col-md-offset-2" style="padding-top: 15px;"></div>
			</div>
			<div class="col-md-12">
				<div class="col-md-2" style="margin-top:3em;">
					<div class="navbar-right" style="text-align:right;">
						<h3>Projects</h3>
						<c:forEach items="${projects}" var="proj">
							<a href="ProjectHomeServlet?projectID=${proj.id}">${proj.name}</a><br>
						</c:forEach>
					</div>
				</div>
				<div class="col-md-9" style="border-style:solid; border-color:blue;'">
					<div class="row" style="border-bottom:solid">
							<div class="col-md-6">
								<h2><c:out value="${selectedProject.name}"/></h2>
							</div>
							<div class="col-md-6 text-right nav-tabs">
								<a href="Index">Home</a>
								<a href="RequirementServlet?projectID=${selectedProject.id}">Requirements</a>
								<a href="HourServlet?projectID=${selectedProject.id}">Hours</a>
								<a href="RiskServlet?projectID=${selectedProject.id}">Risks</a>
							</div>
					</div>
						<table class="table table-striped table-hover">
							<tr>
								<th>Description</th>
								<td><c:out value="${selectedProject.description}"/></td>
							</tr>
							<tr>
								<th>Owner</th>
								<td><c:out value="${selectedProject.manager.firstName} ${selectedProject.manager.lastName}"/></td>
							</tr>
						</table>
				</div>
				<div class="col-md-offset-1"></div>
				</div>
		</div>
</div>
</body>
</html>