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
			
			h1{
				margin-left:200px;
				margin-top:30px;
			}
			
			h4{
				margin-left:160px;
			}
			

			#sub{
				border: none;
				background-color:#b0ac5e;
				width:100px;
				height:30px;
				border-radius: 5px;
				margin-left:195px;
				margin-top:20px;
			}
			
			#findpass a{
				float:left;
				text-decoration:none;
				margin-left:160px;
				margin-top:10px;
			}
			
			#new a{
				position:absolute;
				margin-left:5px;
				margin-top:10px;
				text-decoration:none;
			}

		</style>
	
	</head>
	<body>
		<h1>로그인</h1>
		<form method="post" action="logcheck" >
			<h4><input type="email" name="memberEmail" size="20" placeholder="Email" style="height: 20px;"></h4>
			<h4><input type="password" name="memberPW" size="20" placeholder="Password" style="height: 20px;"></h4>
			<div id="findpass">
				<a href="findPW?findp=">비밀번호 찾기/</a>
			</div>
			<div id="new">
				<a href="newMember?check=">회원가입</a>
			</div>
			<input id="sub" type="submit" value="LOGIN" formtarget="_parent"> 
		</form>

		<c:if test="${result=='wrongPw'}">
			<script type="text/javascript">
		    	alert("비밀번호를 다시 입력해 주세요.");
		    </script>
		</c:if>
		
		<c:if test="${result=='wrongEmail' }">
			<script type="text/javascript">
		    	alert("유효하지 않은 이메일 입니다.");
		    </script>
		</c:if>
		

	</body>
</html>