<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>성적 합계와 평균 구하기</h1>
<!-- 반드시 result.do로 해줘야 한다. (result.jsp로 적으면 안 됨) -->
<form name="sumForm" method="post" action="/chapter06_1/sungJuk/result.do">
<table border="1" cellpadding="5" cellspacing="0">
	<tr>
		<th width='45px'>이름 : </th>
		<td>
			<input type="text" id="name" name="name" size="7" />
		</td>
	</tr>
	<tr>
		<th>국어 : </th>
		<td>
			<input type="text" id="kor" name="kor" size="7" />
		</td>
	</tr>
	<tr>
		<th>영어 : </th>
		<td>
			<input type="text" id="eng" name="eng" size="7" />
		</td>
	</tr>
	<tr>
		<th>수학 : </th>
		<td>
			<input type="text" id="math" name="math" size="7" />
		</td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<input type="submit" value="계산"/>
			<input type="reset" value="취소"/>
		</td>
	</tr>
</table>
</form>
</body>
</html>