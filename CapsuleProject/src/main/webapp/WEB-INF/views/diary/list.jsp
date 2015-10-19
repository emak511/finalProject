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
				margin-top:50px;
			}
			
			#diaryleft:hover{
				opacity:0.5;
				cursor:pointer;
			}
			
			#diaryright{
				position:absolute;
				margin-left:450px;
				margin-top:50px;
			}
			
			#diaryright:hover{
				opacity:0.5;
				cursor:pointer;
			}
			
			#diaryBox li{
				list-style:none;
			}

			
		</style>
	</head>
	
	<body>
		<section>
			<div id="diaryBox">
				<c:forEach var="diary" items="${list}" >
					<li>${diary.diaryTitle }</li>
					<li>${memberEmail }</li>
					<li>${diary.diaryDate }</li>
					<li>${diary.diaryContent }</li>	
				</c:forEach>
			</div>
			
			<div id="pager">
				<c:if test="${pageNo>1 }">
					<a href="list?pageNo=${pageNo-1 }&diary_c1=${diary_c1}&diary_c3=${diary_c3}&memberEmail=${memberEmail}">
						<img id="diaryleft" src="../resources/images/diaryleft.png" width="40px"/>
					</a>
				</c:if>
				
				<c:if test="${pageNo<totalPageNo }">
					<a href="list?pageNo=${pageNo+1 }&diary_c1=${diary_c1}&diary_c3=${diary_c3}&memberEmail=${memberEmail}">
						<img id="diaryright" src="../resources/images/diaryright.png" width="40px"/>
					</a>
				</c:if>
			</div>
			
		</section>

		<div id="buttonGroup">
			<a href="writeForm">다이어리 작성</a>
			<a href="updateForm?diary_dno=9">수정하기</a>
			<a href="delete?diary_dno=6">삭제하기</a>
		</div>
	</body>
</html>

