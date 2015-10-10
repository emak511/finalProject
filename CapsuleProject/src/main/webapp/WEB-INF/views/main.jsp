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
		
		function search() {
			var friendlistwrapper = document.querySelector("#friendlistwrapper");
			var friendlistwrapper2 = document.querySelector("#friendlistwrapper2");
			var friendlistwrapper3 = document.querySelector("#friendlistwrapper3");
			friendlistwrapper.style.visibility="hidden";
			friendlistwrapper.style.float="left";
			friendlistwrapper2.style.visibility="visible";	
			friendlistwrapper2.style.float="right";
			friendlistwrapper3.style.visibility="hidden";
			friendlistwrapper3.style.float="left";
			
		}
		
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

</head>
<body>

	<div id="wrapper">
		<div id="content1">
			<div id="logo"><img src="resources/images/capsule1.png" alt="Capsule"></div>
			<div id="capsuleLogo"><img src="resources/images/write.png" alt="OurTime"></div>
			<div id="tree"><img src="resources/images/tree.png" alt="Mytree"></div>
			<div id="modify" >정도영</div>
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
				
			<div id="friendlistwrapper">
				<iframe id="friend" src="friendlistwrapper">	
					<div id="top">
						<div  id="title"><a href="/notice/list">이웃나무</a></div>
						<div id="search" onclick="search()"><img src="resources/images/search.png" ></div>
						<div id="delete"><img src="resources/images/x.png" ></div>
						
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
						<div id="request">뿌리추가 요청 [2]건</div>
					</div>
				</iframe>
			</div>	
			
			
			
			<div id="friendlistwrapper2">
				<div id="top">
					<div  id="title"><a href="/notice/list">이웃나무찾기</a></div>					
					<div id="leftimg" onclick="left()"><img src="resources/images/left.png"  width="30px"></div>
				</div>
				<div id="mid">
					<div id="list">
						<div>
							
							<input type="text" id="searchemail" /><button onclick="search2()" id="search2">search</button>

						</div>
					</div>
				</div>
				<div id="bottom">
					<div id="request">뿌리추가 요청 [2]건</div>
				</div>
			</div>	
			
			
			
			<div id="friendlistwrapper3">
				<div id="top">
					<div  id="title"><a href="/notice/list">이웃나무찾기2</a></div>					
					<div id="leftimg" onclick="left()"><img src="resources/images/left.png"  width="30px"></div>
				</div>
				<div id="mid">
					<div id="list">
						<div id="innerlist">					
							정도영 < aikuna@naver.com >
								<span id="plus"><img src="resources/images/plus.png" height="20px"></span>
								<span id="minus"><img src="resources/images/minus.png" height="20px"></span>

						</div>
					</div>
				</div>
				<div id="bottom">
					<div id="request">뿌리추가 요청 [2]건</div>
				</div>
			</div>	
			
		
		</div>
	</div>
	
	
	
	
	<div id="wrapper2"> 
		<a name="write"></a>
		<div id="content3">
		
		</div>
		
		<div id="content4" >
			<div id="content4-1">
				<div id="logo2"><img src="resources/images/capsule1.png" alt="Capsule" height="130px"></div>
				<div id="noticetext">
					<div id="noticetext-1">공지사항</div>
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
			<div id="capsulebox1"><img src="resources/images/capsulebox.png" alt="capsulebox" height="150px"></div>
		</div>
		<div id="content7">
			<div id="capsulebox1"><img src="resources/images/capsulebox.png" alt="capsulebox" height="150px"></div>
		</div>
	</div>
	
	
	
	
	<div id="bottomlogobox">
			<div id="bottomlogo"><img src="resources/images/capsule1.png" alt="bottomlogo" ></div>
			<div id="bottomtext"><img src="resources/images/write.png" alt="bottomtext" ></div>
	</div>
		

</body>
</html>