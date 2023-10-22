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
#updateForm div{
	color: red;
	font-size: 8pt;
	font-weight: bold;
}
</style>
</head>
<body>
<form id="updateForm">
	<table border="1">
		<tr>
			<th>상품명</th>
			<td>
				<input type="text" name="imageName" id="imageName" size="35" value="${ userImageDTO.imageName }">
				<div id="imageNameDiv"></div>
			</td>
		</tr>
		
		<tr>
			<td colspan="2">
				<textarea name="imageContent" id="imageContent" rows="10" cols="50">${ userImageDTO.imageContent }</textarea>
				<div id="imageContentDiv"></div>
			</td>
		</tr>
		
		<tr>
			<td colspan="2">
				<span id="showImg"></span>
				
				<img id="camera" src="../image/camera.png" width="30" height="30" alt="카메라">
				<input type="file" name="img" id="img" style="visibility: hidden;">
				<!-- multiple="multiple" 제거시 하나의 파일만 선택 가능 -->
			</td>
		</tr>
		
		<tr>
			<td colspan="2" align="center">
				<input type="button" value="이미지 수정" id="uploadBtn">
				<input type="reset" value="취소">
			</td>
		</tr>
	</table>
	<br>
	<input id="seq" value="${ userImageDTO.seq }" style="visibility: hidden;"/>
</form>
<button onclick="history.back();" value="뒤로가기">뒤로가기</button>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.7.0.min.js"></script>
<script type="text/javascript" src="../js/modifyUpload.js"></script>
<script type="text/javascript">
$('#camera').click(function(){
	$('#img').trigger('click'); // 강제 이벤트 발생
});

//// 기존 이미지 보여주기
// 클라우드 스토리지의 주소와 이미지 경로
var cloudStorageBaseUrl = 'https://kr.object.ncloudstorage.com/bitcamp-edu-bucket-112/';
var imageFolderPath = 'storage/';
var imageFileName = '${userImageDTO.imageFileName}';
// 완전한 이미지 URL 생성
var imageUrl = cloudStorageBaseUrl + imageFolderPath + imageFileName;
//이미지 객체 생성
var img = new Image();
// 이미지 로드가 완료되면 실행할 함수 지정
img.onload = function() {
    // 이미지 엘리먼트 생성
    var image = document.createElement('img');
    image.src = img.src;
    image.width = 70;
    image.height = 70;
    console.log(image);
    // 이미지를 화면에 추가
	$('#showImg').append(image);
};
// 이미지의 소스 경로 설정
img.src = imageUrl;


//// 업로드 버튼을 누르기 전에 선택한 이미지가 맞는지 확인하기 위해서 이미지를 보여준다.
// 이미지 1개만 미리보기
$('#img').change(function(e) {
    var file = e.target.files[0]; // 선택한 파일 가져오기
    var reader = new FileReader(); // FileReader 객체 생성
    
    reader.onload = function(event) {
        // 읽어들인 이미지를 동적으로 생성
        var newImage = document.createElement('img');
        newImage.src = event.target.result; // 읽어들인 이미지 데이터 설정
        newImage.width = 70;
        newImage.height = 70;
        
        // 기존 이미지를 삭제하고 새 이미지로 대체
        $('#showImg').empty()
        $('#showImg').append(newImage);
    };
    
    // 파일을 읽어들이기 시작
    reader.readAsDataURL(file);
});
</script>
</body>
</html>