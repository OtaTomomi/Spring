<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="false" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新規投稿画面</title>
</head>
<body>
	<form:form modelAttribute="messageForm">
	<div><form:errors path = "*" /></div>
		<form:label path="subject">件名</form:label>
		<form:input path="subject" size="50" />
		<br />

		<form:label path="text">本文</form:label>
		<form:textarea path="text" cols="50" row="20" />
		<br />


		<form:label path="category">カテゴリー</form:label>
		<form:input path="category" size="10" />
		<br />


<%-- 		<form:label path="userId">ユーザーID(数値)(仮設)</form:label> --%>
<%-- 		<form:input path="userId" size="5" /> --%>
<!-- 		<br /> -->

		<input type="submit" />
	</form:form>

</body>
</html>