<%@page import="com.springmvc.DTO.Book"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<link href = "/SpringBookMarket/resources/css/bootstrap.min.css" rel = "stylesheet">
<script src="${pageContext.request.contextPath}/resources/js/controllers.js"></script>
	<title>도서 상세정보</title>
</head>
<body>
<!-- 	<nav class = "navbar navbar-expand navbar-dark bg-dark"> -->
<!-- 		<div class = "container"> -->
<!-- 			<div class = "navbar-header"> -->
<!-- 				<a class = "navbar-brand" href = "/SpringBookMarket/home">Home</a> -->
<!-- 			</div> -->
<!-- 		</div> -->
<!-- 	</nav>		 -->
<!-- 	<div class = "jumbotron"> -->
<!-- 		<div class = "container"> -->
<!-- 			<h1 class = "display-3">도서 목록</h1> -->
<!-- 		</div> -->
<!-- 	</div> -->
	<div class = "container">
		<div class = "row">
			<div class = "col-md-4">
<%-- 				<c:choose> --%>
<%-- 					<c:when test="${book.getFileName() == null}"> --%>
<%-- 						<img src="/SpringBookMarket/resources/images/${book.getBookId()}.png" style="width:100%" alt="${book.getBookId()}.png" /> --%>
<%-- 					</c:when> --%>
<%-- 					<c:otherwise> --%>
						<img src="/SpringBookMarket/resources/images/${book.getFileName()}" style="width:100%" alt="${book.getBookImage().getOriginalFilename()}" />
<%-- 					</c:otherwise> --%>
<%-- 				</c:choose> --%>
			</div>
			<div class="col-md-8">
				<h3>${book.name}</h3>
				<p>${book.description}</p>
				<br>
				<p> <b>도서코드 : </b><span class = "badge badge-info">${book.bookId}</span></p>
				<p> <b>저자</b> : ${book.author}</p>
				<p> <b>출판사</b> : ${book.publisher}</p>
				<p> <b>출판일</b> : ${book.releaseDate}</p>
				<p> <b>분류</b> : ${book.category}</p>
				<p> <b>재고수</b> : ${book.unitsInStock}</p>
				<h4>${book.unitPrice}원</h4>
				<br>
				<p></p>
				<form:form name="addForm" method="post">
					<input type="hidden" name="_method" value="put" />
					<% Book book = (Book)request.getAttribute("book");
						System.out.println(book.getBookId());%>
					<p>
						<a href="javascript:addToCart('../cart/add/${book.bookId}')" class = "btn btn-primary" id = "order">도서주문 &raquo;</a>
						<a href="<c:url value="/cart/"/>" class = "btn btn-warning">장바구니 &raquo;</a>
						<a href="<c:url value="/books/"/>" class = "btn btn-secondary">도서목록 &raquo;</a>
<%-- 					<sec:authorize access="isAuthenticated()"> --%>
							<a href="/SpringBookMarket/books/update?id=${book.bookId}" class="btn btn-success">수정 &raquo;</a>
<%-- 					</sec:authorize> --%>
						<a href="javascript:deleteConfirm('${book.bookId}')" class="btn btn-danger">삭제 &raquo;</a>
					</p>
				</form:form>
			</div>
		</div>
<!-- 		<footer> -->
<!-- 			<p>&#169; BookMarket</p> -->
<!-- 		</footer> -->
	</div>
</body>
</html>