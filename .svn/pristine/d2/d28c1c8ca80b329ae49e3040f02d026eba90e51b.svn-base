
var prefix = "/template/temp";
var templateName;
var templateCode;
var rangeSel;
var typeSel;
var catalogId;
var patientTypeSel;
var statusSel;
var currentEditId;
var openFlag = 0;
var jsFileName;
$(function() {
	load();
    loadEmrCataLog();
});

function load() {
     //$(".selectpicker").selectpicker({
     //    noneSelectedText : '请选择',//默认显示内容
     //    width: 100,
     //    style: 'btn-white',
     //    liveSearch: false
     //});
	 $.ajax({  
         type : 'get',  
         url : prefix + "/getTypes",  
         dataType : 'json',  
         success : function(datas) {//返回list数据并循环获取  
             var select = $("#type_sel");
             select.append("<option value=''> </option>");
             for (var i = 0; i < datas.length; i++) {  
                 select.append("<option value='"+datas[i].PK_TMP_CLASS+"'>"  
                         + datas[i].NAME_CLASS + "</option>");  
             }  
        	 var select = $("#status_sel");
             select.append("<option value=''> </option>");
             select.append("<option value='0'>可用</option>");
             select.append("<option value='1'>不可用</option>");
        	 
        	 var select = $("#range_sel");
             select.append("<option value=''> </option>");
             select.append("<option value='1'>全院</option>");
             select.append("<option value='2'>科室</option>");
        	 select.append("<option value='3'>个人</option>");

         }
     });  
	 $('#exampleTable')
     .bootstrapTable(
         {
             method: 'get', // 服务器数据的请求方式 get or post
             url: prefix + "/list", // 服务器数据的加载地址
             cache: false,//禁用缓存 默认为true
             // showRefresh : true,
             // showToggle : true,
             // showColumns : true,
             iconSize: 'outline',
             //toolbar: '#exampleToolbar',
             striped: true, // 设置为true会有隔行变色效果
             dataType: "json", // 服务器返回的数据类型
             pagination: true, // 设置为true会在底部显示分页条
             // queryParamsType : "limit",
             // //设置为limit则会发送符合RESTFull格式的参数
             singleSelect: false, // 设置为true将禁止多选
             // contentType : "application/x-www-form-urlencoded",
             // //发送到服务器的数据编码类型
             pageSize: 10, // 如果设置了分页，每页数据条数
             pageNumber: 1, // 如果设置了分布，首页页码
             // search : true, // 是否显示搜索框
             showColumns: false, // 是否显示内容下拉框（选择显示的列）
             sidePagination: "server", // 设置在哪里进行分页，可选值为"client" 或者 server
             sortable: true,                     //是否启用排序
             sortOrder: "asc",
             uniqueId : 'pkTemplate',
             // "server"
             queryParams: function (params) {
                 return {
                     // 说明：传入后台的参数包括offset开始索引，limit步长，sort排序列，order：desc或者,以及所有列的键值对
                     limit: params.limit,
                     //offset: params.offset,
                     //pageNumber:params.limit,//每页记录数
                     //pageSize:(params.offset / params.limit) + 1,//页码
                     page:(params.offset / params.limit) + 1,
                     sort: params.sort,      //排序列名
                     sortOrder: params.order, //排位命令（desc，asc）
                     range: $('#range_sel').val(),
                     type : $('#type_sel').val(),
                     status : $('#status_sel').val(),
                     name : $('#name').val(),
                     cata : $('#cata').val()
                 };
             },
             // //请求服务器数据时，你可以通过重写参数的方式添加一些额外的参数，例如 toolbar 中的参数 如果
             // queryParamsType = 'limit' ,返回参数必须包含
             // limit, offset, search, sort, order 否则, 需要包含:
             // pageSize, pageNumber, searchText, sortName,
             // sortOrder.
             // 返回false将会终止请求
             columns: [
                 //{
                 //    checkbox: true
                 //},
                 {
                     field: 'codeTmp',
                     title: '模板代码'
                 },
                 {
                     field: 'nameTmp',
                     title: '模板名称',
                 },
                 {
                     field: 'tmpClassName',
                     title: '模板类型',
                 },
                 {
                     field: 'range',
                     title: '适用范围',
                     formatter: function (value, row, index) {
                         if(value==='1'){
                             return '全院';
                         }
                         if(value==='2'){
                             return '科室';
                         }
                         if(value==='3'){
                             return '个人';
                         }
                     }
                 },
                 {
                     field: 'deptName',
                     title: '创建科室',
                 },
                 {
                     field: 'creatorName',
                     title: '创建人',
                 },
                 {
                     field: 'createTimeString',
                     title: '创建时间',
                 },
                 {
                     field: 'pkTemplate', // 列字段名
                     title: '操作', // 列标题
                     formatter : function(value, row, index) {
                         //var btn = '<button type="button" class="btn  btn-primary" onclick="openWriting('+row.PATIENT_ID+')"><i class="fa fa-plus hidden" aria-hidden="true"></i>写病历 </button>';
                         var statusName = "";
                         if(row.stopFlag === '0') statusName="停用";
                         if(row.stopFlag === '1') statusName="启用";
                         var btns = '<button class="btn btn-default btn-sm" type="button" onclick=editTemplate("'+row.pkTemplate+'")>编辑</button>&nbsp;&nbsp;' +
                              '<button class="btn btn-default btn-sm" type="button" onclick=changeStatus("'+row.pkTemplate+'","'+row.stopFlag+'")>'+statusName+'</button>&nbsp;&nbsp;' +
                              '<button class="btn btn-default btn-sm" type="button" onclick=deleteTemplate("'+row.pkTemplate+'")>删除</button>';
                         return btns;
                     }
                 }
                ]
         });
}
function reLoad() {
	$('#exampleTable').bootstrapTable('refresh');
}
function add() {
    currentEditId = null;
    var cataId = "";
    var cataName = "";
    if(zTree.getSelectedNodes()[0]&&zTree.getSelectedNodes()[0].level===2){
        cataId = zTree.getSelectedNodes()[0].id;
        cataName = zTree.getSelectedNodes()[0].name;
    }
	layer.open({
		type : 2,
		title : '增加',
		maxmin : true,
		shadeClose : false, // 点击遮罩关闭层
		area : [ '800px', '520px' ],
        skin: 'layui-layer-molv',
		content : prefix + '/add',
        success : function(layero,index){
            var iframeWin = window[layero.find('iframe')[0]['name']];
            iframeWin.jQuery("#catalogId").val(cataId)
            iframeWin.jQuery("#catalogName").val(cataName)
		}
	});
}
var index1;
function loadEditPage(){
    window.open('/emr/dc/index');
}
// function loadEditPageQY(){//新增模板前先加载全院模板
//     window.open('/emr/dc/index');
// }
var zTree;
//var selectNodes = zTree.getSelectedNodes();
function loadEmrCataLog() {
    var setting = {
        data: {
            simpleData: {
                enable: true
            }
        },
        callback: {
            onClick: function (event, treeId, treeNode) {
                if(treeNode.level === 2){
                    $('#cata').val(treeNode.id);
                    reLoad();
                }
            }
        }
    };
    $.ajax({
        type: "GET",
        url: "/emr/catalog/list",
        success: function (data) {
            zTree = $.fn.zTree.init($("#treeDemo"), setting, data);
            zTree.expandAll(true);
        }
    });
}

function editTemplate(id){
    var row = $('#exampleTable').bootstrapTable('getRowByUniqueId', id);
    currentEditId = id;
    layer.open({
        type : 2,
        title : '增加',
        maxmin : true,
        shadeClose : false, // 点击遮罩关闭层
        area : [ '800px', '520px' ],
        skin: 'layui-layer-molv',
        content : prefix + '/edit',
        success : function(layero,index){
            var iframeWin = window[layero.find('iframe')[0]['name']];
            iframeWin.jQuery("#templateCode").val(row.codeTmp);
            iframeWin.jQuery("#catalogName").val(row.nameCatalog);
            iframeWin.jQuery("#catalogId").val(row.pkCatalog);
            iframeWin.jQuery("#templateName").val(row.nameTmp);
            iframeWin.jQuery("#rangeSel").val(row.range);
            iframeWin.jQuery("#patientTypeSel").val(row.patientType);
            iframeWin.jQuery("#statusSel").val(row.stopFlag);
            iframeWin.editFlag = true;
            //编辑子页面加载下拉完成后 自动填入当前父页面的typesSel值
            typeSel = row.pkTmpClass;
        }
    });
}
function deleteTemplate(id){
    $.ajax({
        url : "/template/temp/deleteTemplate",
        type : "GET",
        data : {id:id},
        dataType :"json",
        success:function(data){
            if (data.code == 1) {
                layer.msg("操作成功");
                reLoad();
            } else {
                layer.alert(data.msg)
            }
        },
        error:function(){
            layer.alert("发生错误");
        }
    })
}
function changeStatus(id,status){
    var url = "";
    if(status === '0') url = "/template/temp/stopUsing";
    if(status === '1') url = "/template/temp/startUsing";
    $.ajax({
        url : url,
        type : "GET",
        data : {id:id},
        dataType :"json",
        success:function(data){
            if (data.code == 1) {
                layer.msg("操作成功");
                reLoad();
            } else {
                layer.alert(data.msg)
            }
        },
        error:function(){
            layer.alert("发生错误");
        }
    })
}
