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
	padding: 5px;
}
</style>
</head>
<body>
<table id="imageListTable" border="1" frame="hsides" rules="rows">
	<tr>
		<th width="100">번호</th>
		<th width="200">이미지</th>
		<th width="200">상품명</th>
		<th width="200">수정</th>
		<th width="200">삭제</th>
	</tr>
	
	<!-- 동적처리 -->
	
</table>
<br>
<button onclick="history.go(-1);" value="뒤로가기">뒤로가기</button>

<script type="text/javascript" src="http://code.jquery.com/jquery-3.7.0.min.js"></script>
<script type="text/javascript" src="../js/uploadList.js"></script>
<script type="text/javascript" src="../js/delete.js"></script>
<script type="text/javascript" src="../js/modify.js"></script>
</body>
</html>