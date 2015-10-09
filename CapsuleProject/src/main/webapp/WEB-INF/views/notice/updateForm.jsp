<%@ page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<style type="text/css">
			@import url(http://fonts.googleapis.com/earlyaccess/nanumgothic.css);
		
			body {
				font-family: "Nanum Gothic" , sans-serif;
				font-size: 12px;
				color: white;
			}
			span {
				display: inline-block;
				margin: 2px 10px;
			}
			
			span.title {
				margin: 2px 10px;
				border: 1px solid darkgray;
				background: lightgray;
				width: 70px;
				text-align: center;
				color: black;
			}
			
			textarea {
				margin: 2px 10px;
			}
			
			pre {
				margin: 10px;
				border: 1px solid darkgray;
				padding: 10px;
				width: 300px;
				height: 100px;
				font-size: 12px;
			}
			
			#buttonGroup {
				margin: 10px;
				text-align: center;
			}
			
			#buttonGroup a {
				display:inline-block;
				width: 70px;
				line-height: 30px;
				text-decoration: none;
				font-size: small;
				color: white;
				border: 1px solid darkgray;
				background-color: gray;
				font-weight: bold;
			}
			
			#buttonGroup a:hover {
				color: black;
				background-color: lightgray;
			}
		</style>
		
		<script type="text/javascript">
			function sendData() {
				//값의 유효성 검사
				//var modifyForm = document.querySelector("#modifyForm");
				var modifyForm = document.modifyForm;
				console.log(modifyForm);
				
				//var title = document.querySelector("#title");
				var title = document.modifyForm.title;
				console.log(title);
				
				var content = document.modifyForm.content;
				
				if(title.value == "" || content.value == "") {
					alert("제목과 내용은 있어야 합니다.");
					return;
				}

				//서버로 전송
				modifyForm.submit();
			}
		</script>
	</head>
	
	<body>
		<h4>게시물 보기</h4>
		<form id="modifyForm" name="modifyForm" method="post" action="update">		
			<span class="title">번호:</span> 
			<span class="content">${notice.no}</span> 
			<input type="hidden" name="no" value="${notice.no}"/><br/>
			
			<span class="title">제목:</span> 
			<input id="title" type="text" name="title" value="${notice.title}"/> <br/>
			
			<span class="title">관리자:</span> 
			<span class="content">${notice.writer}</span> <br/>
			
			<span class="title">날짜:</span> 
			<span class="content">${notice.date}</span> <br/>
					
			<span class="title">내용:</span> <br/>
			<textarea name="content" cols="80" rows="5">${notice.content}</textarea>
		</form>
		<div id="buttonGroup">
			<a href="javascript:sendData()">수정</a>
			<a href="detail?noticeNo=${notice.no}">취소</a>
		</div>		
	</body>
</html>