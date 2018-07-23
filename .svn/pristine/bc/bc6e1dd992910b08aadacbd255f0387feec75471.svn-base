$().ready(function() {
	validateRule();
	

	var select = $("#stopFlag");  
	select.append("<option value='0'>停用</option>");  
	select.append("<option value='1'>启用</option>");  
   	 
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
function getWbPy(){
	var nameClass = $("#nameClass").val();
	$.ajax({  
		type : 'get',  
		url : "/template/tempClass/getWbPy",  
		dataType : 'json', 
		data: {
			nameClass : nameClass	
		},
		success : function(datas) {//返回list数据并循环获取  
			
			$("#pyCode").val(datas.py);
			$("#wbCode").val(datas.wb);
		}
	});
}

$.validator.setDefaults({
	submitHandler : function() {
		save();
	}
});
function save() {
	$.ajax({
		cache : true,
		type : "POST",
		url : "/template/tempClass/save",
		data : $('#stopForm').serialize(),// 你的formid
		async : false,
		error : function(request) {
			parent.layer.alert("Connection error");
		},
		success : function(data) {
			if (data.code == 1) {
				parent.layer.msg("操作成功");
				parent.reLoad();
				var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
				parent.layer.close(index);

			} else {
				parent.layer.alert(data.msg)
			}

		}
	});

}
function validateRule() {
	var icon = "<i class='fa fa-times-circle'></i> ";
	$("#stopForm").validate({
		rules : {
			codeClass : {
				required : true
			}
		},
		messages : {
			name : {
				codeClass : icon + "请输入类型代码"
			}
		}
	})
}