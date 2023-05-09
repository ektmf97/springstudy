<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="${contextPath}/resources/js/lib/jquery-3.6.4.min.js"></script>
<script src="${contextPath}/resources/summernote-0.8.18-dist/summernote-lite.min.js"></script>
<script src="${contextPath}/resources/summernote-0.8.18-dist/lang/summernote-ko-KR.min.js"></script>
<link rel="stylesheet" href="${contextPath}/resources/summernote-0.8.18-dist/summernote-lite.min.css">
<style>
	tbody tr:hover {
		background-color: pink;
		cursor: pointer;
	}
</style>
<script>
	function fnDetail(m){
		location.href='${contextPath}/board/detail.do?board_no=' + m;
	}
</script>
</head>
<body>
	<div>
		<a href="${contextPath}/board/write.do">new 글 작성</a>
	</div>
	
	<div>
		<table border="1">
			<thead>
				<tr>
					<td>제목</td>
					<td>작성자</td>
					<td>작성일</td>
				</tr>
			</thead>
			<tbody>
				<c:if test="${empty boardList}">
					<tr>
						<td colspan="3">주인공이 되어 보세요! 반짝반짝</td>
					</tr>
				</c:if>
				<c:if test="${empty boardList}"></c:if>
				<c:forEach items="${boardList}" var="b">
					<tr onclick="fnDetail(${b.board_no})">
						<td>${b.title}</td>
						<td>${b.writer}</td>
						<td>${b.created_at}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>