<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<link href="/SpringBookMarket/resources/css/bootstrap.min.css" rel="stylesheet">
<title>예외 처리</title>
</head>
<body>
	<nav class = "navbar navbar-expand navbar-dark bg-dark">
		<div class = "container">
			<div class = "navbar-header">
				<a class = "navbar-brand" href = "/SpringBookMarket/home">Home</a>
			</div>
		</div>
	</nav>		
	<div class = "jumbotron">
		<div class = "container">
			<h2 class = "alert alert-danger">요청한 도서가 존재하지 않습니다.</h2>
		</div>
	</div>
	<div class = "container">
		<p>${exception}</p>
	</div>
	
	<div class="container">
		<p>
			<a href="books" class="btn btn-secondary">도서목록 &raquo;</a>
		</p>
	</div>
	
</body>
</html>