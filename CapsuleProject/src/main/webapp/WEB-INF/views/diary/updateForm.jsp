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
				//값의 유효성 검사
				var diary_c1;
				var diary_c3;
				var modify = document.modify;
				
				var diary_title = document.modify.diary_title;
				var diary_content = document.modify.diray_content;
				var type=document.modify.type;
				if(type=="all"){
					diary_c1=1;
					diary_c3=0;
				}else if(type=="group"){
					diary_c1=0;
					diary_c3=0;
				}else{
					diary_c1=0;
					diary_c3=1;
				}
				
				//서버로 전송
				modify.submit();
			}
		</script>
		
	</head>
	
	<body>
		<h4>게시물 보기</h4>
		<form id="modify" name="modify" method="post" action="update">
			
			<input type="hidden" name="diary_dno" value="${diary.diaryNo}"/>
			<div>
				<input type="text" name="diary_title" value="${diary.diaryTitle}" required/>
			</div>
			<div>
				<textarea id="contentBox" name="diary_content" required>${diary.diaryContent}</textarea>
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