$(function(){
	// 유효성 검사
	$('#writeBtn').click(function(){
		// 초기화
		$('#nameDiv').empty();
		$('#idDiv').empty();
		$('#pwdDiv').empty();
		
		if($('#name').val()==''){
			$('#nameDiv').text('이름을 입력하세요.');
			$('#name').focus();
		} else if ($('#id').val()=='') {
			$('#idDiv').text('아이디를 입력하세요.');
			$('#id').focus();
		} else if ($('#pwd').val()=='') {
			$('#pwdDiv').text('비밀번호를 입력하세요.');
			$('#pwd').focus();
		} else {
			$.ajax({}); // DB와 연결
			$('#writeForm').submit();
		}
	});
	
	// 아이디 중복체크
	$('#id').focusout(function(){});
});