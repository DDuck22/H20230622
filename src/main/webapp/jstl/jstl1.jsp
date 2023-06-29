<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="my"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% String amsg = "Hello,World"; %>
<% out.println(amsg );%>
	<my:set value="Hello, World" var="msg"></my:set>
	<my:out  value="${msg }"></my:out>
	<my:out value="${loginId }"></my:out>
</body>
</html>