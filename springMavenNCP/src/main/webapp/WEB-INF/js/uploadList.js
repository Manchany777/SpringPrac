$(function(){
	$.ajax({
		type: 'post',
		url: '/springMavenNCP/user/getUploadList',
		dataType: 'json',
		success: function(data){
			console.log(JSON.stringify(data));
			
			var result;
			$.each(data, function(index, item) { 
				result = `<tr>` + 
						`<td align="center" class="seq">` + item.seq + `</td>` +
						`<td align="center">` + 
							`<img src='https://kr.object.ncloudstorage.com/bitcamp-edu-bucket-112/storage/` + item.imageFileName + 
							`'` + `style='width:70px; height:70px;' alt="` + item.imageName + `">` + 
						`</td>` + 
						`<td align="center" id="imageOriginalName">` + item.imageOriginalName + `</td>` + 
						`<td align="center">` + `<input type="button" value="수정" class="modifyBtn"/>` +`</td>`+
						`<td align="center">` + `<input type="button" value="삭제" class="deleteBtn"/>` +`</td>`+
						`<tr>`;
				$('#imageListTable').append(result);
			});
		},
		error: function(e){
			console.log(e);
		}
	});
});