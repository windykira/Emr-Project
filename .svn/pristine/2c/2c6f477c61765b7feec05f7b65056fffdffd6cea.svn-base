var menuIds;
$(function() {
	validateRule();
	var select = $("#range");
	var range = $("#rangeN").val();
	if(range == 'C'){
		
		select.append("<option value='C'>全院</option>");  
		select.append("<option value='D'>科室</option>");  
	}
	if(range == 'D'){
		
		select.append("<option value='D'>科室</option>");  
		select.append("<option value='C'>全院</option>");  
	}
});
$.validator.setDefaults({
	submitHandler : function() {
		update();
	}
});
function update() {
	$('#menuIDs').val(menuIds);
	var role = $('#signupForm').serialize();
	$.ajax({
		cache : true,
		type : "POST",
		url : "/emrsys/kb/update",
		data : role, // 你的formid
		async : false,
		error : function(request) {
			alert("Connection error");
		},
		success : function(r) {
			if (r.code == 1) {
				parent.layer.msg(r.msg);
				parent.reLoad();
				var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
				parent.layer.close(index);

			} else {
				parent.layer.msg(r.msg);
			}

		}
	});
}
function validateRule() {
	var icon = "<i class='fa fa-times-circle'></i> ";
	$("#signupForm").validate({
		rules : {
			sympCode : {
				required : true
			}
		},
		messages : {
			sympCode : {
				required : icon + "请输入症状编码"
			}
		}
	});
}