<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">
<title>도서 등록</title>
</head>
<body>
<!-- 	<nav class="navbar navbar-expand navbar-dark bg-dark"> -->
<!-- 		<div class="container"> -->
<!-- 			<div class="navbar-header"> -->
<!-- 				<a class="navbar-brand" href="/SpringBookMarket/home">Home</a> -->
<!-- 			</div> -->
<!-- 		</div> -->
<!-- 	</nav>		 -->
<!-- 	<div class="jumbotron"> -->
<!-- 		<div class="container"> -->
<!-- 			<h1 class="display-3"> 도서등록 -->
<%-- 				<spring:message code="addBook.form.title.label"/> --%>
<!-- 			</h1> -->
<!-- 		</div> -->
<!-- 	</div> -->
	
	<div class="container">
<!-- 		<div class="float-right"> -->
<%-- 			<form:form action="${pageContext.request.contextPath}/logout" method="post"> --%>
<!-- 				<input type="submit" class = "btn btn-success" value="logout"> btn-sm  -->
<%-- 			</form:form> --%>
<!-- 		</div> -->
		
		<div class="float-right" style="padding-right:30px">
			<a href="?language=ko">Korean</a>|<a href="?language=en">English</a>
		</div>
		
		<br><br>
		<form:form modelAttribute="NewBook"
				   action="./add?${_csrf.parameterName}=${_csrf.token}"
				   class = "form-horizontal"
				   enctype="multipart/form-data">
				   
		<fieldset>
		<legend> <!-- ${addTitle} -->
			<spring:message code="addBook.form.subtitle.label"/>
		</legend>
		<div class = "form-group row">
			<label class = "col-sm-2 control-label"> <!-- 도서 ID -->
				<spring:message code="addBook.form.bookId.label"/>
			</label>
			<div class = "col-sm-3">
				<form:input path="bookId" class = "form-control"/>
			</div>
			<div class = "col-sm-6">
				<form:errors path="bookId" class = "text-danger"/>
			</div>
		</div>
		<div class = "form-group row">
			<label class = "col-sm-2 control-label"> <!-- 도서명 -->
				<spring:message code="addBook.form.name.label"/>
			</label>
			<div class = "col-sm-3">
				<form:input path="name" class = "form-control"/>
			</div>
			<div class = "col-sm-6">
				<form:errors path="name" class = "text-danger"/>
			</div>
		</div>
		<div class = "form-group row">
			<label class = "col-sm-2 control-label"> <!-- 가격 -->
				<spring:message code="addBook.form.unitPrice.label"/></label>
			<div class = "col-sm-3">
				<form:input path="unitPrice" class = "form-control"/>
			</div>
			<div class = "col-sm-6">
				<form:errors path="unitPrice" class = "text-danger"/>
			</div>
		</div>
		<div class = "form-group row">
			<label class = "col-sm-2 control-label"> <!-- 저자 -->
				<spring:message code="addBook.form.author.label"/></label>
			<div class = "col-sm-3">
				<form:input path="author" class = "form-control"/>
			</div>
		</div>
		<div class = "form-group row">
			<label class = "col-sm-2 control-label"> <!-- 상세정보 -->
				<spring:message code="addBook.form.description.label"/></label>
			<div class = "col-sm-3">
				<form:textarea path="description" cols = "50" rows = "2" class = "form-control"/>
			</div>
		</div>
		<div class = "form-group row">
			<label class = "col-sm-2 control-label"><!-- 출판사 -->
				<spring:message code="addBook.form.publisher.label"/></label>
			<div class = "col-sm-3">
				<form:input path="publisher" class = "form-control"/>
			</div>
		</div>
		<div class = "form-group row">
			<label class = "col-sm-2 control-label"><!-- 분야 -->
				<spring:message code="addBook.form.category.label"/></label>
			<div class = "col-sm-3">
				<form:input path="category" class = "form-control"/>
			</div>
		</div>
		<div class = "form-group row">
			<label class = "col-sm-2 control-label"><!-- 재고수 -->
				<spring:message code="addBook.form.unitsInStock.label"/></label>
			<div class = "col-sm-3">
				<form:input path="unitsInStock" class = "form-control"/>
			</div>
			<div class = "col-sm-6">
				<form:errors path="unitsInStock" class = "text-danger"/>
			</div>
			
		</div>
		<div class = "form-group row">
			<label class = "col-sm-2 control-label"><!-- 출판일 -->
				<spring:message code="addBook.form.releaseDate.label"/></label>
			<div class = "col-sm-3">
				<form:input path="releaseDate" class = "form-control"/>
			</div>
		</div>
		<div class = "form-group row">
			<label class = "col-sm-2 control-label"><!-- 상태 -->
				<spring:message code="addBook.form.condition.label"/></label>
			<div class = "col-sm-3">
				<form:radiobutton path="condition" value = "New"/>New
				<form:radiobutton path="condition" value = "Old"/>Old
				<form:radiobutton path="condition" value = "E-Book"/>E-Book
			</div>
		</div>
		<div class = "form-group row">
			<label class = "col-sm-2 control-label"><!-- 도서이미지 -->
				<spring:message code="addBook.form.bookImage.label"/></label>
			<div class = "col-sm-7">
				<form:input path="bookImage" type="file" class = "form-control"/>
			</div>
		</div>
		<div class = "form-group row">
			<div class = "col-sm-offset-2 col-sm-10">
				<!-- 등록 -->
				<input type = "submit" value="<spring:message code="addBook.form.button.label"/>" class = "btn btn-primary"/>
			</div>
		</div>
		</fieldset>
		</form:form>
		<hr>
<!-- 		<footer> -->
<!-- 			<p>&#169; BookMarket</p> -->
<!-- 		</footer> -->
	</div>
</body>
</html>