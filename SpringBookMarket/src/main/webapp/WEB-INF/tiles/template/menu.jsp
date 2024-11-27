<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<nav class = "navbar navbar-expand navbar-dark bg-dark">
	<div class = "container">
		<div class = "navbar-header">
			<a class = "navbar-brand" href = "/SpringBookMarket/home">Book Market</a>
		</div>
		<div>
			<ul class="navbar-nav mr-auto">
				<li class="nav-item"><a class="nav-link" href="/SpringBookMarket/home">Home</a></li>
				<li class="nav-item"><a class="nav-link" href="/SpringBookMarket/books">Books</a></li>
				<li class="nav-item"><a class="nav-link" href="/SpringBookMarket/books/add">Add Book</a></li>
				<li class="nav-item"><a class="nav-link" href="/SpringBookMarket/cart">Cart</a></li>
			</ul>
		</div>
	</div>
</nav>