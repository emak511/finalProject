<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html>
	<head>
		<meta charset=UTF-8">
		<title>Capsule</title>
		<style type="text/css">
		@import url(http://fonts.googleapis.com/earlyaccess/nanumgothic.css);
			body{
				margin: 0px;
				padding: 0px;
				font-family: 'Nanum Gothic', sans-serif;
				background-image: url(resources/images/main6.jpg);
				background-size: 100% 100%;
			}
			
			#member{
				margin: 0 auto;
				margin-top: 25%;
				width:500px;
				height:300px;
				background-color:rgba(255,255,255,0.4);
				border: none;
				border-radius: 20px;
			}
			
			#test a{
				color:white;
			}
			
		</style>
	</head>
	<body>
		<div id="member">	
			<iframe id="iframe1" src="home_2" name="iframe" height="100%" width="100%" style="border:none;"></iframe>
		</div>
		
		<div id="test">
			<a href="list?diary_c1=1&diary_c3=0&memberEmail=ysh@naver.com">전체보기</a>
		</div>
		<div id="test">
			<a href="list?diary_c1=0&diary_c3=0&memberEmail=ysh@naver.com">친구만보기</a>
		</div>
		<div id="test">
			<a href="list?diary_c1=0&diary_c3=1&memberEmail=ysh@naver.com">나만보기</a>
		</div>
		
		<div id="test">
			<a href="writeForm">다이어리 쓰기</a>
		</div>
		
	</body>
</html>
