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
			
			h4{
				margin-left:55px;
			}
			
			h1{
				margin-left:80px;
				margin-top:30px;
			}
			
			#back a{
				position:absolute;
				margin-left:110px;
				margin-top:-17px;
				text-decoration:none;
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
		</style>

	</head>
	<body>
		<h1>회원가입</h1>
		<form method="post" action="add" >
			<h4><input type="email" name="memberEmail" size="20" placeholder="Email" style="height: 20px;" required></h4>
			<h4><input type="text" name="memberName" size="20" placeholder="Name" style="height: 20px;" required></h4>
			<h4><input type="password" name="memberPW" size="20" placeholder="Password" style="height: 20px;" required></h4>
			<div id="back">
				<a href="log?result=">돌아가기</a>
			</div>
			<input id="sub" type="submit" value="등록하기">
		</form>
		
		<c:if test="${check=='Fail'}">
			<script type="text/javascript">
		    	alert("중복 이메일 입니다.");
		    </script>
		</c:if>
		
		<c:if test="${check=='ErrorPW'}">
			<script type="text/javascript">
		    	alert("비밀번호는 6자리 이상 입력해야 합니다.");
		    </script>
		</c:if>
		
	</body>
</html>