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
			
			#diaryBox{
				width:500px;
				height:300px;
				border:1px solid black;
			
			}
		</style>
	</head>
	
	<body>

		<section>
			<div id="diaryBox">
				<div>
				<img src="resources/images/Left.png" width="50px"/>
				</div>
				<div>
				<img src="resources/images/right.png" width="50px"/>
				</div>
				<c:forEach var="diary" items="${list}">
					<li>${diary.diaryTitle }</li>
					<li>${diary.diaryDate }</li>
					<li>${diary.diaryContent }</li>	
				</c:forEach>
			
			</div>
		</section>


		<div id="buttonGroup">
			<a href="writeForm">다이어리 작성</a>
			<a href="updateForm?diary_dno=9">수정하기</a>
			<a href="delete?diary_dno=6">삭제하기</a>
		</div>
	</body>
</html>

