<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>결과</h1><br>
<form name="sumForm" method="post" action="/chapter06_1/sungJuk/result.do">
<table border="1" cellpadding="5" cellspacing="0">
	<tr>
		<td colspan="2" align="center"> ${ name }의 성적
		</td>
	</tr>
	<tr>
		<th width='45px'>총점 : </th>
		<td width='150px'>${ tot }</td>
	</tr>
	<tr>
		<th>평균 : </th>
		<td>${ avg }</td>
	</tr>
</table>
</form>
</body>
</html>