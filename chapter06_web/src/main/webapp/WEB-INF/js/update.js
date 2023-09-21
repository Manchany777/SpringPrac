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
		} else if ($('#pwd').val()=='') {
			$('#pwdDiv').text('비밀번호를 입력하세요.');
			$('#pwd').focus();
		} else {
			$.ajax({ 	// DB와 연결
				type: 'post',
				url: '/chapter06_web/user/write',
				data: $('#userUpdateForm').serialize(), // #writeForm안에 있는 모든 데이터(name,id,pwd)를 가지고 감
				success: function(){
					alert('회원수정이 완료되었습니다');
					location.href = '/chapter06_web/user/list';
				},
				error: function(e){
					console.log(e);
				}
			});
			
		}
	});
});