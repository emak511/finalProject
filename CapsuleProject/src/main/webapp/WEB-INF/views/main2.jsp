<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
				
				<div id="timecapsuletext3"><a href="sendtimecapsule"  target="bottomlogobox">받은 요청</a></div>
				
				<div id="timecapsuletext4"><a href="sendtimecapsule"  target="bottomlogobox">보낸 요청</a></div>
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
						<c:forEach var="Fcapsule" items="${list}">
							<option>${Fcapsule.fCapsuleGname }</option>
						</c:forEach>
					</select>
					<input type="submit" value="confirm" />
				</form>
			</div>
		</div>
		<div id="content7">
			<div id="capsulebox1"><a href="bottomlogobox2"  target="bottomlogobox"><img src="resources/images/capsulebox.png" alt="capsulebox" height="150px"></a></div>
		</div>
	</div>
	
			<iframe id="bottomlogobox" src="sub/bottomlogobox" name="bottomlogobox" ></iframe>

</body>
</html>