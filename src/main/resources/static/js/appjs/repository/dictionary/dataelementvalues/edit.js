$(function(){


});

function cancel(){
    var index = parent.layer.getFrameIndex(window.name);
    parent.layer.close(index);
}

function save() {
    $.ajax({
        type : "POST",
        url : "/repository/dataelementvalues/update",
        data : $("#updateElementValue").serialize(),
        async : false,
        error : function(request) {
            parent.layer.alert("Connection error");
        },
        success : function(data) {
            if (data.code == 1) {
                parent.layer.msg("更新成功");
                parent.$('#elementValuesTable').bootstrapTable('refresh');
                var index = parent.layer.getFrameIndex(window.name);
                parent.layer.close(index);

            } else {
                parent.layer.alert(data.msg)
            }
        }
    });

}