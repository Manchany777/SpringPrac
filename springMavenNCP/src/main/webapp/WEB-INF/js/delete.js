// 삭제버튼
$(document).on('click', '.deleteBtn', function(){
    if(confirm('삭제하시겠습니까?')) {
    	var seq = $(this).closest('tr').find('.seq').text();
    	console.log(seq);
    	
		$.ajax({ 	// DB와 연결
			type: 'post',
			url: '/springMavenNCP/user/deleteList',
			data: { 'seq' : $(this).closest('tr').find('.seq').text() },
			dataType: 'text',
			success: function(data){
				alert(data);
				location.href = '/springMavenNCP/user/uploadList';
			},
			error: function(e){
				console.log(e);
			}
		});
	} //if
});

// $('#deleteBtn').click(function(){}); => 이렇게 적으면 작동 안 된다.
// 문제가 발생한 이유는 삭제 버튼에 대한 이벤트 핸들러가 동적으로 추가된 요소에 대해 작동하지 않기 때문입니다. 
// jQuery로 생성된 동적 요소에 이벤트 핸들러를 추가할 때는,
// $(document).on('event', 'selector', function(){}) 형태로 이벤트 위임(Event Delegation)을 사용해야 합니다. 
// 이 방법을 사용하면 동적으로 생성된 요소에도 이벤트 핸들러가 적용됩니다.

// var seq = $(this).closest('.seq').html(); 이렇게 하니까 undefined가 뜨는데 왜 item.seq값을 못잡을까?
//.closest('.seq')는 현재 요소에서 가장 가까운 .seq 클래스를 갖는 부모 요소를 찾습니다. 
// 그러나 .seq는 <td> 요소의 클래스입니다. 여기서 item.seq 값은 테이블의 특정 행의 데이터로 가정됩니다. 
// 따라서 올바른 방법은 .closest('.seq')를 사용하는 것이 아니라 .closest('tr').find('.seq').text()를 사용하는 것입니다.
// 이렇게 하면 삭제 버튼을 클릭할 때 해당 행의 .seq 클래스를 가진 요소를 찾아 그 값을 가져올 수 있습니다.