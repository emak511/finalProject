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
		@import url(http://fonts.googleapis.com/earlyaccess/nanumgothic.css);
			body{
				margin: 0px;
				padding: 0px;
				font-family: 'Nanum Gothic', sans-serif;
				color:black;
			}
			
			#contentBox{
				width:500px;
				height:300px;
				resize:none;
			}
		</style>
		
	</head>
	<body>
		<h4>다이어리 작성</h4>
		<form method="post" action="writeDiary">
			<div>
				<input type="text" name="title" placeholder="제목" required/>
			</div>
			<div>
				<textarea id="contentBox" name="content" placeholder="내용" required></textarea>
			</div>
			<div>
				<select name="type">
					<option value="all">전체보기</option>
					<option value="group">친구보기</option>
					<option value="only">나만보기</option>
				</select>
			</div>
			<input type="hidden" name="memberEmail" value="ysh@naver.com"/>
			<div>
				<input type="submit" value="다이어리 올리기"/>
				<input type="reset" value="다시작성"/>					
			</div>
		</form>
		
	</body>
</html>