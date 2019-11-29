<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/admin/update" method="post">
	<input type="hidden" value="${user.id}" name="id"/><br/>
	<input type="hidden" value="${user.password}" name="password"/><br/>
	<input type="hidden" value="${user.phone}" name="phone"/><br/>
	<input type="hidden" value="${user.email}" name="email"/><br/>
	<input type="text" value="${user.username}" name="username" readonly="readonly"/><br/>
	
	<select name = "role">
		<option value="user">user</option>
		<option value="admin">admin</option>
	</select><br/>
	<input type="submit" value="변경"/>
</form>
</body>
</html>