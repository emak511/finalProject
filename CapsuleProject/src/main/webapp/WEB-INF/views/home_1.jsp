<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
	<head>
		<meta charset=UTF-8">
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
				background-color:white;
				border: none;
				opacity:0.2;
				border-radius: 20px;
			}
			
		
			a{
				color:white;
				text-decoration:none;
			} 
			
		</style>
	</head>
	<body>
		<div id="member">	
			<iframe src="home_2" name="iframe" height="100%" width="100%" style="border:none;"></iframe>
		</div>

		<li><a href="main">ORDER</a></li>
		<li><a href="home_1">홈</a></li>
	</body>
</html>
