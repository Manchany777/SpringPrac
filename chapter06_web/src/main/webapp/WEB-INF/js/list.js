$(function(){
	$.ajax({
		type: 'post',
		url: '/chapter06_web/user/getUserList',
		data: 'pg=' + $('#pg').val(),
		dataType: 'json',
		success: function(data){
			console.log(JSON.stringify(data)); // 현재 객체가 json형태로 바뀌었는지 확인
			console.log(data[0].name);		   // 해당 json배열 객체에서 0번째 요소 출력
			
			$.each(data, function(index, items){  // each문으로 모든 요소 출력
				console.log(items.name); 		  // 콘솔창에 이름 출력
				$('<tr/>').append($('<td/>', { 	  //  웹화면에 출력
					text : items.name
				})).append($('<td/>', {
					text : items.id
				})).append($('<td/>', {
					text : items.pwd
				})).appendTo($('#userListTable'));
			});
		},
		error: function(e){
			console.log(e);
		}
	});
});