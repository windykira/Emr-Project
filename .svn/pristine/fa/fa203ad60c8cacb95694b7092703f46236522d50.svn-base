$().ready(function () {
    var userId = parent.$("#userId").val();
    loadDepartment();
    validateRule();

});

$.validator.setDefaults({
    submitHandler: function () {
        loadSystem();
    }
});

function loadSystem(){

    var parentIndex = parent.layer.getFrameIndex(window.name); // 获取窗口索引
    parent.$("#departmentId").val($("#sysdept").val());
    $.ajax({
        type: "POST",
        url: parent.ctx+"login",
        data: parent.$('#signupForm').serialize(),
        success: function (r) {
            if (r.code == 1) {
                var index = layer.load(1, {
                    shade: [0.1,'#fff'] //0.1透明度的白色背景
                });
                parent.location.href = '/index';
                parent.layer.close(parentIndex);
            } else {
                layer.msg(r.msg);
            }
        },
    })
}


/*$(".btn-primary").click(function () {

    //parent.location.href = '/index';
    var parentIndex = parent.layer.getFrameIndex(window.name); // 获取窗口索引
    $.ajax({
        type: "POST",
        url: parent.ctx+"login",
        data: parent.$('#signupForm').serialize(),
        success: function (r) {
            if (r.code == 1) {
                var index = layer.load(1, {
                    shade: [0.1,'#fff'] //0.1透明度的白色背景
                });
                parent.location.href = '/index';
                parent.layer.close(parentIndex);
            } else {
                layer.msg(r.msg);
            }
        },
    })
});*/

function businessRefresh() {

    $.ajax({
        type: "POST",
        url: "/main",
        data: $('#signupForm').serialize(),// 你的formid
        async: false,
        error: function (request) {
            parent.layer.alert("Connection error");
        },
        success: function (data) {
            if (data.code == 0) {
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
    $("#signupForm").validate({
        rules: {
            sysdept: {
                required: true
            }
        },
        messages: {
            sysdept: {
                required: icon + "请选择科室"
            }
        }
    })
}

function loadDepartment() {
    var html = "";
    var data = parent.departmentData;
    for (var i = 0; i < data.length; i++) {
        html += '<option value="' + data[i].id + '">' + data[i].departmentName + '</option>'
    }
    $(".chosen-select").append(html);
    $(".chosen-select").chosen({
        maxHeight: 200
    });
    /*$.ajax({
        type:"GET",
        url: '/emrsys/dept/listByUserId/' + parent.$("#userId").val(),
        success: function (data) {
            //加载数据
            for (var i = 0; i < data.length; i++) {
                html += '<option value="' + data[i].id + '">' + data[i].departmentName + '</option>'
            }
            $(".chosen-select").append(html);
            $(".chosen-select").chosen({
                maxHeight: 200
            });
        }
    });*/
}
