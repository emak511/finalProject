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
				/* opacity:0.4; */
				border-radius: 20px;
			}
			
			#capsule {
				width: 200px;
				height: 200px;
				z-index:1;
			}
		/* 	#member logo{
				font-family:'Nanum Gothic', sans-serif;
				color:white;
				margin-left:100px;
				margin-top:80px;
				float:left;
				z-index:10;
				opacity:1;
			} */
			
			/* #member #capsule{
				 display: block;
				 
			} */
			
			#member #menu{
				font-family:'Nanum Gothic', sans-serif;
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
		<div id="capsule">
			<img src="resources/images/capsuleLogo.png" alt="Capsule" width="500" height="500">
		</div>
		
		<div id="note">
			<img src="resources/images/note2.png" alt="OurTime" width="700" >
		</div>
		
		<div id="member">	
			<div id="menu">
				<a href="#">회원가입</a>
			</div>
			<div id="menu">
				<a href="#">로그인</a>
			</div> 
		</div>

		
		<li><a href="main">ORDER</a></li>
	</body>
</html>
