$(function(){
	$('#uploadBtn').click(function(){
		$('#imageNameDiv').empty();
		$('#imageContentDiv').empty();
		
		if($('#imageName').val() == '') {
			$('#imageNameDiv').text('상품명 입력');
			$('#imageName').focus();
		} else if($('#imageContent').val() == ''){
			$('#imageContentDiv').text('상품 내용 입력');
			$('#imageContent').focus();
		} else {
			// 기존 이미지 파일명 가져오기
		    //var originalImageFileName = '${userImageDTO.imageFileName}';
		    var originalImageFileName = '${userImageDTO.imageOriginalName}';
		    // 선택된 이미지 파일 가져오기
		    var selectedFile = $('#img')[0].files[0];
		    if (!selectedFile) {
		        // 파일이 선택되지 않은 경우에 대한 처리
		        alert('먼저 변경할 파일을 선택해 주세요.');
		        return; // 파일이 선택되지 않은 경우에는 함수를 종료합니다.
		    } else if (selectedFile.name === originalImageFileName){  // 이쪽은 구현 실패
		    	alert('변경하려는 파일이 기존 파일과 동일팝니다.');
		        return;
		    } 
		    
		      
		            
			var formData = new FormData($('#updateForm')[0]); // 현재 Form안에 있는 모든 데이터(객체값)을 읽어오기 - serialize 못씀
			
			// 이미지를 선택한 경우에만 FormData에 추가
			/*
            if ($('#img')[0].files.length > 0) {
                formData.append('img', $('#img')[0].files[0]);
                formData.append('imageFileName', '${userImageDTO.imageFileName}');
            }*/
            
           
            /*
            // 기타 텍스트 데이터 추가
            formData.append('imageName', $('#imageName').val());
            formData.append('imageContent', $('#imageContent').val());
            */
            formData.append('seq', $('#seq').val());
			console.log('이미지 seq : ' + $('#seq').val());
			
			$.ajax({
				type: 'post',
				enctype: 'multipart/form-data',
				processData : false, // false로 해야 변수=값&변수=값 이렇게 문자열로 전송이 안 됨
				contentType : false,  // 이렇게 해야 multipart로 전송이 가능 
				url: '/springMavenNCP/user/update',
				data: formData, // FormData가 가져온 모든 정보를 formdata가 가져옴 (파일업로드는 serialize 사용 불가)
				dataType: 'text',
				success: function(data){
					alert(data); // 이 이미지가 실제로 태그 안으로 들어가야 함
					//$('#resultDiv').html(data);
					location.href='/springMavenNCP/user/uploadList';
				},
				error: function(e){
					console.log(e);
				}
			}); // ajax
		}
	});
});


// 수정버튼
/*
$('#updateBtn').click(function(){
		$.ajax({ 	// DB와 연결
			type: 'post',
			url: '/chapter06_web/user/update',
			data: $('#userUpdateForm').serialize(), // #writeForm안에 있는 모든 데이터(name,id,pwd)를 가지고 감
			success: function(){
				alert('회원정보 수정 완료');
				location.href = '/chapter06_web/user/list?pg=' + $('#pg').val();
			},
			error: function(e){
				console.log(e);
			}
		});
});*/