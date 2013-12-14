function deleteEvent(id){
	if(!confirm("确定要删除吗？")){
		return;
	}
	
	$.ajax(basePath + "/admin/event/" + id, {
		type: "DELETE",
		dataType: "json",
		contentType: "application/json",
		success: function(data, textStatus){
		    if(data==true){
				alert("删除成功！")
				setTimeout(window.location.reload(), 2000);
			}else{
				alert("删除失败！"+ data.errorMessage);
			}
		},
		error: function(xhr, ts, e){
			alert("系统错误！\n\n" + e);
		}
	});
}


function addOrEditEvent(event, successCallback){
	var dlg = $("#eventModal");  
		
	var fs = ['id', 'topic', 'name', 'desc'];
	// 填充旧值
	$.each(fs, function(i, f){
		$("[name=" + f + "]", dlg)[0].value = event[f] || "";
	});
	
	$("[name=save]", dlg).click(function(){
		event = {};
		$.each(fs, function(i, f){
			event[f] = $("[name=" + f + "]", dlg)[0].value;
		});
		$.ajax(basePath + "/admin/event", {
			type: "POST",
			contentType: "application/json",
			data: JSON.stringify(event),
			dataType: "json",
			success: function(d, s){
				if(d){
					dlg.modal("hide");
					(successCallback || new Function())(event);
				}else{
					alert("保存失败！");
				}
			},
			error: function(xhr, ts, e){
				alert("系统错误！\n\n" + e);
			}
		});
	});
	
	$("[name=cancel]", dlg).click(function(){
		dlg.modal("hide");
	});

	dlg.modal("show");
}