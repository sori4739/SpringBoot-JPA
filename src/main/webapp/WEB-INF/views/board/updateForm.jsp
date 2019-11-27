<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>

 


	<form:form action="/board/update" method="PUT">
		<input type="hidden" name="id" value="${board.id}">
		<table>
			<tr>
				<th>Title</th>
				<td><input type="text" value="${board.title}" name="title" /></td>
			</tr>
			<tr>
				<th>Content</th>
				<td><textarea row="5" cols="40" name="content">${board.content}</textarea></td>	
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="글쓰기 완료"/></td>
			</tr>
		</table>
	</form:form>
</body>
</html>