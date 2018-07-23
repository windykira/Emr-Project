$(function(){
    validateRule();
});

$.validator.setDefaults({
    submitHandler : function() {
        save();
    }
});

function cancel(){
    var index = parent.layer.getFrameIndex(window.name);
    parent.layer.close(index);
}

function save() {

    var selectedNodes = parent.zTree.getSelectedNodes();
    var dataDictionary = {

        "dataDictionary.pkRoot":selectedNodes[0].pkRoot,
        "dataDictionary.pkFather":selectedNodes[0].id,
        "dataDictionary.nameNode":$("#nameDg").val(),
        "dataDictionary.remark":$("#describe").val(),
        "dataDictionary.nodeType":"1",

        "dataGroup.codeDg":$("#codeDg").val(),
        "dataGroup.nameDg":$("#nameDg").val(),
        "dataGroup.describe":$("#describe").val()
    };
    $.ajax({
        type : "POST",
        url : "/repository/datagroup/save",
        data : dataDictionary,
        async : false,
        error : function(request) {
            parent.layer.alert("Connection error");
        },
        success : function(data) {
            if (data.code == 1) {
                parent.layer.msg("新增成功");
                parent.loadDataDictionary();
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
    $("#addDataGroup").validate({
        rules : {
            codeDg : {
                required : true,
                remote : {
                    url : "/repository/datagroup/exist", // 后台处理程序
                    type : "post", // 数据发送方式
                    dataType : "json", // 接受数据格式
                    data : { // 要传递的数据
                        codeDg : function() {
                            return $("#codeDg").val();
                        }
                    }
                }
            },
            nameDg : {
                required : true,
                minlength : 2,
                remote : {
                    url : "/repository/datagroup/exist",
                    type : "post", // 数据发送方式
                    dataType : "json", // 接受数据格式
                    data : { // 要传递的数据
                        nameDg : function() {
                            return $("#nameDg").val();
                        }
                    }
                }
            },
            agree : "required"
        },
        messages : {
            codeDg : {
                required : icon + "请输入数据组编码",
                remote : icon + "数据组编码已经存在"
            },
            nameDg : {
                required : icon + "请输入数据组名称",
                remote : icon + "数据组名称已经存在"
            }
        }
    })
}


