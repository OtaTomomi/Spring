<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<%@ page session="false"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script src="http://code.jquery.com/jquery-3.0.0.min.js"></script>
	<script>
		function TimeChenger(date) {

			var insertDate = Date.parse(date) / 1000;
			today = Math.ceil(new Date() / 1000);
			relativeTime = today - insertDate;
			if (relativeTime < 5) {
				// 					var msg = "たった今";
				// 					return msg;
				return document.write("たった今");
			}
			if (5 <= relativeTime && relativeTime < 60) {
				/* var msg = "約" + relativeTime + "秒前";
				return msg; */
				return document.write("約" + relativeTime + "秒前");
			}
			if (60 <= relativeTime && relativeTime < 3600) {
				var minits = Math.round(relativeTime / 60);
				// 					var msg = "約" + minits + "分前";
				// 					return msg;
				return document.write("約" + minits + "分前");
			}
			if (3600 <= relativeTime && relativeTime < 86400) {
				var hour = Math.round(relativeTime / 3600);
				// 					var msg = "約" + hour + "時間前";
				// 					return msg;
				return document.write("約" + hour + "時間前");

			}
			if (86400 <= relativeTime && relativeTime < 604800) {
				var day = Math.round(relativeTime / 86400);
				// 					var msg = "約" + day + "日前";
				// 					return msg;
				return document.write("約" + day + "日前");
			}
			if (604800 <= relativeTime && relativeTime < 2419200) {
				var week = Math.round(relativeTime / 604800);
				// 					var msg = "約" + week + "週前";
				// 					return msg;
				return document.write("約" + week + "週間前");
			}
			if (2419200 <= relativeTime && relativeTime < 29030400) {
				var month = Math.round(relativeTime / 2419200);
				/* var msg = "約" + month + "月前";
				return msg; */
				return document.write("約" + month + "月前");
			}
			if (29030400 <= relativeTime) {
				var year = Math.round(relativeTime / 29030400);
				/* var msg = "約" + year + "年前";
				return msg; */
				return document.write("約" + year + "年前");
			}
		}
		function Hello(id) {
			if (id % 2 == 0) {
				return document.write("こんにちは");
			} else {
				return document.write("konnnichiha");
			}
		}
	</script>


	<table border="1">

		<tr>
			<th><c:out value="${userMessage.subject }"></c:out></th>
		</tr>
		<tr>
			<td><c:out value="${userMessage.text }"></c:out></td>
		</tr>
		<tr>
			<td>カテゴリー</td>
		</tr>
		<tr>
			<td>投稿者：<c:out value="${userMessage.userName }"></c:out>
				&emsp;投稿時間：<script>
					TimeChenger("<fmt:formatDate value = "${ userMessage.insertDate }" pattern = "yyyy-MM-dd HH:mm:ss"/>");
				</script> &emsp;
			</td>
		</tr>
		<c:forEach items="${ userComments }" var="userComment">
			<tr>
				<td><c:out value="${userComment.commentText }"></c:out></td>
			</tr>
			<tr>
				<td><c:out value="${userComment.commentName }"></c:out> <script>
					TimeChenger("<fmt:formatDate value = "${ userComment.commentInsertDate }" pattern = "yyyy-MM-dd HH:mm:ss"/>");
				</script>
				 <form:form modelAttribute="commentForm">
						<c:if test="${loginUser.positionId ==2 }">
							<input type="submit" value="コメント削除">
							<input type="hidden" name="commentForm.id" value="${userComment.commentId }">
						</c:if>
				</form:form></td>
			</tr>

		</c:forEach>
		<tr>
			<td><form:form modelAttribute="commentForm"
					path="${userMessage.id}">
						<form:errors path="*" />

					<form:label path="text">コメント</form:label>
					<form:textarea path="text" cols="50" row="20" />

					<br />
					<input type="hidden" name="messageId" value="${userMessage.id}">
					<input type="submit" value = "コメント投稿">
				</form:form></td>
		</tr>





	</table>
	<br />

	<br />
	<a href="${pageContext.request.contextPath}/home/">ホーム画面へ</a>



</body>
</html>