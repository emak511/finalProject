<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset=UTF-8">
		<link href='https://fonts.googleapis.com/css?family=Play' rel='stylesheet' type='text/css'>
		<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-1.11.3.min.js"></script>
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
			
			#diaryleft{
				position:absolute;
				margin-top:120px;
			}
			
			#diaryright{
				position:absolute;
				margin-left:450px;
				margin-top:115px;
			}
			
		</style>
	</head>
	
	<body>
		<img id="diaryleft" src="../resources/images/diaryleft.png" width="40px"/>
		<img id="diaryright" src="../resources/images/diaryright.png" width="40px"/>
		<section>
			<div id="diaryBox">
				<c:forEach var="diary" items="${list}" varStatus="status">
					<c:choose> 
						<c:when test="${status.count==1}">
							<li>${diary.diaryTitle }</li>
							<li>${diary.diaryDate }</li>
							<li>${diary.diaryContent }</li>	
						</c:when>
					</c:choose>
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

