<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ユーザー新規投稿</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/user/">ユーザー一覧画面へ</a>
	<h2>ユーザー新規投稿</h2>

	<form:form modelAttribute="userForm">                     <br />
	<form:label path="loginId">ログインID</form:label>
	<form:input path="loginId"/>                              <br />
	<form:label path="password">パスワード</form:label>
	<form:input path="password" type = "password" />          <br />
	<form:label path="name">名前</form:label>
	<form:input path="name"/>                                 <br />
	<form:label path="branchId">支店ID</form:label>
	<form:input path="branchId"/>                             <br />
	<form:label path="positionId">部署役職ID</form:label>
	<form:input path="positionId"/>                           <br />
	<input type="submit">

	</form:form>

</body>
</html>