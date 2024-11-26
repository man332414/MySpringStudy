<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href = "/SpringBookMarket/resources/css/bootstrap.min.css" rel = "stylesheet">
<script src="${pageContext.request.contextPath}/resources/js/controllers.js"></script>
<title>Cart</title>
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
			<h1 class = "display-3">장바구니</h1>
		</div>
	</div>
	<div class = "container">
		<div>
			<form:form name="clearForm" method="post">
			<input type="hidden" name="_method" value="delete">
				<a href="javascript:clearCart()" class="btn btn-danger pull-left">삭제하기</a>
			</form:form>
			<a href = "/SpringBookMarket/order?cartId=${cartId}" class="btn btn-success float-right">주문하기</a>
		</div>
		<div style="padding-top:50px">
			<table class="table table-hover">
				<tr>
					<th>도서</th>
					<th>가격</th>
					<th>수량</th>
					<th>소계</th>
					<th>비고</th>			
				</tr>
				<form:form name="removeForm" method="post">
				<input type="hidden" name="_method" value="put">
					<c:forEach items="${cart.cartItems}" var="item">
					<tr>
						<td>${item.value.book.bookId}-${item.value.book.name}</td>
						<td>${item.value.book.unitPrice}</td>
						<td>${item.value.quantity}</td>
						<td>${item.value.totalPrice}</td>
						<td><a href="javascript:removeFromCart('/SpringBookMarket/cart/remove/${item.value.book.bookId}')" class="badge badge-danger">삭제</a></td>
					</tr>
				</c:forEach>
				</form:form>
				
				<tr>
					<th></th>
					<th></th>
					<th>총액</th>
					<th>${cart.grandTotal}</th>
					<th></th>
				</tr>
			</table>
			<a href="/SpringBookMarket/books/" class="btn btn-secondary">&laquo; 쇼핑계속하기</a>
		</div>
		<footer>
			<p>&#169; BookMarket</p>
		</footer>
		
	</div>
</body>
</html>