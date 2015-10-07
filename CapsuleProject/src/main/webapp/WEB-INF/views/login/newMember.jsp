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
		<h1>MEMBER REGISTER</h1>
		
		<form method="post" action="add" >
			<h4>이메일주소:&nbsp&nbsp<input type="email" name="memberEmail" size="15" required></h4>
			<h4>이름:&nbsp&nbsp<input type="text" name="memberName" size="15" required></h4>
			<h4>PASSWORD:&nbsp&nbsp<input type="password" name="memberPW" size="15" required></h4>
			&nbsp&nbsp&nbsp&nbsp&nbsp<input type="submit" value="REGISTER">
		</form>
		
		<c:if test="${check=='Fail'}">
			<script type="text/javascript">
		    	alert("중복 이메일 입니다.");
		    </script>
		</c:if>
		
	</body>
</html>