$(function () {

    var status = $("input[name='status']:checked").val();
    firstLoadPage(status);
    $(":radio").click(function () {
        status = $("input[name='status']:checked").val();
        loadPage(status);
    });
});

function firstLoadPage(status){

    $('#exampleTable')
        .bootstrapTable(
            {
                method: 'get', // 服务器数据的请求方式 get or post
                url: "/emrsys/emp/list", // 服务器数据的加载地址
                iconSize: 'outline',
                toolbar: '#exampleToolbar',
                striped: true, // 设置为true会有隔行变色效果
                dataType: "json", // 服务器返回的数据类型
                pagination: true, // 设置为true会在底部显示分页条
                singleSelect: false, // 设置为true将禁止多选
                pageSize: 10, // 如果设置了分页，每页数据条数
                pageNumber: 1, // 如果设置了分布，首页页码
                showColumns: false, // 是否显示内容下拉框（选择显示的列）
                sidePagination: "server", // 设置在哪里进行分页，可选值为"client" 或者 server
                sortable: true,                     //是否启用排序
                sortOrder: "asc",
                queryParams: function (params) {
                    return {
                        // 说明：传入后台的参数包括offset开始索引，limit步长，sort排序列，order：desc或者,以及所有列的键值对
                        limit: params.limit,
                        page:(params.offset / params.limit) + 1,
                        sort: params.sort,      //排序列名
                        sortOrder: params.order, //排位命令（desc，asc）
                        name: $('#searchName').val(),
                        createStatus: $('input[name="status"]:checked').val()
                    };
                },
                columns: [
                    {
                        checkbox: true
                    },
                    {
                        field: 'id',
                        title: '序号',
                        formatter: function (value, row, index) {
                            return index + 1;
                        }
                    },
                    {
                        field: 'empName',
                        title: '姓名',
                        sortable: true
                    },
                    {
                        field: 'jobNum',
                        title: '工号'
                    },
                    {
                        field: 'email',
                        title: '邮箱'
                    },
                    {
                        field: 'createStatus',
                        title: '状态',
                        align: 'center',
                        formatter: function (value, row, index) {
                            if (value == '1') {
                                return '<span class="label label-danger">未创建</span>';
                            } else if (value == '2') {
                                return '<span class="label label-primary">已创建</span>';
                            }
                        }
                    },
                    {
                        title: '操作',
                        field: 'id',
                        align: 'center',
                        formatter: function (value, row, index) {
                            var e = '<a  class="btn btn-primary btn-sm ' + s_edit_h + '" href="#" mce_href="#" title="编辑" onclick="edit(\''
                                + row.id
                                + '\')"><i class="fa fa-edit "></i></a> ';
                            var d = '<a class="btn btn-warning btn-sm ' + s_remove_h + '" href="#" title="删除"  mce_href="#" onclick="remove(\''
                                + row.id
                                + '\')"><i class="fa fa-remove"></i></a> ';
                            var f = '<a class="btn btn-success btn-sm ' + s_resetPwd_h + '" href="#" title="重置密码"  mce_href="#" onclick="resetPwd(\''
                                + row.id
                                + '\')"><i class="fa fa-key"></i></a> ';
                            var g = '<a class="btn btn-success btn-sm ' + s_resetPwd_h + '" href="#" title="新增"  mce_href="#" onclick="add(\''
                                + row.pkEmp
                                + '\')"><i class="fa fa-save"></i></a> ';
                            return g;
                        }
                    }
                ]
            });
}

function loadPage(status){

    if(status == "1"){
        $("#exampleTable").bootstrapTable('refreshOptions',
            {
                method: 'get', // 服务器数据的请求方式 get or post
                url: "/emrsys/emp/list", // 服务器数据的加载地址
                iconSize: 'outline',
                toolbar: '#exampleToolbar',
                striped: true, // 设置为true会有隔行变色效果
                dataType: "json", // 服务器返回的数据类型
                pagination: true, // 设置为true会在底部显示分页条
                singleSelect: false, // 设置为true将禁止多选
                pageSize: 10, // 如果设置了分页，每页数据条数
                pageNumber: 1, // 如果设置了分布，首页页码
                showColumns: false, // 是否显示内容下拉框（选择显示的列）
                sidePagination: "server", // 设置在哪里进行分页，可选值为"client" 或者 server
                sortable: true,                     //是否启用排序
                sortOrder: "asc",
                queryParams: function (params) {
                    return {
                        // 说明：传入后台的参数包括offset开始索引，limit步长，sort排序列，order：desc或者,以及所有列的键值对
                        limit: params.limit,
                        page:(params.offset / params.limit) + 1,
                        sort: params.sort,      //排序列名
                        sortOrder: params.order, //排位命令（desc，asc）
                        name: $('#searchName').val(),
                        createStatus: $('input[name="status"]:checked').val()
                    };
                },
                columns: [
                    {
                        checkbox: true
                    },
                    {
                        field: 'id',
                        title: '序号',
                        formatter: function (value, row, index) {
                            return index + 1;
                        }
                    },
                    {
                        field: 'empName',
                        title: '姓名',
                        sortable: true
                    },
                    {
                        field: 'jobNum',
                        title: '工号'
                    },
                    {
                        field: 'email',
                        title: '邮箱'
                    },
                    {
                        field: 'createStatus',
                        title: '状态',
                        align: 'center',
                        formatter: function (value, row, index) {
                            if (value == '1') {
                                return '<span class="label label-danger">未创建</span>';
                            } else if (value == '2') {
                                return '<span class="label label-primary">已创建</span>';
                            }
                        }
                    },
                    {
                        title: '操作',
                        field: 'id',
                        align: 'center',
                        formatter: function (value, row, index) {
                            var e = '<a  class="btn btn-primary btn-sm ' + s_edit_h + '" href="#" mce_href="#" title="编辑" onclick="edit(\''
                                + row.id
                                + '\')"><i class="fa fa-edit "></i></a> ';
                            var d = '<a class="btn btn-warning btn-sm ' + s_remove_h + '" href="#" title="删除"  mce_href="#" onclick="remove(\''
                                + row.id
                                + '\')"><i class="fa fa-remove"></i></a> ';
                            var f = '<a class="btn btn-success btn-sm ' + s_resetPwd_h + '" href="#" title="重置密码"  mce_href="#" onclick="resetPwd(\''
                                + row.id
                                + '\')"><i class="fa fa-key"></i></a> ';
                            var g = '<a class="btn btn-success btn-sm ' + s_resetPwd_h + '" href="#" title="新增"  mce_href="#" onclick="add(\''
                                + row.pkEmp
                                + '\')"><i class="fa fa-save"></i></a> ';
                            return g;
                        }
                    }
                ]
        });
    }else if(status == "2"){

        $("#exampleTable").bootstrapTable('refreshOptions',
            {
                method: 'get', // 服务器数据的请求方式 get or post
                url: "/emrsys/user/list", // 服务器数据的加载地址
                iconSize: 'outline',
                toolbar: '#exampleToolbar',
                striped: true, // 设置为true会有隔行变色效果
                dataType: "json", // 服务器返回的数据类型
                pagination: true, // 设置为true会在底部显示分页条
                singleSelect: false, // 设置为true将禁止多选
                pageSize: 10, // 如果设置了分页，每页数据条数
                pageNumber: 1, // 如果设置了分布，首页页码
                showColumns: false, // 是否显示内容下拉框（选择显示的列）
                sidePagination: "server", // 设置在哪里进行分页，可选值为"client" 或者 server
                sortable: true,                     //是否启用排序
                sortOrder: "asc",
                queryParams: function (params) {
                    return {
                        // 说明：传入后台的参数包括offset开始索引，limit步长，sort排序列，order：desc或者,以及所有列的键值对
                        limit: params.limit,
                        page:(params.offset / params.limit) + 1,
                        sort: params.sort,      //排序列名
                        sortOrder: params.order, //排位命令（desc，asc）
                        name: $('#searchName').val(),
                        createStatus: $('input[name="status"]:checked').val()
                    };
                },
                columns: [
                    {
                        checkbox: true
                    },
                    {
                        field: 'id', // 列字段名
                        title: '序号', // 列标题
                        formatter: function (value, row, index) {
                            return index + 1;
                        }
                    },
                    {
                        field: 'userName',
                        title: '姓名'
                    },
                    {
                        field: 'userCode',
                        title: '工号'
                    },
                    {
                        field: 'email',
                        title: '邮箱'
                    },
                    {
                        title: '操作',
                        field: 'id',
                        align: 'center',
                        formatter: function (value, row, index) {
                            var e = '<a  class="btn btn-primary btn-sm ' + s_edit_h + '" href="#" mce_href="#" title="编辑" onclick="edit(\''
                                + row.id
                                + '\')"><i class="fa fa-edit "></i></a> ';
                            var d = '<a class="btn btn-warning btn-sm ' + s_remove_h + '" href="#" title="删除"  mce_href="#" onclick="remove(\''
                                + row.id
                                + '\')"><i class="fa fa-remove"></i></a> ';
                            var f = '<a class="btn btn-success btn-sm ' + s_resetPwd_h + '" href="#" title="重置密码"  mce_href="#" onclick="resetPwd(\''
                                + row.id
                                + '\')"><i class="fa fa-key"></i></a> ';
                            return e + d + f;
                        }
                    }
                ]
        });
    }else if(status == "3"){

    }
}

function save() {

    var rows = $('#exampleTable').bootstrapTable('getSelections'); // 返回所有选择的行，当没有选择的记录时，返回一个空数组
    if (rows.length == 0) {
        layer.msg("请选择要添加的用户。");
        return;
    }

    $.ajax({
        cache: true,
        type: "POST",
        url: "/emrsys/user/save",
        data: JSON.stringify(rows),
        dataType: "json",
        contentType: "application/json; charset=utf-8",
        async: false,
        error: function (request) {
            parent.layer.alert("Connection error");
        },
        success: function (data) {
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

function reLoad() {
    $('#exampleTable').bootstrapTable('refresh');
}
function add(empId) {
    // iframe层
    layer.open({
        type: 2,
        title: '增加用户',
        maxmin: true,
        shadeClose: false,
        area: ['800px', '520px'],
        content: '/emrsys/user/add/' + empId
    });
}
function remove(id) {
    layer.confirm('确定要删除选中的记录？', {
        btn: ['确定', '取消']
    }, function () {
        $.ajax({
            url: "/emrsys/user/remove",
            type: "post",
            data: {
                'userId': id
            },
            success: function (r) {
                if (r.code == 1) {
                    layer.msg(r.msg);
                    reLoad();
                } else {
                    layer.msg(r.msg);
                }
            }
        });
    })
}
function edit(id) {
    layer.open({
        type: 2,
        title: '用户修改',
        maxmin: true,
        shadeClose: false,
        area: ['800px', '600px'],
        content: '/emrsys/user/edit/' + id
    });
}
function resetPwd(id) {
    layer.open({
        type: 2,
        title: '重置密码',
        maxmin: true,
        shadeClose: false, // 点击遮罩关闭层
        area: ['400px', '260px'],
        content: '/emrsys/user/resetPassWord/' + id // iframe的url
    });
}
function batchRemove() {
    var rows = $('#exampleTable').bootstrapTable('getSelections'); // 返回所有选择的行，当没有选择的记录时，返回一个空数组
    if (rows.length == 0) {
        layer.msg("请选择要删除的数据");
        return;
    }
    layer.confirm("确认要删除选中的'" + rows.length + "'条数据吗?", {
        btn: ['确定', '取消']
        // 按钮
    }, function () {
        var ids = new Array();
        // 遍历所有选择的行数据，取每条数据对应的ID
        $.each(rows, function (i, row) {
            ids[i] = row['userId'];
        });
        $.ajax({
            type: 'POST',
            data: {
                "ids": ids
            },
            url: '/emrsys/user/batchRemove',
            success: function (r) {
                if (r.code == 0) {
                    layer.msg(r.msg);
                    reLoad();
                } else {
                    layer.msg(r.msg);
                }
            }
        });
    }, function () {
    });
}