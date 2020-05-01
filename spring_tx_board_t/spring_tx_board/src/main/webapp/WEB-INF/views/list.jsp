<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>List.jsp</h2>
<table width="500" border="1" cellpadding="0"
 cellspacing="0">
	<tr>
		<td>번호</td>
		<td>이름</td>
		<td>제목</td>
		<td>날자</td>
		<td>히트</td>	
	</tr>
	<c:forEach items="${list }" var="dto">
		<tr>
			<td>${dto.bid }</td>
			<td>${dto.bname }</td>
			<td>
			<c:forEach begin="1" end="${dto.bindent }">-</c:forEach>
			${dto.btitle }
			</td>
			<td>${dto.bdate }</td>
			<td>${dto.bhit }</td>	
		</tr>
	</c:forEach>

</table>

</body>
</html>