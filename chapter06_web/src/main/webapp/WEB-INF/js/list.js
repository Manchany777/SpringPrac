$(function(){
	$.ajax({
		type: 'post',
		url: '/chapter06_web/user/getUserList',
		data: 'pg=' + $('#pg').val(),
		dataType: 'json',
		success: function(data){
			console.log(JSON.stringify(data)); // 현재 객체가 json형태로 바뀌었는지 확인
		},
		error: function(e){
					console.log(e);
		}
	});
});