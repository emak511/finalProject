<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
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
				color:black;
			}
			
			#capsule{
				display: block; 
				margin-left: 190px;
				margin-top:10px;
			}
			
			
			#note{
				display:block;
				margin-top:5px;
				margin-left:20px;
			}
			
			#login{
				display:block;
				margin-left:180px;
				margin-top:25px;
			}
			
			#login a img:hover{
				opacity:0.7;
			}
			
			#Join{
				display:block;
				margin-left:180px;
				margin-top:10px;
			}
			
			#Join a img:hover{
				opacity:0.7;
			}
		</style>
		
		<script type="text/javascript">
			function changeDiv(width, height){
				var div=parent.document.querySelector("#member");
				div.style.width=width+"px";
				div.style.height=height+"px";
				
			}
			
		</script>
	</head>
	<body>
		<div id="capsule">
			<img src="resources/images/capsule1.png" alt="Capsule" width="100px" height="100px"/>
		</div>
		
		<div id="note">
			<img src="resources/images/write.png" alt="OurTime" width="450px"/>
		</div>
		
		<div id="login">
			<a href="login/log" onclick="changeDiv(280,300);">
				<img src="resources/images/login.png" alt="Login"/>
			</a>
		</div>
		
		<div id="Join" >
			<a href="login/newMember" onclick="changeDiv(280,300);">
				<img src="resources/images/newmember.png" alt="Join"/>
			</a>
		</div>
	</body>
</html>