<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="header.jsp"></jsp:include>
<%
String msg = (String) request.getAttribute("ErrorMsg");
%>
<%
if (msg != null) {
%>
<p>
	메세지: <b><%=msg%></b>
</p>
<%
}
%>
<form action="addBoard.do">
	<h3>게시글 등록</h3>
	<table class="table">
		<tr>
			<th>제목</th>
			<td><input type="text" name="title"></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td><input type="text" name="writer"></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea name="content" cols="30" rows="10"></textarea></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="저장"> <input
				type="reset" value="초기화"></td>
		</tr>
	</table>
</form>
<br>
<a href="boardList.do">목록으로</a>
<jsp:include page="footer.jsp"></jsp:include>