$(function(){
	$.ajax({  // 동적으로 중복여부 체크
		type: 'post',
		url: '/chapter06_web/user/getUser', // 이미 있는 getUser컬럼 사용
		data: 'id=' + $('#id').val(), 		// model에게 넘겨받은 id 파라미터를 getUser로 넘겨줌
		dataType: 'json',  					// DTO객체니까 JSON타입으로
		success: function(data){
			console.log(JSON.stringify(data));
			
			$('#name').val(data.name);
			$('#pwd').val(data.pwd);
		},
		error: function(e){
			console.log(e);
		}
	});
});