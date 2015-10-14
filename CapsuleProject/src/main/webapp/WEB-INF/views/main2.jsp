<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="resources/css/main2.css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-1.11.3.min.js"></script>
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
				<div id="timecapsuletext"><a href="sendtimecapsule"  target="bottomlogobox">타입캡슐 보내기</a></div>
				<div id="timecapsuletext2"><a href="viewtimecapsule"  target="bottomlogobox">타입캡슐 보기</a></div>
				<div id="timecapsuleimg"><img src="resources/images/send.png" alt="SendTimeCapsule"></div>		
			</div>
		</div>
		
		<div id="content5">
			<div id="capsulebox1"><a href="bottomlogobox2"  target="bottomlogobox"><img src="resources/images/capsulebox.png" alt="capsulebox" height="150px"></a></div>
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
			<div id="capsulebox1"><a href="bottomlogobox2"  target="bottomlogobox"><img src="resources/images/capsulebox.png" alt="capsulebox" height="150px"></a></div>
		</div>
	</div>
	<div id="iframewrapper">
			<iframe id="bottomlogobox" src="sub/bottomlogobox" name="bottomlogobox" ></iframe>
		</div>
	


</body>
</html>