$(function() {
    validateRule();
});

$.validator.setDefaults({
    submitHandler : function() {
        save();
    }
});

function callBack(id, name){
    $("#pkFatherName").val(name);
    $("#pkFather").val(id);
}

function openCatalog(){
    layer.open({
        type:2,
        title:"选择上级目录",
        shadeClose: true,
        area : [ '400px', '600px' ],
        skin: 'layui-layer-molv',
            content:"/template/medicalrecord/catalogTree/2",
                btn: ['确定', '取消', ],
                yes: function(index, layero){
                var iframeWin = window[layero.find('iframe')[0]['name']];
                var object = iframeWin.callBack();
                $("#pkFatherName").val(object.catalogName);
                $("#pkFather").val(object.catalogId);
                layer.close(index);
        }
    })
}

function save() {
    $.ajax({
        type : "POST",
        url : "/template/medicalrecord/save",
        data : $('#addCatalog').serialize(),// 你的formid
        async : false,
        error : function(request) {
            parent.layer.alert("Connection error");
            $('#addCatalog')
        },
        success : function(data) {
            if (data.code == 1) {
                parent.layer.msg("新增成功");
                parent.loadEmrCataLog();
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
    $("#addCatalog").validate({
        rules : {
            codeCatalog : {
                required : true,
                remote : {
                    url : "/template/medicalrecord/exist", // 后台处理程序
                    type : "post", // 数据发送方式
                    dataType : "json", // 接受数据格式
                    data : { // 要传递的数据
                        codeCatalog : function() {
                            return $("#codeCatalog").val();
                        }
                    }
                }
            },
            nameCatalog : {
                required : true,
                minlength : 2,
                remote : {
                    url : "/template/medicalrecord/exist",
                    type : "post", // 数据发送方式
                    dataType : "json", // 接受数据格式
                    data : { // 要传递的数据
                        nameCatalog : function() {
                            return $("#nameCatalog").val();
                        }
                    }
                }
            },
            agree : "required"
        },
        messages : {
            codeCatalog : {
                required : icon + "请输入目录代码",
                remote : icon + "目录代码已经存在"
            },
            nameCatalog : {
                required : icon + "请输入目录名称",
                minlength : icon + "用户名必须两个字符以上",
                remote : icon + "目录名称已经存在"
            }
        }
    })
}