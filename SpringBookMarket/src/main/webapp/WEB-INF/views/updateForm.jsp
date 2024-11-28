<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">
<title>상세정보</title>
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
		<div class="row">
			<div class="col-md-4">
				<img alt="image" src="/SpringBookMarket/resources/images/${book.getFileName()}" style="width:100%">
			</div>
			<div class="col-md-7">
				<form:form modelAttribute="updateBook"
						   action="./update?${_csrf.parameterName}=${_csrf.token}"
						   class = "form-horizontal"
						   enctype="multipart/form-data">
					<fieldset>
						<div class = "form-group row">
							<label class = "col-sm-2 control-label">도서 ID</label>
							<div class = "col-sm-6" style="padding-top:10px">
								<form:input path="bookId" class = "form-control" id="bookId" value="${book.bookId}" type="hidden"/>
								<span class="badge badge-info">${book.bookId}</span>
							</div>
						</div>
						<div class = "form-group row">
							<label class = "col-sm-2 control-label">도서명</label>
							<div class = "col-sm-6">
								<form:input path="name" class = "form-control" value="${book.name}"/>
							</div>
						</div>
						<div class = "form-group row">
							<label class = "col-sm-2 control-label">가격</label>
							<div class = "col-sm-6">
								<form:input path="unitPrice" class = "form-control" value="${book.unitPrice}"/>
							</div>
						</div>
						<div class = "form-group row">
							<label class = "col-sm-2 control-label">저자</label>
							<div class = "col-sm-6">
								<form:input path="author" class = "form-control" value="${book.author}"/>
							</div>
						</div>
						<div class = "form-group row">
							<label class = "col-sm-2 control-label">상세정보</label>
							<div class = "col-sm-10">
								<form:textarea path="description" cols = "50" rows = "2" class = "form-control" value="${book.description}"></form:textarea>
							</div>
						</div>
						<div class = "form-group row">
							<label class = "col-sm-2 control-label">출판사</label>
							<div class = "col-sm-6">
								<form:input path="publisher" class = "form-control" value="${book.publisher}"/>
							</div>
						</div>
						<div class = "form-group row">
							<label class = "col-sm-2 control-label">분야</label>
							<div class = "col-sm-6">
								<form:input path="category" class = "form-control" value="${book.category}"/>
							</div>
						</div>
						<div class = "form-group row">
							<label class = "col-sm-2 control-label">재고수</label>
							<div class = "col-sm-6">
								<form:input path="unitsInStock" class = "form-control" value="${book.unitsInStock}"/>
							</div>			
						</div>
						<div class = "form-group row">
							<label class = "col-sm-2 control-label">출판일</label>
							<div class = "col-sm-6">
								<form:input path="releaseDate" class = "form-control" value="${book.releaseDate}"/>
							</div>
						</div>
						<div class = "form-group row">
							<label class = "col-sm-2 control-label">상태</label>
							<div class = "col-sm-6">
								<form:radiobutton path="condition" value = "New"/>New
								<form:radiobutton path="condition" value = "Old"/>Old
								<form:radiobutton path="condition" value = "E-Book"/>E-Book
							</div>
						</div>
						<div class = "form-group row">
							<label class = "col-sm-2 control-label">도서이미지</label>
							<div class = "col-sm-10">
								<form:input path="bookImage" type="file" class = "form-control"/>
							</div>
						</div>
						<div class = "form-group row">
							<div class = "col-sm-offset-2 col-sm-10">
								<input type = "submit" value="수정" class = "btn btn-primary"/>
								<a href="/SpringBookMarket/books" class="btn btn-primary">취소</a>
							</div>
						</div>
					</fieldset>
				</form:form>
			</div>
		</div>
<!-- 		<footer> -->
<!-- 			<p>&#169; BookMarket</p> -->
<!-- 		</footer> -->
	</div>
</body>
</html>