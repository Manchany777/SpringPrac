$(function(){
	$.ajax({
		type: 'post',
		url: '/chapter06_web/user/getUserList',
		data: 'pg=' + $('#pg').val(),
		dataType: 'json',
		success: function(data){
			console.log(JSON.stringify(data)); // 현재 객체가 json형태로 바뀌었는지 확인
			//console.log(data[0].name);		   // 해당 json배열 객체에서 0번째 요소 출력
			console.log(data.list[0].name); // Map으로 받고나서 data안에 userPaging객체와 list객체가 들어온다.
			
			//$.each(data, function(index, items)
			$.each(data.list, function(index, items){  // each문으로 모든 요소 출력
				console.log(items.name); 		  // 콘솔창에 이름 출력
				$('<tr/>').append($('<td/>', { 	  //  웹화면에 출력
					align: 'center',
					text : items.name
				})).append($('<td/>', {
					align: 'center',
					text : items.id
				})).append($('<td/>', {
					align: 'center',
					text : items.pwd
				})).appendTo($('#userListTable'));
			}); // $.each
			
			//페이징 처리
			$('#userPagingDiv').html(data.userPaging.pagingHTML);
		},
		error: function(e){
			console.log(e);
		}
	});
});