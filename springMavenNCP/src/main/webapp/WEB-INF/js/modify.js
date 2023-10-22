// 수정화면으로 보내기
$(document).on('click', '.modifyBtn', function(){
    	var seq = $(this).closest('tr').find('.seq').text();
    	console.log(seq);
    	
		$.ajax({ 	// DB와 연결
			type: 'get',
			url: '/springMavenNCP/user/updateForm',
			data: { 'seq' : $(this).closest('tr').find('.seq').text() },
			dataType: 'html',
			success: function(data){
				//console.log('잘 받아오나?');
				console.log(seq);
				//alert(data);
				location.href='/springMavenNCP/user/updateForm?seq=' + seq;
			},
			error: function(e){
				console.log(e);
			}
		});
});