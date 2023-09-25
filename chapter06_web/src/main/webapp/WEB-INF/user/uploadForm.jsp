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
#writeForm div {
	color: red;
	font-size: 8pt;
	font-weight: bold;
}
</style>
</head>
<body>
<form method="post" enctype="multipart/form-data" action="/chapter06_web/user/upload">
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
				<input type="file" name="img[]" multiple="multiple">
			</td>
		</tr>
		
		 
		<tr>
			<td colspan="2">
				<input type="submit" value="이미지 업로드">
				<input type="reset" value="취소">
			</td>
		</tr>
	</table>
</form>
</body>
</html>