var menuIds;
$(function() {
	validateRule();
	var select = $("#stopFlag");
	var stopFl = $("#stopFl").val();
	if(stopFl == '0'){
		
		select.append("<option value='0'>停用</option>");  
		select.append("<option value='1'>启用</option>");  
	}
	if(stopFl == '1'){
		
		select.append("<option value='1'>启用</option>");  
		select.append("<option value='0'>停用</option>");  
	}
});
$.validator.setDefaults({
	submitHandler : function() {
		update();
	}
});

function openCatalog(){
    layer.open({
        type:2,
        title:"选择上级目录",
        shadeClose: true,
        area : [ '400px', '600px' ],
        skin: 'layui-layer-molv',
            content:"/template/medicalrecord/catalogTree",
                btn: ['确定', '取消', ],
                yes: function(index, layero){
                var iframeWin = window[layero.find('iframe')[0]['name']];
                var object = iframeWin.callBack();
                layer.close(index);
                $("#pkCatalogName").val(object.catalogName);
                $("#pkCatalog").val(object.catalogId);
        }
    })
}
function update() {
	$('#menuIDs').val(menuIds);
	var role = $('#signupForm').serialize();
	$.ajax({
		cache : true,
		type : "POST",
		url : "/template/tempClass/update",
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
			codeClass : {
				required : true
			}
		},
		messages : {
			codeClass : {
				required : icon + "请输入类型编码"
			}
		}
	});
}