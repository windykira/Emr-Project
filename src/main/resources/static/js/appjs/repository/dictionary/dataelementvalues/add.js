$(function(){

    $("#pkDataElemt").val(parent.zTree.getSelectedNodes()[0].pkBd);
    $("#nameDe").val(parent.$("#nameDe").val());
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

    $.ajax({
        type : "POST",
        url : "/repository/dataelementvalues/save",
        data : $("#addElementValue").serialize(),
        async : false,
        error : function(request) {
            parent.layer.alert("Connection error");
        },
        success : function(data) {
            if (data.code == 1) {
                parent.layer.msg("新增成功");
                parent.$('#elementValuesTable').bootstrapTable('refresh');
                var index = parent.layer.getFrameIndex(window.name);
                parent.layer.close(index);

            } else {
                parent.layer.alert(data.msg)
            }

        }
    });

}


function validateRule() {

    var icon = "<i class='fa fa-times-circle'></i> ";
    $("#addElementValue").validate({
        rules : {
            codeDeVal : {
                required : true,
                remote : {
                    url : "/repository/dataelementvalues/exist", // 后台处理程序
                    type : "post", // 数据发送方式
                    dataType : "json", // 接受数据格式
                    data : { // 要传递的数据
                        codeDeVal : function() {
                            return $("#codeDeVal").val();
                        },
                        pkDataElemt :function() {
                            return $("#pkDataElemt").val();
                        }
                    }
                }
            },
            nameDeVal : {
                required : true,
                minlength : 1,
                remote : {
                    url : "/repository/dataelementvalues/exist",
                    type : "post", // 数据发送方式
                    dataType : "json", // 接受数据格式
                    data : { // 要传递的数据
                        nameDeVal : function() {
                            return $("#nameDeVal").val();
                        },
                        pkDataElemt :function() {
                            return $("#pkDataElemt").val();
                        }
                    }
                }
            },
            agree : "required"
        },
        messages : {
            codeDeVal : {
                required : icon + "请输入数据元值",
                remote : icon + "数据元值已经存在"
            },
            nameDeVal : {
                required : icon + "请输入数据元值含义",
                remote : icon + "数据元值含义已经存在"
            }
        }
    })
}