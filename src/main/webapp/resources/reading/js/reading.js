function deleteBook(id){
    if(!confirm("确定要删除吗？")){
        return;
    }

    $.ajax(contextPath + "/my/book/" + id, {
        type: "DELETE",
        dataType: "json",
        contentType: "application/json",
        success: function(data, textStatus){
            if(data==true){
                alert("删除成功！")
                setTimeout(window.location.href = contextPath + "/my/book", 2000);
            }else{
                alert("删除失败！"+ data.errorMessage);
            }
        },
        error: function(xhr, ts, e){
            alert("系统错误！\n\n" + e);
        }
    });
}

function offShelf(id){
	if(!confirm("确定要下架吗？")){
	    return;
	}
	
	var data = {};
	data['action']='offShelf';

	$.ajax(contextPath + "/my/book/" + id, {
	    type: "POST",
	    data: data,
	    dataType: "json",
	    success: function(data, textStatus){
	        if(data==true){
	            alert("下架成功！")
	            setTimeout(window.location.href = contextPath + "/my/book", 2000);
	        }else{
	            alert("下架失败！"+ data.errorMessage);
	        }
	    },
	    error: function(xhr, ts, e){
	        alert("系统错误！\n\n" + e);
	    }
	});
}

function onShelf(id){
	var data = {};
	data['action']='onShelf';
	
	$.ajax(contextPath + "/my/book/" + id, {
	    type: "POST",
	    data: data,
	    dataType: "json",
	    success: function(data, textStatus){
	        if(data==true){
	            alert("上架成功！")
	            setTimeout(window.location.href = contextPath + "/my/book", 2000);
	        }else{
	            alert("上架失败！"+ data.errorMessage);
	        }
	    },
	    error: function(xhr, ts, e){
	        alert("系统错误！\n\n" + e);
	    }
	});
}

function confirmReturn(id){
	if(!confirm("确定书已经归还了吗？")){
	    return;
	}
	
	var data = {};
	data['action']='confirmReturn';
	
	$.ajax(contextPath + "/my/book/" + id, {
	    type: "POST",
	    data: data,
	    dataType: "json",
	    success: function(data, textStatus){
	        if(data==true){
	            alert("确认归还成功！")
	            setTimeout(window.location.href = contextPath + "/my/book", 2000);
	        }else{
	            alert("确认归还失败！"+ data.errorMessage);
	        }
	    },
	    error: function(xhr, ts, e){
	        alert("系统错误！\n\n" + e);
	    }
	});
}

function lend(id){
	var dlg = $("#modal");  
		
	$("[name=save]", dlg).click(function(){
		var data = {};
		data['action']='lead';
		data['borrower'] =$("[name=borrower]", dlg)[0].value;
		
		$.ajax(contextPath + "/my/book/" + id, {
			type: "POST",
			data: data,
			dataType: "json",
			success: function(d, s){
				if(d){
					dlg.modal("hide");
					alert("借出成功！")
					setTimeout(window.location.href = contextPath + "/my/book", 2000);
				}else{
					alert("借出失败！");
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