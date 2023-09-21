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
<input type="text" id="pg" value="${ pg }">
<table border="1" frame="hsides" rules="rows" id="userListTable">
	<tr>
		<th width="200">이름</th>
		<th width="200">아이디</th>
		<th width="200">비밀번호</th>
	</tr>
	
	<!-- 동적 처리 -->
	
</table>
<div style="width: 900px; text-align:center;">${ userPaging.pagingHTML }</div>

<script type="text/javascript" src="http://code.jquery.com/jquery-3.7.0.min.js"></script>
<script type="text/javascript" src="../js/list.js"></script>
<script>
function userPaging(pg) {
	// BoardPaging에서 호출할 함수를 만듦
	location.href = "/chapter06_web/user/UserList?pg=" + pg;
}
</script>
</body>
</html>