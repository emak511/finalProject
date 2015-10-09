<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
	<head>
		<link href='https://fonts.googleapis.com/css?family=Play' rel='stylesheet' type='text/css'>
		<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-1.11.3.min.js"></script>
		<meta charset=UTF-8">
		<title>Capsule</title>
		<style type="text/css">
			body{
				color:black;
			}
		</style>
	</head>
	
	<body>
		<h4>게시물 목록</h4>
		
		<table>
			<tr>
				<th style="width:80px">날짜</th>
				<th>제목</th>
				<th style="width:80px">내용</th>
			</tr>
			
			<c:forEach var="diary" items="${list}">
				<tr>
					<td>${diary.diaryDate}</td>
					<td>${diary.diaryTitle}</td>
					<td>${diary.diaryContent}</td>
				</tr>
			</c:forEach>
		</table>

		<div id="buttonGroup">
			<a href="write">글쓰기</a>
			<a href="updateForm?diary_dno=1">수정하기</a>
			<a href="delete">삭제하기</a>
		</div>
	</body>
</html>

