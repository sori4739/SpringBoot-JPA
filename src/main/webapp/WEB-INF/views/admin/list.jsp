<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 페이지</title>
</head>
<body>
	<h1>관리자 페이지는 role이 admin인 주체만 들어올 수 있다.</h1>
	<table border="1">
		<tr>
			<td>USERNAME</td>
			<td>EMAIL</td>
			<td>ROLE</td>
		</tr>
		<c:forEach var="user" items="${users}">
			<tr>
				<td><a href="/admin/user/${user.id}">${user.username}</a></td>
				<td>${user.email}</td>
				<td>${user.role}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>