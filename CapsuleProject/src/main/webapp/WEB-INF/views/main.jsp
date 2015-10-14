<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="resources/css/main.css">
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
		
		
		
		function search2() {
			var friendlistwrapper = document.querySelector("#friendlistwrapper");
			var friendlistwrapper2 = document.querySelector("#friendlistwrapper2");
			var friendlistwrapper3 = document.querySelector("#friendlistwrapper3");
			friendlistwrapper.style.visibility="hidden";
			friendlistwrapper.style.float="left";
			friendlistwrapper2.style.visibility="hidden";
			friendlistwrapper2.style.float="left";
			friendlistwrapper3.style.visibility="visible";
			friendlistwrapper3.style.float="right";			
		}
		
		function left() {
			var friendlistwrapper = document.querySelector("#friendlistwrapper");
			var friendlistwrapper3 = document.querySelector("#friendlistwrapper2");
			var friendlistwrapper3 = document.querySelector("#friendlistwrapper3");
			friendlistwrapper.style.visibility="visible";
			friendlistwrapper.style.float="right";
			friendlistwrapper2.style.visibility="hidden";
			friendlistwrapper2.style.float="left";
			friendlistwrapper3.style.visibility="hidden";
			friendlistwrapper3.style.float="left";	
		}
		
		function modifymenu(){
			var modify = document.querySelector("#modifymenu");
			modify.style.backgroundcolor="#d5cc49";
		}

		function deletemember() {
			var deletemember = document.querySelector("#deletemember");
			var modify = document.querySelector("#modify");
			var modifyinfo = document.querySelector("#modifyinfo");
			deletemember.style.visibility="visible";
			modify.style.visibility="hidden";
			modifyinfo.style.visibility="hidden";
		} 
		function timecapsuleform() {
			var timecapsuleform = document.querySelector("#deletemember");
			
		}
	
	</script>
	<style type="text/css">
	 #modify {
	 	background-image: url(resources/images/erer.png);
	 }
	</style>
</head>
<body>
	
	
		<div id="wrapper">
		<div id="content1">
			<div id="logo"><img src="resources/images/capsule1.png" alt="Capsule" width=80px;></div>
			<div id="mainNote"><img src="resources/images/mainNote.png" alt="OurTime" height= 70px;></div>
			<div id="Hashtag">#자소서 #중간고사 #메르스 #가을자켓</div>
			<div id="tree"><img src="resources/images/gggggg.png" alt="Mytree"></div>
			<div id="modify" >
				<div id="nameLabel">정도영</div>
			</div>
			<div id="modifyinfo">
				<div id="modifygo">정보수정</div>
				<div id="deletemember" onclick="deletemember()">회원탈퇴</div>
			</div>
			<div id="deletetree">
				<div id="deletetext">정도영님 <br />정말 나무를 파기하시겠습니까?</div>
				<div id="deletebutton"><center><img src="resources/images/ok.png" alt="Mytree" width="50px"><img src="resources/images/minus.png" alt="Mytree" width="50px"></center></div>
			</div>
		</div>
	

		<div id="content2">
			<div id="timewrapper">
				<div id="clock">
					<script type="text/javascript">
					</script>
				</div>
				<div id="gobottom"><a href="#write"><img src="resources/images/diary.png" height="30px;" ></a></div>
			</div>
			<iframe id="friend" src="sub/friendlistwrapper" ></iframe>	
		</div>
	</div>
	

</body>
</html>