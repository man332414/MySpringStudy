<%@ page session = "false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<link href="./resources/css/bootstrap.min.css" rel="stylesheet">
	<meta charset="UTF-8">
	<title>Welcome</title>
</head>
<body>
	<nav class = "navbar navbar-expand navbar-dark bg-dark">
		<div class = "container">
			<div class = "navbar-header">
				<a href = "/SpringBookMarket/home" class = "navbar-brand">Home</a>
			</div>
		</div>
	</nav>
	<div class = "jumbotron">
		<div class = "container">
			<h1 class = "display-3">${greeting}</h1>
		</div>
	</div> 
	
	<div class = "contianer">
		<div class = "text-center">
				<h3>${strapline}</h3>				
		</div>
	</div>
	
	<footer class = "container">&#169; BookMarket</footer>
</body>
</html>