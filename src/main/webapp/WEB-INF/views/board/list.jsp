<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리스트</title>
</head>
<body>
<c:forEach var = "board" items= "${boards}">
	${board.id} ${board.title} ${board.content} ${board.createDate} ${board.user.username} ${board.user.email}<br/>
</c:forEach>
</body>
</html>