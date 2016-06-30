<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ホーム画面</title>
</head>

<body>
<a href="${pageContext.request.contextPath}/post/">新規投稿画面へ</a><br />
<a href="${pageContext.request.contextPath}/user/">ユーザー管理画面へ</a><br />
	<h2>投稿一覧</h2>
	<c:forEach items="${userMessages }" var="userMessage">
		<div class="table">
			<table border = "1">
				<tr>
					<td>件名：<c:out value="${userMessage.subject}" /></td>
				</tr>
				<tr>
					<td><c:out value="${userMessage.text}"></c:out></td>
				</tr>
				<tr>
					<td>投稿者：<c:out value="${userMessage.userName}" /> 投稿日時：<c:out
							value="${userMessage.insertDate}" /> カテゴリー：<c:out
							value="${ userMessage.category}" />
					</td>
				</tr>
				<c:forEach items="${userComments}" var="userComment">
					<c:if test="${userMessage.id == userComment.messageId }">
						<tr>
							<td>コメント：<c:out value="${userComment.commentText }" />
							投稿者：<c:out value = "${userComment.commentName }" />
				投稿日時：<c:out value = "${userComment.commentInsertDate }" /></td>
						</tr>
					</c:if>
				</c:forEach>

			</table>
		</div>
			<br />

	</c:forEach>

</body>
</html>