<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="resources/css/main2.css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-1.11.3.min.js"></script>
	<script type="text/javascript">
	//이벤트 연결
		window.onload = function() {
		// 문서 객체 선택
			var clock = document.getElementById('clock');
			
			//1초마다 함수 실행
			setInterval(function() {
				var now = new Date();
				var nowall = now.getFullYear() + "." + 
				(now.getMonth()+1) + "." + now.getDate() + "  " +
				now.getHours() + ":" + 
				now.getMinutes() + ":" + now.getSeconds() + " ";
				
				clock.innerHTML = nowall.toString();
			}, 1000);	
		};
	</script>
</head>
<body>


	
	<div id="wrapper2"> 
		
		<div id="content3">
		
		</div>
		
		<div id="content4" >
			<div id="content4-1">
				<div id="logo2"><img src="resources/images/capsule1.png" alt="Capsule" height="130px"></div>
				<div id="noticetext">
					<div id="noticetext-1"><a href="list">공지사항</a></div>
					<div id="noticetext-2">공지사항 내용</div>
				</div>
				<div id="timecapsuletext">타입캡슐</div>
				<div id="timecasuleimg" onclick="timecapsuleform"><img src="resources/images/send.png" alt="SendTimeCapsule"></div>		
			</div>
		</div>
		
		<div id="content5">
			<div id="capsulebox1"><img src="resources/images/capsulebox.png" alt="capsulebox" height="150px"></div>
		</div>
		<div id="content6">
			<div id="capsulebox1"><a href="bottomlogobox2"  target="bottomlogobox"><img src="resources/images/capsulebox.png" alt="capsulebox" height="150px"></a></div>
			<div id="capsulelist">
				<form>
					<select>
						<option>전체보기</option>
						<option>친구보기</option>
						<option>나만보기</option>
					</select>
				</form>
			</div>
		</div>
		<div id="content7">
			<div id="capsulebox1"><img src="resources/images/capsulebox.png" alt="capsulebox" height="150px"></div>
		</div>
	</div>
	
	
	<iframe id="bottomlogobox" src="sub/bottomlogobox" name="bottomlogobox"></iframe>
	
	
</body>
</html>