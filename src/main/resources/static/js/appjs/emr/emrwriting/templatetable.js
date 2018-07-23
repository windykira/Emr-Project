$(function () {
    loadTable("0");
});

function openCatalog() {
    layer.open({
        type: 2,
        title: "选择病历目录",
        shadeClose: true,
        area: ['400px', '560px'],
        skin: 'layui-layer-molv',
        offset:"t",
        content: "/template/medicalrecord/catalogTree/1" ,
        btn: ['确定', '取消',],
        yes: function (index, layero) {
            var iframeWin = window[layero.find('iframe')[0]['name']];
            var object = iframeWin.callBack();
            layer.close(index);
            $("#pkFatherName").val(object.catalogName);
            $("#pkFather").val(object.catalogId);
            loadTable(object.catalogId);
            parent.catalogId = object.catalogId;
            parent.catalogName = object.catalogName;
            parent.parentCatalogId = object.parentCatalogId;
            //reloadTemplateTable($(".nav-tabs").find(".active").attr("value"));
        }
    })
}

function loadTable(catalogId) {

    //var selectNodes = parent.zTree.getSelectedNodes();
    $.ajax({
        type: "GET",
        url: "/template/class/list/" + catalogId,
        success: function (datas) {

            $(".list-group").find("li").remove();
            $.each(datas, function (i, e) {
                if (i == 0) {
                    $(".list-group").append(" <li class='list-group-item active' style='cursor: pointer;' value=" + e.id + " onclick='reloadTemplate(this)'>" + e.nameClass + "</li>")
                } else {
                    $(".list-group").append(" <li class='list-group-item' style='cursor: pointer;' value=" + e.id + " onclick='reloadTemplate(this)'>" + e.nameClass + "</li>")
                }
            });

            if("0" == catalogId){
                //加载模板表格数据
                loadTemplateTable(1);
            }else{
                reloadTemplateTable($(".nav-tabs").find(".active").attr("value"));
            }
            $(".list-group li").click(function () {
                $(this).addClass("active").siblings(".active").removeClass("active");
            });
        }
    })
}

function loadTemplateTable(rangeValue) {

    $('#templateTable')
        .bootstrapTable(
            {
                method: 'get', // 服务器数据的请求方式 get or post
                url: "/template/class/listEmrTemplateClass", // 服务器数据的加载地址
                iconSize: 'outline',
                toolbar: '#exampleToolbar',
                striped: true, // 设置为true会有隔行变色效果
                dataType: "json", // 服务器返回的数据类型
                pagination: true, // 设置为true会在底部显示分页条
                singleSelect: true, // 设置为true将禁止多选
                pageSize: 10, // 如果设置了分页，每页数据条数
                pageNumber: 1, // 如果设置了分布，首页页码
                showColumns: false, // 是否显示内容下拉框（选择显示的列）
                sidePagination: "server", // 设置在哪里进行分页，可选值为"client" 或者 server
                sortable: true,                     //是否启用排序
                sortOrder: "asc",
                onCheck: function (row, $element) {
                    $("#templateTable").find("tbody").find("tr").css("background-color", "");
                    $element.parent().closest("tr").css("background-color", "#7ebfc1");

                },
                queryParams: function (params) {
                    return {
                        // 说明：传入后台的参数包括offset开始索引，limit步长，sort排序列，order：desc或者,以及所有列的键值对
                        limit: params.limit,
                        page: (params.offset / params.limit) + 1,
                        range: rangeValue,
                        catalogId:$("#pkFather").val(),
                        templateClassId: $(".list-group").find(".active").attr("value") == undefined ? "" : $(".list-group").find(".active").attr("value")
                        /*sort: params.sort,      //排序列名
                         sortOrder: params.order, //排位命令（desc，asc）
                         name: $('#searchName').val(),
                         createStatus: $('input[name="status"]:checked').val()*/
                    };
                },
                columns: [
                    {
                        checkbox: true
                    },
                    {
                        field: 'templateId',
                        title: '序号',
                        formatter: function (value, row, index) {
                            return index + 1;
                        }
                    },
                    {
                        field: 'templateName',
                        title: '模板名称',
                        sortable: true
                    },
                    {
                        field: 'creator',
                        title: '创建人'
                    },
                    {
                        field: 'createTime',
                        title: '创建时间'
                    }
                ]
            });
}

function reloadTemplate(e) {

    $('#templateTable').bootstrapTable('refreshOptions', {
        queryParams: function (params) {
            return {
                // 说明：传入后台的参数包括offset开始索引，limit步长，sort排序列，order：desc或者,以及所有列的键值对
                limit: params.limit,
                page: (params.offset / params.limit) + 1,
                range: $(".nav-tabs").find(".active").attr("value"),
                templateClassId: $(e).attr("value")
            };
        }
    });
}

function reloadTemplateTable(rangeValue) {

    $('#templateTable').bootstrapTable('refreshOptions', {
        queryParams: function (params) {
            return {
                // 说明：传入后台的参数包括offset开始索引，limit步长，sort排序列，order：desc或者,以及所有列的键值对
                limit: params.limit,
                page: (params.offset / params.limit) + 1,
                range: rangeValue,
                catalogId:$("#pkFather").val(),
                templateClassId: $(".list-group").find(".active").attr("value")
            };
        }
    });
}

function loadDcEditor() {

    var rows = $('#templateTable').bootstrapTable('getSelections');
    if (rows.length == 0) {
        layer.alert('请选择要加载的模板。');
        //alert("请选择要加载的模板。");
        return;
    }

    var ctl = parent.document.getElementById("myWriter");
    //ctl.ExecuteCommand("FileOpen", false, "/cab/index.xml");
    parent.templateId = rows[0].templateId;
    $.ajax({
        url: "/emr/dc/getTemplate/" + rows[0].templateId,
        dataType: "text",
        success: function (data) {
            ctl.ExecuteCommand("FileOpenString", false, data);
            parent.loadJS(rows[0].jsFileName,parent.info);
            // parent.temp_init(parent.info);
            parent.cancelSelectNode();
            var index = parent.layer.getFrameIndex(window.name);
            parent.layer.close(index);
        },
        error: function () {
            alert("读取出错");
        }
    })
}

function cancel() {
    var index = parent.layer.getFrameIndex(window.name);
    parent.layer.close(index);
}