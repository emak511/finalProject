<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
	<head>
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
			
			h1{
				margin-left:45px;
				margin-top:30px;
			}
			
			h4{
				margin-left:40px;
			}
			
			#sub{
				border: none;
				background-color:#b0ac5e;
				width:100px;
				height:30px;
				border-radius: 5px;
				margin-left:88px;
				margin-top:15px;
			}
			
			#sub:hover{
				cursor:pointer;
				opacity:0.7;
			}
			
			#back a{
				margin-left:110px;
				margin-top:50px;
				text-decoration:none;
			}
			#inf{
				width:200px;
				height:70px;
				margin-left:45px;
			
			}
		</style>

	</head>
	<body>
		<h1>비밀번호 찾기</h1>
		
		<c:if test="${findp!=''}">
			<script type="text/javascript">
				alert("메일로보내주기");
		    </script>
		</c:if>
		
		<form method="post" action="find" >
			<h4><input type="email" name="memberEmail" size="25" placeholder="Email" style="height: 20px;" required></h4>
			<div id="inf">
				가입하신 이메일 주소를 입력해주시면 해당 이메일로 비밀번호가 발송됩니다.
			</div>
			<div id="back">
				<a href="log?result=">돌아가기</a>
			</div>
			
			<input id="sub" type="submit" value="확인">
		</form>
		
	</body>
</html>