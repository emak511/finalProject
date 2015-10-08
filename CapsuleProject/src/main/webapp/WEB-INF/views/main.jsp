<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
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
	<style type="text/css">
	body {
		margin: 0px;
		width:100%;
	}
	#wrapper {
		width:100%;
		height:100%;
	}
	#content1 {
		width:100%;
		height:300px;
		background-color: #d5cc49;
		float: none;
	}
	#content2 {
		width:100%;
		height:300px;
		background-color: #99d3bb;
	}
	#content3 {
		width:100%;
		height:62px;	
		background-color: #99d3bb;
		background-image: url(resources/images/ground.png);
	}
	#content4 {
		width:100%;
		height:600px;
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
	#timewrapper {
		width: 350px;
		height: 50px;
		margin-left: 10px;
		margin-top: 275px;
		background-color: #81523e;
		border-radius: 10px;
		box-shadow : 5px 5px 10px rgba(0, 0, 0, 10);
		position: absolute;
	}
	#clock {
		width: 280px;
		height: 50px;
		margin: 0 auto;	
		font-size: 30px; 
		color : white;
		font-family:'Nanum Gothic', sans-serif;
	}
	#friendlistwrapper {
		height: 300px;
		width: 250px;
		margin-right: 10px;
		border-radius: 10px;
		box-shadow : 5px 5px 10px rgba(0, 0, 0, 10);
		background-color: white;
		float: right;
		margin-top: 275px;
	}
	#top {
		display: flex;
		width: 250px;
		background-color: #e2dfcc;
		border-radius: 10px 10px 0 0 ;

	}
	#floatelement {
		width:100%;
		display: inline;
		float: left;
	}
	#logo {
		float:none;
	}
	#title {
		margin-top: 5px;
		margin-left : 10px;
		flex: 8;
		display: inline-block;
		font-family:'Nanum Gothic', sans-serif;
		font-weight: bold;
		
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
	
	</style>
</head>
<body>
	<div id="floatelement">
		<div id="timewrapper">
			<div id="clock">
				<script type="text/javascript">
				</script>
			</div>
		</div>
		
		<div id="friendlistwrapper">
			<div id="top">
				<div  id="title">이웃나무</div>
				<div id="search"><img src="resources/images/search.png" ></div>
				<div id="delete"><img src="resources/images/x.png" ></div>
			</div>
			<div id="listbackground"></div>
			<div id="list"></div>
			<div id="request"></div>		
		</div>
	</div>
	<div id="wrapper">
		<div id="content1">
			<div id="logo"><img src="resources/images/capsuleLogo.png" alt="Capsule"></div>
			<div id="capsuleLogo"><img src="resources/images/note2.png" alt="OurTime"></div>
		</div>
		
		<div id="content2">
			
		</div>
		
		<div id="content3">
		
		</div>
		
		<div id="content4">
		
		</div>
		
		<div id="content5">
		
		</div>
		
		<div id="content6">
		
		</div>
		
		<div id="content7">
		
		</div>
	</div>

</body>
</html>