<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 반드시 result.do로 해줘야 한다. (result.jsp로 적으면 안 됨) -->
<form name="sumForm" method="get" action="/chapter06_1/result.do">
<table border="1" cellpadding="5" cellspacing="0">
	<tr>
		<th width='40px'>x</th>
		<td>
			<input type="text" id="x" name="x" size="7" />
		</td>
	</tr>
	<tr>
		<th>y</th>
		<td>
			<input type="text" id="y" name="y" size="7" />
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