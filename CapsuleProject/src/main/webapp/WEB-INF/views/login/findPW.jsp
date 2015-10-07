<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
	<head>
		<link href='https://fonts.googleapis.com/css?family=Play' rel='stylesheet' type='text/css'>
		<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-1.11.3.min.js"></script>
		
		<meta charset=UTF-8">
		<title>Insert title here</title>
		<style type="text/css">
			body{
				color:white;
				font-family:Play;
			}
			
			h4{
				margin:30px;
			}
			
			h1{
				margin-left: 50px;
				margin-top: 30px;
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
			<h4>이메일주소:&nbsp&nbsp<input type="email" name="memberEmail" size="15" required></h4>
			&nbsp&nbsp&nbsp&nbsp&nbsp<input type="submit" value="확인">
		</form>
		
		<a href="log?result=">돌아가기</a>
		
		
	</body>
</html>