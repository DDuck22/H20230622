<%@page import="com.yedam.board.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp"></jsp:include>
	<%
	BoardVO vo = (BoardVO) request.getAttribute("board");
	String loginId = (String) session.getAttribute("loginId");
	%>
	
	<c:choose>
		<c:when test="${board==null }">
			<p>조회된 결과가 없습니다.</p>		
		</c:when>
		<c:otherwise>
		<form name="myFrm" action="modifyForm.do" method="post">
		<input type="hidden" name="bno" value="${board.brdNo}">
		<table class="table">
			<tr>
				<th>제목</th>
				<td><input readonly type="text" name="title"
					value="${board.brdTitle}"></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><input readonly type="text" name="writer"
					value="${board.brdWriter}"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea readonly name="content" cols="30" rows="10">${board.brdContent}</textarea></td>
			</tr>
			<tr>
			<c:choose>
			<c:when test="${loginId != null && loginId.equals(board.brdWriter)}">
				<td colspan="2"><input type="submit" value="수정"> 
				<button type="button">삭제</button></td>			
			</c:when>
			<c:otherwise>
				<td colspan="2"><input type="submit" value="수정" disabled> 
				<button type="button" disabled>삭제</button></td>			
			</c:otherwise>
			</c:choose>
			</tr>
		</table>
	</form>
		</c:otherwise>
	</c:choose>
	
	<a href="boardList.do">목록으로</a>
	<script>
		console.log(this);
		document.querySelector('form[name="myFrm"] button[type="button"]').addEventListener(
				'click', function(e) {
					console.log(e);
					document.forms.myFrm.action = "boardRemove.do";
					document.forms.myFrm.submit();

				});
	</script>
<jsp:include page="footer.jsp"></jsp:include>