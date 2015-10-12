<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="../resources/css/main.css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-1.11.3.min.js"></script>
	<title>Insert title here</title>
	<script type="text/javascript">
		/* function search() {
			var friendlistwrapper = document.querySelector("#friendlistwrapper");
			var friendlistwrapper2 = document.querySelector("#friendlistwrapper2");
			var friendlistwrapper3 = document.querySelector("#friendlistwrapper3");
			friendlistwrapper.style.visibility="hidden";
			friendlistwrapper.style.float="left";
			friendlistwrapper2.style.visibility="visible";	
			friendlistwrapper2.style.float="right";
			friendlistwrapper3.style.visibility="hidden";
			friendlistwrapper3.style.float="left";	
		} */
	</script>
</head>
<body>
	<div id="friendlistwrapper">
		<div id="top">
			<div  id="title">이웃나무</div>
			<div id="search"><a href="friendlistwrapper2"><img src="../resources/images/search.png" ></a></div>
			<div id="delete"><img src="../resources/images/x.png" ></div>						
		</div>
		<div id="mid">
			<div id="list">
						정도영 < aikuna@naver.com ><br>
						장희원 < emark@naver.com ><br>
						윤성현 < cartoon@naver.com ><br>
						김예지 < yjkim@naver.com><br>
			</div>
		</div>
		<div id="bottom">
			<div id="request"><a href="friendlistwrapper4">뿌리추가 요청 [2]건</a></div>
		</div>
	</div>
</body>
</html>