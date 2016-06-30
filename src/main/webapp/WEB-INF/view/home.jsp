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
<title>ホーム画面</title>
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



	<a href="${pageContext.request.contextPath}/home/post/">新規投稿画面へ</a>
	<br />
	<a href="${pageContext.request.contextPath}/user/">ユーザー管理画面へ</a>
	<br />
	<a href="${pageContext.request.contextPath}/logout/">ログアウト</a>
	<br />
	<br /> ログイン中のユーザー：${loginUser.name}さん
	<br /> 前回ログイン時刻：${ time }
	<br /> ログイン開始時刻：${loginTime }
	<br />


	<h2>投稿一覧</h2>
	<%-- <c:forEach items="${userMessages }" var="userMessage">
		<div class="table">
			<table border="1">
				<tr>
					<td>件名：<c:out value="${userMessage.subject}" /></td>
				</tr>
				<tr>
					<td><c:out value="${userMessage.text}"></c:out> <c:if
							test="${loginUser.positionId == 2 }">
							<form:form modelAttribute="messageForm">
								<input type="submit" value="投稿削除">
								<input type="hidden" name="id" value="${userMessage.id }">
							</form:form>
						</c:if></td>
				</tr>
				<tr>
					<td>投稿者：<c:out value="${userMessage.userName}" /> <script>
						TimeChenger("<fmt:formatDate value = "${ userMessage.insertDate }" pattern = "yyyy-MM-dd HH:mm:ss"/>");
					</script>
						カテゴリー：<c:out value="${ userMessage.category}" />
					</td>
				</tr>
				<c:forEach items="${userComments}" var="userComment">
					<c:if test="${userMessage.id == userComment.messageId }">
						<tr>
							<td>
							コメント：<c:out value="${userComment.commentText }" />
							投稿者：<c:out value="${userComment.commentName }" />
									<script>
										TimeChenger("<fmt:formatDate value = "${ userComment.commentInsertDate}" pattern = "yyyy-MM-dd HH:mm:ss"/>");
									</script>
									<c:if test="${loginUser.positionId ==2 }">
									<form:form modelAttribute="commentForm">
										<input type="submit" value="コメント削除">
										<input type="hidden" name="id"
											value="${userComment.commentId }">
											</form:form>
									</c:if>
								</td>
						</tr>
					</c:if>
				</c:forEach>
				<tr>
					<td><form:form modelAttribute="commentForm"
							path="${userMessage.id}">
							<div class="${userMessage.id}">
								<form:errors path="*" elements=".${userMessage.id}" />
							</div>

							<form:label path="text">コメント</form:label>
							<form:textarea path="text" cols="50" row="20" />

							<br />
							<input type="hidden" name="messageId" value="${userMessage.id}" />
							<input type="submit" />
						</form:form></td>
				</tr>

			</table>
		</div>
		<br />





	</c:forEach> --%>

	<div class="table">
		<table border="1">
			<tr>
				<th>件名</th>
				<th>投稿時間</th>
				<th>投稿者</th>
				<th>カテゴリー</th>
			</tr>
			<c:forEach items="${userMessages }" var="userMessage">
				<tr>
					<td><c:forEach items="${ readLists }" var="readList">
							<c:if test="${ readList.messageId == userMessage.id }">
								<c:if test="${readList.readCheck == 0 }">
									<font color="RED">NEW</font>
								</c:if>
							</c:if>


						</c:forEach> <a
						href="${pageContext.request.contextPath}/home/detiru/${userMessage.id}">
							<c:out value="${userMessage.subject}" />
					</a> <form:form modelAttribute="messageForm">
							<c:if test="${loginUser.positionId == 2 }">
								<input type="hidden" name="id" value="${userMessage.id }">
								<input type="submit" value="投稿削除">
							</c:if>
						</form:form></td>

					<td>
						<!-- <script>
						TimeChenger("<fmt:formatDate value = "${ userMessage.insertDate }" pattern = "yyyy-MM-dd HH:mm:ss"/>");
					</script> --> <fmt:formatDate value="${ userMessage.insertDate }"
							pattern="yyyy/MM/dd HH:mm:ss" />
					</td>
					<td><c:out value="${userMessage.userName}" /></td>
					<td><c:out value="${ userMessage.category}" /></td>
				</tr>
			</c:forEach>

		</table>
	</div>
</body>
</html>