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
			<div class="col-md-12 navbar" style="background-color:grey; margin-top:1em">
				<div class="col-md-10">
					<div class="navbar-default" style="background-color:grey">
						<a href="index.jsp"><h1 style="background-color:grey; color:white">Requirement Management Application</h1></a>
					</div>
				</div>
				<div class="col-md-2" style="padding-top: 15px;" >
					<form class="btn btn-primary" action="login.jsp">
						<input type="submit" value="Sign In">
					</form>
				</div>
			</div>
			<div class="col-md-12">
				<div class="col-md-2" style="margin-top:3em;">
					<div class="navbar-right" style="text-align:right;">
						<h3>Projects</h3>
						<c:forEach items="${projects}" var="project">
							<a href="ProjectHomeServlet?projectID=${project.id}">${project.name}</a><br>
						</c:forEach>
					</div>
				</div>
				<div class="col-md-9" style="border-style:solid; border-color:blue;'">
					<div class="row" style="border-bottom:solid">
						<div class="col-md-12"><h2>Projects</h2></div>
					</div>
					<table class="table table-striped table-hover">
						<tr>
							<th>Project</th>
							<th>Owner</th>
							<th>Hours</th>
						</tr>
						<%--For each project, create new row and populate fields with project name, manager name, and total hours--%>
						<c:choose>
							<c:when test="${not empty projects}">
								<c:forEach items="${projects}" var="project">
									<tr>
								 		<td>${project.name}</td>
										<td>${project.manager.firstName} ${project.manager.lastName}</td>
								 		<td>${project.totalHours}</td>
								 	</tr>
								</c:forEach>
							</c:when>
						</c:choose>
					</table>
				</div>
				<div class="col-md-offset-1"></div>
			</div>
		</div>
	</div>
</body>
</html>