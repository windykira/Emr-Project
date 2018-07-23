$().ready(function() {
	validateRule();
	

	var select = $("#range");  
	select.append("<option value='C'>全院</option>");  
	select.append("<option value='D'>科室</option>");  
   	 
});
function getWbPy(){
	var sympName = $("#sympName").val();
	$.ajax({  
		type : 'get',  
		url : "/emrsys/kb/getWbPy",  
		dataType : 'json', 
		data: {
			sympName : sympName	
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
		url : "/emrsys/kb/save",
		data : $('#sympForm').serialize(),// 你的formid
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

			}
			if(data.code == 0){
				parent.layer.alert(data.msg)
				parent.reLoad();
				var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
				parent.layer.close(index);
			}
			else {
				parent.layer.alert(data.msg)
			}

		}
	});

}
function validateRule() {
	var icon = "<i class='fa fa-times-circle'></i> ";
	$("#sympForm").validate({
		rules : {
			sympCode : {
				required : true
			}
		},
		messages : {
			name : {
				sympCode : icon + "请输入症状代码"
			}
		}
	})
}