<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../header.jsp"></jsp:include>

<form action="addMember.do" method="post" enctype="multipart/form-data"> <!-- application/x-www-form-urlencoded -->
	<table  class="table">
		<tr>
			<th>아이디</th>
			<td><input type="text" name ="uid"></td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><input type="password" name ="upw"></td>
		</tr>
		<tr>
			<th>이름</th>
			<td><input type="text" name ="uname"></td>
		</tr>
		<tr>
			<th>생일</th>
			<td><input type="date" name ="ubirth"></td>
		</tr>
		<tr>
			<th>사진</th>
			<td><input type="file" name ="img"></td>
		</tr>
		<tr>

			<td colspan = "2" align="center">
			<input type="submit" value = "등록">
			<input type="reset" value = "초기화">	
			</td>
		</tr>													
	</table>
</form>
<jsp:include page="../footer.jsp"></jsp:include>