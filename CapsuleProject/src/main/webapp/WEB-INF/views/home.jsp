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
				background-color:rgba(255,255,255,0.5);
				border: none;
				border-radius: 20px;
			}
			
		</style>
	</head>
	<body>
		<div id="member">	
			<iframe src="home_2" name="iframe" height="100%" width="100%" style="border:none;"></iframe>
		</div>
		
		<div>
			<li><a href="diary">다이어리 테스트</a>
		</div>
	</body>
</html>
