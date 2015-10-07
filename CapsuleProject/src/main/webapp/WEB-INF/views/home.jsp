<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
	<head>

		<title>Capsule</title>
		<style type="text/css">
		@import url(http://fonts.googleapis.com/earlyaccess/nanumgothic.css);
			*{
				margin: 0px;
				padding: 0px;
			}
			body{
				background-image: url(resources/images/main6.jpg);
				background-size: 100% 100%;
			}
			
			#member{
				margin: 0 auto;
				margin-top: 25%;
				width:500px;
				height:300px;
				z-index:1;
				background-color:black;
				border: none;
				opacity:0.4;
				border-radius: 20px;
			}
			
			#member h1{
				font-family:'Nanum Gothic', sans-serif;
				color:white;
				margin-left:100px;
				margin-top:80px;
				float:left;
				z-index:10;
				opacity:1;
			}
			
			#member #menu{
				background-color:green;
				width:200px;
				height:30px;
				margin:10px;
				border-radius: 10px;
				float:left;
				text-align:center;
				padding-top:10px;
				margin-top:100px;
				
			}
			a{
				color:white;
				text-decoration:none;
			}
		</style>
	</head>
	<body>
		<div id="member">
			<h1>너와 나의 시간을 담다</h1>
			<div id="menu">
				<a href="#">이메일로 10초만에 가임</a>
			</div>
			<div id="menu">
				<a href="#">로그인</a>
			</div> 
		</div>

			
		
		
		<li><a href="main">ORDER</a></li>
	</body>
</html>
