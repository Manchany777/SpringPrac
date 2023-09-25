<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table {
	border-collapse: collapse;
}
th, td {
	padding: 8px;
}
</style>
</head>
<body>
<form id="uploadForm">
	<table border="1">
		<tr>
			<th>상품명</th>
			<td><input type="text" name="imageName" size="35"></td>
		</tr>
		
		<tr>
			<td colspan="2">
				<textarea name="imageContent" rows="10"  cols="50"></textarea>
			</td>
		</tr>
		
		<!-- 다중 업로드 할 때는 name 속성의 이름이 같아야 한다. -->
		<!-- 
		<tr>
			<td colspan="2">
				<input type="file" name="img">
			</td>
		</tr>
		
		<tr>
			<td colspan="2">
				<input type="file" name="img">
			</td>
		</tr>
		 -->
		 
		<!-- 한 번에 여러개의 파일을 선택 -->
		<tr>
			<td colspan="2">
				<span id="showImg"></span>
			
				<img id="camera" alt="카메라" src="../image/camera.png" width="50" height="50">
				<input type="file" name="img[]" id="img" multiple="multiple" style="visibility: hidden;">
			</td>
		</tr>
		
		 
		<tr>
			<td colspan="2" align="center">
				<input type="button" value="이미지 업로드" id="uploadBtn">
				<input type="reset" value="취소">
			</td>
		</tr>
	</table>
</form>

<script type="text/javascript" src="http://code.jquery.com/jquery-3.7.0.min.js"></script>
<script type="text/javascript" src="../js/upload_AJax.js"></script>
<script type="text/javascript">
$('#camera').click(function(){
	$('#img').trigger('click'); // 강제 이벤트 발생
});
</script>
</body>
</html>