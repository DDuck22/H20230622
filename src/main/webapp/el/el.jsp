<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setAttribute("msg", "Hello");
	%>

  <h3>Expression Language</h3>
  ${"Hello"}<br>
  ${12.4-3.2 }<br>
  ${10>4 }<br>
  <p>msg : ${msg}</p>
  <p>id : ${loginId }</p>
  <p>name : ${loginName }</p>
  <p>request : ${requestScope }</p>
  <p>session : ${sessionScope }</p>
  <p>${1>0 and 2>1}</p>
  <p>${1 gt 0}</p>
  <p>${1 lt 0}</p>

  <p>${22 eq 10}</p>
  <p>${empty msg}</p>
  <jsp:forward page="../index.jsp"></jsp:forward>
</body>
</html>