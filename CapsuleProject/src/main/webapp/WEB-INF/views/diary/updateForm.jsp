<%@ page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<style type="text/css">
			body{
				margin: 0px;
				padding: 0px;
				font-family: 'Nanum Gothic', sans-serif;
				color:black;
			}
			
			#contentBox{
				width:500px;
				height:300px;
				resize:none;
			}
		</style>
		
		<script type="text/javascript">
			function sendData() {
 				var capsule1;
				var capsule3; 
/* 				var modify = document.modify;
				console.log(modify); */
				
				var diaryTitle = document.modify.diaryTitle;
				var diaryContent = document.modify.dirayContent;
				var type=document.modify.type;
				
				//서버로 전송
				modify.submit();
			}
		</script>
		
	</head>
	
	<body>
		<h4>게시물 보기</h4>
		<form id="modify" name="modify" method="post" action="update">
			<input type="hidden" name="diaryNo" value="${diary.diaryNo }"/>
			<input type="hidden" name="memberEmail" value="${diary.memberEmail }"/>
			<div>
				<input type="text" name="diaryTitle" value="${diary.diaryTitle}" required/>
			</div>
			<div>
				<textarea id="contentBox" name="diaryContent" required>${diary.diaryContent}</textarea>
			</div>
			<div>
				<select name="type" >
					<option value="all">전체보기</option>
					<option value="group">친구보기</option>
					<option value="only">나만보기</option>
				</select>
			</div>
		</form>
		
		<div id="buttonGroup">
			<a href="javascript:sendData()">수정</a>
		</div>	
			
	</body>
</html>