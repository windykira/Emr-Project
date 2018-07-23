$(function(){
    validateRule();
})

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
        "dataDictionary.nameNode":$("#nameDe").val(),
        "dataDictionary.nodeType":"2",

        "dataElement.codeDe":$("#codeDe").val(),
        "dataElement.nameDe":$("#nameDe").val(),
        "dataElement.definition":$("#definition").val(),
        "dataElement.deValsType":$("#deValsType").val(),
        "dataElement.repFmt":$("#repFmt").val()
    };
    $.ajax({
        type : "POST",
        url : "/repository/dataelement/save",
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
                    url : "/repository/dataelement/exist", // 后台处理程序
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
                    url : "/repository/dataelement/exist",
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
                required : icon + "请输入数据元编码",
                remote : icon + "数据元编码已经存在"
            },
            nameDg : {
                required : icon + "请输入数据元名称",
                remote : icon + "数据元名称已经存在"
            }
        }
    })
}

