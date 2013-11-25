<%@ page import="project.dao.Project,project.dao.Manager"
	language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Requirement Management Application</title>
<link rel="stylesheet" type="text/css"
	href="//cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.0.2/css/bootstrap.css">
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-lg-12 navbar" style="background-color: grey">
				<div class="col-lg-10">
					<div class="navbar-default">
						<h1 style="background-color: grey">Requirement Management Application</h1>
					</div>
				</div>
				<div class="col-lg-2" style="padding-top: 15px;"></div>
			</div>
			<div class="col-lg-2"></div>
			<div class="col-lg-8">
				<form action="LoginServlet" method="post">
					<!-- make a block around this; 100% to fill in columns -->
					<div class="form-group">
						<label for="exampleInputEmail1">Username</label> 
						<input type="text" name ="username" class="form-control" id="exampleInputEmail1" placeholder="Enter username">
					</div>
					<div class="form-group">
						<label for="exampleInputPassword1">Password</label>
						 <input type="password" name ="password" class="form-control" id="exampleInputPassword1" placeholder="Enter Password">
					</div>
					<button type="submit" class="btn btn-default">Submit</button>
				</form>
			</div>
			<div class="col-lg-2"></div>
		</div>
	</div>
</body>
</html>