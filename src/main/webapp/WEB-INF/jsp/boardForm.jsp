<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp"></jsp:include>
<%
String msg = (String) request.getAttribute("ErrorMsg");
String logId = (String) session.getAttribute("loginId");
%>

<c:if test="${ErrorMsg!=null}">
<p>메세지: <b>${ErrorMsg}</b></p>
</c:if>

<form action="addBoard.do">
	<h3>게시글 등록</h3>
	<table class="table">
		<tr>
			<th>제목</th>
			<td><input type="text" name="title"></td>
		</tr>
		<tr>
			<th>작성자</th>			
			<td>
			<c:choose>
				<c:when test="${logindId}">
				<input type="text" readonly name="writer" >
				</c:when>
				<c:otherwise>
				<input type="text" readonly name="writer" value="${loginId }">
				</c:otherwise>
			</c:choose>
			</td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea name="content" cols="30" rows="10"></textarea></td>
		</tr>
		<tr>
			<td colspan="2">
			<c:choose>
			<c:when test="${loginId==null }">
				<input type="submit" value="저장" disabled>
			</c:when>
			<c:otherwise>
				<input type="submit" value="저장">
			</c:otherwise>
			</c:choose>
				<input type="reset" value="초기화">
				
			</td>
		</tr>
	</table>
</form>
<br>
<a href="boardList.do">목록으로</a>
<jsp:include page="footer.jsp"></jsp:include>