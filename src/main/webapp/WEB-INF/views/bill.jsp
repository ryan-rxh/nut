<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Dash</title>
</head>
<body>
	<form action=""></form>
	<table>
		<thead>
			<tr><td>ID</td><td>用户</td><td>创建时间</td></tr>
		</thead>
		<tbody>
			<c:forEach var="bill" items="${bills}">
				<tr>
					<td><a href="<c:url value="/bill/listLineItems-${bill.id}"/>">${bill.id}</a></td>
					<td>${bill.user.userId}</td>
					<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${bill.createDate}" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>