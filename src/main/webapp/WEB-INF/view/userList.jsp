<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ユーザー管理画面</title>
</head>
<body>
	<a href="${pageContext.request.contextPath}/home/">ホーム画面へ</a>
	<br />
	<a href="${pageContext.request.contextPath}/user/signup/">ユーザー登録画面へ</a>
	<br />
	<h2>ユーザー一覧</h2>

	<c:if test="${ not empty errorMessage  }">
		<c:out value="${errorMessage }" />
		<c:remove var="errorMessage" scope="session" />
	</c:if>

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
				<td><a
					href="${pageContext.request.contextPath}/user/edituser/${user.id}"><c:out
							value="${user.name}"></c:out></a></td>
				<td><c:forEach items="${branches }" var="branch">
						<c:if test="${user.branchId == branch.id }">
							<c:out value="${branch.name }"></c:out>
						</c:if>
					</c:forEach></td>
				<td><c:forEach items="${positions}" var="position">
						<c:if test="${user.positionId == position.id  }">
							<c:out value="${position.name}"></c:out>
						</c:if>
					</c:forEach></td>
				<td><c:out value="${user.useable }"></c:out></td>
				<td><form:form modelAttribute="userForm">
						<input type="hidden" name="id" value="${user.id }" />
						<c:if test="${loginUser.id !=user.id }">
							<input type="submit" value="削除">
						</c:if>
						<c:if test="${loginUser.id ==user.id }">
							<input type="submit" value="削除" disabled="disabled">
						</c:if>
					</form:form></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>