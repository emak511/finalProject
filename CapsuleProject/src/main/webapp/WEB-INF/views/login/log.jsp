<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
	<head>
		<link href='https://fonts.googleapis.com/css?family=Play' rel='stylesheet' type='text/css'>
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
			#new{
				margin: 30px;
			}
			
			h1{
				margin: 30px;
			}
		</style>
		
		<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-1.11.3.min.js"></script>
	    <script type="text/javascript">
	    	
		</script>
	</head>
	<body>
		<h1>로그인</h1>
		<form method="post" action="logcheck" >
			<h4>EMAIL:&nbsp&nbsp<input type="email" name="memberEmail" size="15" ></h4>
			<h4>PASSWORD:&nbsp&nbsp<input type="password" name="memberPW" size="15" ></h4>
			&nbsp&nbsp&nbsp&nbsp&nbsp<input type="submit" value="LOGIN">
		</form>
		<div id="new">
			<a href="newMember?check="><button>NEW</button></a>
		</div>
		
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