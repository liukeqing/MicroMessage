var basePath;
$(function(){
	basePath = $('#basePath').val();
});
function deleteBatch(){
//	$('#mainForm').attr('action',basePath +'DeleteBatch.action');
//	$('#mainForm').submit();
	var flag = confirm('你确认要删除这些记录吗？');
	if(flag){
		var ids = new Array();
		$('input[type=checkbox]:checked').each(function(){
			ids.push($(this).val());
		});
		$.ajax({
			type:'post',
			url:basePath + 'DeleteBatch.action',
			data:{'id':ids},
			traditional:true,
			success:function(msg){
				if(msg == 1){
					alert('删除成功！');
					$('#mainForm').submit();
				}else{
					alert('删除失败！');
				}
			}
		});
	}
}
function deleteOne(id){
	var flag = confirm('你确认要删除这条记录吗？');
	if(flag){
//		$('#currentId').val(id);
//		$('#mainForm').attr('action','<%=basePath %>DeleteOne.action');
//		$('#mainForm').submit();
		$.ajax({
			type:'post',
			url:basePath + 'DeleteOne.action',
			data:{id:id},
			success:function(msg){
				if(msg == 1){
					alert('删除成功！');
					$('#mainForm').submit();
				}else{
					alert('删除失败！');
				}
			}
		});
	}
}
function changeCurrentPage(currentPage){
	$("#currentPage").val(currentPage);
	$('#mainForm').submit();
}