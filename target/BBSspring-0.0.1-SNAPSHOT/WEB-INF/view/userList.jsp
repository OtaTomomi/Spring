<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ユーザー管理画面</title>
</head>
<body>
	<a href="${pageContext.request.contextPath}/home/">ホーム画面へ</a><br />
	<a href="${pageContext.request.contextPath}/signup/">ユーザー登録画面へ</a>
	<br />
	<h2>ユーザー一覧</h2>
	<table border="1">

			<tr>
				<th>ログインID</th>
				<th>名称</th>
				<th>支店ID</th>
				<th>部署役職ID</th>
				<th>利用可能</th>
				<th>削除</th>
			</tr>
			<c:forEach items="${users }" var="user">
			<tr>
				<td><c:out value="${user.loginId}"></c:out></td>
				<td><a href="${pageContext.request.contextPath}/user/edituser/${user.id}"><c:out value="${user.name}"></c:out></a></td>
				<td><c:out value="${user.branchId }"></c:out></td>
				<td><c:out value="${user.positionId }"></c:out></td>
				<td><c:out value="${user.useable }"></c:out>
			</tr>
		</c:forEach>
	</table>
</body>
</html>