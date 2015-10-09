<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
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
		
		
		$(function() {
			$("#btn").click(function() {
				$.ajax({
					url: "mainCSS/search.jsp",
					dataType: "html",
					success: function(data){
						console.log(data);
						$("#friendlistwrapper").html(data);
					}
				});
			});
		})
		
	</script>
	<style type="text/css">
	body {
		margin: 0px;
		width:100%;
	}
	#wrapper {
		width:100%;
		height:100%;
		position: absolute;
	}
	#wrapper2 {
		position: relative;
		top: 600px;
	}
	#content1 {
	 	position:absolute;
		width:100%;
		height:300px;
		background-color: #d5cc49;
		z-index: 10;
		
	}
	#content2 {	
		position:relative;
		top: 300px;
		width:100%;
		height:300px;
		background-color: #99d3bb;
		z-index: 1;
	}
	#content3 {
		width:100%;
		height:62px;	
		background-color: #99d3bb;
		background-image: url(resources/images/ground.png);
		z-index: 5;
	}
	#content4 {
		
		width:100%;
		height:200px;
		background-color: #853b2f;
	}
	#content5 {
	
		width:100%;
		height:200px;
		background-color: #6a3b2a;
	}
	#content6 {
	
		width:100%;
		height:200px;
		background-color: #562f21;
	}
	#content7 {
	
		width:100%;
		height:200px;
		background-color: #432419;
	}
	#logo {
		width: 234px;
		margin: 0 auto;
	}
	#capsuleLogo {
		width: 594px;
		margin: 0 auto;
	}
	#tree {
		width: 466px;
		margin: 0 auto;
	}
	#timewrapper {
		width: 350px;
		height: 50px;
		margin-left: 10px;
		background-color: #81523e;
		border-radius: 10px;
		box-shadow : 5px 5px 10px rgba(0, 0, 0, 10);
		position: absolute;

	}
	#clock {
		width: 280px;
		height: 50px;
		font-size: 30px; 
		color : white;
		font-family:'Nanum Gothic', sans-serif;
		display: inline-block;
		
	}
	#friendlistwrapper {
		height: 300px;
		width: 250px;
		margin-right: 10px;
		border-radius: 10px;
		box-shadow : 5px 5px 10px rgba(0, 0, 0, 10);
		background-color: white;
		float: right;

	}
	#top {
		display: flex;
		width: 250px;
		height: 40px;
		text-decoration: none;
	}
	#floatelement {
		width:100%;
		display: inline;
		float: left;
		z-index: 100;
	}
	#title {
		margin-top: 5px;
		margin-left : 10px;
		flex: 8;
		display: inline-block;
		font-family:'Nanum Gothic', sans-serif;
		font-weight: bold;
		text-shadow: 1px 1px 3px rgba(0, 0, 0, 10);
		
	}
	#search {
		display: inline-block;
		margin-top: 5px;
		flex: 1;

	}
	#delete {
		display: inline-block;
		margin-top: 5px;
		flex: 1;
		margin-right: 10px;

	}
	#mid {
		height: 220px;
		background-color: #e2dfcc;
	}
	#bottom {
		height: 40px;
		
	}
	#request {
		text-align: center;
		font-size: 20px;
		color: #ff4b64;
		font-family:'Nanum Gothic', sans-serif;
	}
	#mid {
		font-size: 12px;
		font-family:'Nanum Gothic', sans-serif;
	}
	#list {
		padding-top: 10px;
		padding-left: 10px;
	}
	#gobottom {
		display: inline-block;

	}
	#content4-1 {
		display: flex;
		background-color: #33231c;
		opacity: 0.7;
		height: 130px;
	}
	#noticetext {
		z-index: 10;
		display: flex;
		flex: 5;
		line-height: 130px;
		color: white;
	}
	#noticetext-1 {
		color: white;
		font-family:'Nanum Gothic', sans-serif;
		z-index: 10;
		font-size: 30px;
		
	}
	#noticetext-2 {		
		margin-left: 20px;
		margin-top: 15px;
		width: 300px;
		z-index: 10;
		height: 100px;
		background-color: white;		
		color: black;
		font-family:'Nanum Gothic', sans-serif;
		opacity: 0.7;
		border-radius: 10px;
		padding: 10px;
		
	}
	#timecapsuletext {
		font-size: 30px;
		font-family:'Nanum Gothic', sans-serif;
		color: white;
		flex: 1;
		line-height: 130px;
		z-index: 10;
	}
	#timecasuleimg {
		flex: 1;
		line-height: 130px;
		z-index: 10;
	}
	#logo2 {
		flex: 1;
		line-height: 130px;
		margin-left: 30px;
		z-index: 10;
	}

	</style>
</head>
<body>

	<div id="wrapper">
		<div id="content1">
			<div id="logo"><img src="resources/images/capsule1.png" alt="Capsule"></div>
			<div id="capsuleLogo"><img src="resources/images/write.png" alt="OurTime"></div>
			<div id="tree"><img src="resources/images/tree.png" alt="Mytree"></div>
		</div>
	

		<div id="content2">
			<div id="timewrapper">
				<div id="clock">
					<script type="text/javascript">
					</script>
				</div>
				<div id="gobottom"><a href="#write"><img src="resources/images/diary.png" height="30px;"></a></div>
			</div>
					
			<div id="friendlistwrapper">
				<div id="top">
					<div  id="title"><a href="/notice/list">이웃나무</a></div>
					<div id="search"><img src="resources/images/search.png"></div>
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
			</div>	
		</div>
	</div>
	<div id="wrapper2"> 
		
		<div id="content3">
		
		</div>
		<a name="write"></a>
		<div id="content4" >
			<div id="content4-1">
				<div id="logo2"><img src="resources/images/capsule1.png" alt="Capsule" height="130px"></div>
				<div id="noticetext">
					<div id="noticetext-1">공지사항</div>
					<div id="noticetext-2">공지사항1</div>
				</div>
				<div id="timecapsuletext">타입캡슐</div>
				<div id="timecasuleimg"><img src="resources/images/send.png" alt="SendTimeCapsule"></div>		
			</div>
		
		</div>
		
		<div id="content5">
		
		</div>
		
		<div id="content6">
		
		</div>
		
	</div>

</body>
</html>