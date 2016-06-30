<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="false" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>編集画面</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/user/">ユーザー一覧画面へ</a>
	<h2>${message }</h2>
	<form:form modelAttribute="userForm">
	<div><form:errors path="*"></form:errors></div>
	<p>ログインID：<form:input path="loginId"/></p>
	<p>名称：<form:input path="name"/></p>
	<p>パスワード：<form:input path="password" type = "password"/></p>
	<p>支店ID	<form:select path="branchId" items="${branches}" itemLabel="name"  itemValue="id"></form:select>

	</p>
	<p>役職部署ID：	<form:select path="positionId" items="${positions}" itemLabel="name"  itemValue="id"></form:select>
	</p>
	<input type="submit"/>


	</form:form>


</body>
</html>