<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>RESTful 웹 서비스</title>
</head>
<body>
	<h3>RESTful 웹 서비스</h3>
	<p><% out.print(new java.util.Date()); %></p>
	<p>${title}</p>
	<p>${result}</p>
</body>
</html>