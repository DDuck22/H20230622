<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:import url="jstl1.jsp"></c:import>
<c:if test="${30>200 }">
	<p>true</p>
</c:if>

<c:set var="score" value="50"></c:set>
<c:out value="${score}"></c:out>

<c:choose>
	<c:when test="${score>20 }">
	 <p>30은 20보다큼</p>
	</c:when>
	<c:otherwise>
	 <p>false</p>
	</c:otherwise>
</c:choose>

<c:set var = "mathScore" value = "80"></c:set>

<c:choose>
	<c:when test="${mathScore>90}">
	<p>aa</p>
	</c:when> 
</c:choose>

<c:choose>
<c:when test="${!empty logId }">
<p></p>
</c:when>
</c:choose>

</body>
</html>