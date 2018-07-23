$(function () {

    //初始化病历目录数据
    loadEmrCataLog();

    $("#searchName").keyup(function () {
        selectNode();
    });
});

function selectNode(){

    if ($("#searchName").val() != '') {
        var nodes = zTree.getNodesByParamFuzzy("name", $("#searchName").val(), null);
        if (nodes.length > 0) {
            zTree.selectNode(nodes[0]);
            $.ajax({
                type: "GET",
                url: "/template/medicalrecord/get/" + nodes[0].id,
                success: function (data) {
                    data.emrCataLog.pkFatherName = data.pkFatherName;
                    $('#catalogForm').initForm(data.emrCataLog);
                }
            });
        }
    }
}

function addCatalog() {

    layer.open({
        type: 2,
        title: "新增目录",
        shadeClose: true,
        area: ['780px', '710px'],
        skin: 'layui-layer-molv',
        offset: 't',
        content: "/template/medicalrecord/add"
    })
}

function openCatalog() {
    layer.open({
        type: 2,
        title: "选择上级目录",
        shadeClose: true,
        area: ['400px', '600px'],
        skin: 'layui-layer-molv',
        content: "/template/medicalrecord/catalogTree",
        btn: ['确定', '取消',],
        yes: function (index, layero) {
            var iframeWin = window[layero.find('iframe')[0]['name']];
            var object = iframeWin.callBack();
            layer.close(index);
            $("#pkFatherName").val(object.catalogName);
        }
    })
}

var zTree = "";
function loadEmrCataLog() {
    var setting = {
        data: {
            simpleData: {
                enable: true
            }
        },
        callback: {
            onClick: function (event, treeId, treeNode) {

                $.ajax({
                    type: "GET",
                    url: "/template/medicalrecord/get/" + treeNode.id,
                    success: function (data) {
                        data.emrCataLog.pkFatherName = data.pkFatherName;
                        $('#catalogForm').initForm(data.emrCataLog);
                    }
                });
            }
        }
    };
    $.ajax({
        type: "GET",
        url: "/emr/catalog/list",
        success: function (data) {
            zTree = $.fn.zTree.init($("#treeRm"), setting, data);
            zTree.expandAll(false);
        }
    });
}

function deleteCatalog() {

    var selectedNodes = zTree.getSelectedNodes();
    if (selectedNodes.length == 0) {
        layer.alert("请选择要删除的病历目录。");
        return;
    }

    var selectedNode = selectedNodes[0];
    if (selectedNode.isParent) {
        layer.alert("该节点有子节点不能删除。");
        return;
    }

    layer.confirm('确定要删除该目录么?', function (index) {
        $.ajax({
            type: "POST",
            data: {
                'catalogId': selectedNode.id
            },
            url: "/template/medicalrecord/delete",
            success: function (data) {
                if (data.code == 1) {
                    layer.msg("删除成功。");
                    loadEmrCataLog();
                    layer.close(index);
                } else {
                    layer.alert(data.msg)
                }
            }
        });
    });
    /*$.ajax({
     type: "GET",
     url: "/template/medicalrecord/count/" + selectedNode.id,
     success: function (data) {
     if (data > 0) {
     layer.alert("该节点已关联模板类型，无法删除。");
     } else {
     layer.confirm('确定要删除该目录么?', function(index){
     $.ajax({
     type: "POST",
     data: {
     'catalogId': selectedNode.id
     },
     url: "/template/medicalrecord/delete",
     success: function (data) {
     if (data.code == 1){
     layer.msg("删除成功。");
     loadEmrCataLog();
     layer.close(index);
     }else {
     layer.alert(data.msg)
     }
     }
     });
     });
     }
     }
     });*/
}

function updateCatalog() {

    var checkedNodes = zTree.getSelectedNodes();
    if (checkedNodes.length == 0) {
        layer.alert("请选择要修改的病历目录。");
        return;
    }
    if (checkedNodes[0].isParent) {
        layer.alert("请选择要修改的病历目录。");
        return;
    }
    layer.open({
        type: 2,
        title: "修改目录",
        shadeClose: true,
        area: ['780px', '710px'],
        skin: 'layui-layer-molv',
        content: "/template/medicalrecord/edit/" + checkedNodes[0].id

    })
}
