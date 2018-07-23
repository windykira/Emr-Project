var prefix = "/emrsys/kb/";
$(function() {
	load();
});

function load() {
	$('#exampleTable')
			.bootstrapTable(
					{
						method : 'get', // 服务器数据的请求方式 get or post
						url : prefix + "/list", // 服务器数据的加载地址
						striped : true, // 设置为true会有隔行变色效果
						dataType : "json", // 服务器返回的数据类型
						pagination : true, // 设置为true会在底部显示分页条
						// queryParamsType : "limit",
						// //设置为limit则会发送符合RESTFull格式的参数
						singleSelect : false, // 设置为true将禁止多选
						iconSize : 'outline',
						toolbar : '#exampleToolbar',
						// contentType : "application/x-www-form-urlencoded",
						// //发送到服务器的数据编码类型
						pageSize : 10, // 如果设置了分页，每页数据条数
						pageNumber : 1, // 如果设置了分布，首页页码
						search : true, // 是否显示搜索框
						showColumns : true, // 是否显示内容下拉框（选择显示的列）
						sidePagination : "client", // 设置在哪里进行分页，可选值为"client" 或者
						// "server"
						// queryParams : queryParams,
						// //请求服务器数据时，你可以通过重写参数的方式添加一些额外的参数，例如 toolbar 中的参数 如果
						// queryParamsType = 'limit' ,返回参数必须包含
						// limit, offset, search, sort, order 否则, 需要包含:
						// pageSize, pageNumber, searchText, sortName,
						// sortOrder.
						// 返回false将会终止请求
						columns : [
							{
								checkbox : true
							},
							{
								field : 'id', // 列字段名
								title : '序号', // 列标题
								formatter : function(value, row, index) {
									return index + 1;
								}
							},
							{
								field : 'sympCode',
								title : '症状编码'
							},
							{
								field : 'sympName',
								title : '症状名称'
							},
							{
								field : 'range',
								title : '使用范围',
								formatter:function(value){
									if(value == 'C'){return '全院';}
									if(value == 'D'){return '科室';}
								}
							},
							{
								title : '操作',
								field : 'ID',
								align : 'center',
								formatter : function(value, row, index) {
//									var f = '';
//									if (row.range == 'D'){
//										f = '<a class="btn btn-primary btn-sm '+s_deploy_dept+'" href="#" mce_href="#" title="配置可用科室" onclick="deployDept(\''
//										+ row.id
//										+ '\')"><i class="fa fa-envelope-o"></i></a> ';
//									}
//									var g = '<a class="btn btn-warning btn-sm '+s_deploy_simu+'" href="#" title="配置伴随症状"  mce_href="#" onclick="deploySimu(\''
//									+ row.id
//									+ '\')"><i class="fa fa-institution"></i></a> ';
									var e = '<a class="btn btn-primary btn-sm '+s_edit_h+'" href="#" mce_href="#" title="编辑" onclick="edit(\''
											+ row.id
											+ '\')"><i class="fa fa-edit"></i></a> ';
									var d = '<a class="btn btn-warning btn-sm '+s_remove_h+'" href="#" title="删除"  mce_href="#" onclick="remove(\''
											+ row.id
											+ '\')"><i class="fa fa-remove"></i></a> ';
									return e + d;
								}
							} 
							]
					});
}
function reLoad() {
	$('#exampleTable').bootstrapTable('refresh');
}
function add() {
	// iframe层
	layer.open({
		type : 2,
		title : '添加症状',
		maxmin : true,
		shadeClose : false, // 点击遮罩关闭层
		area : [ '800px', '520px' ],
		content : prefix + '/add' // iframe的url
	});
}
function remove(id) {
	layer.confirm('确定要删除选中的记录？', {
		btn : [ '确定', '取消' ]
	}, function() {
		$.ajax({
			url : prefix + "/remove",
			type : "post",
			data : {
				id : id
			},
			success : function(r) {
				if (r.code == 1) {
					layer.msg("删除成功");
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
		type : 2,
		title : '症状修改',
		maxmin : true,
		shadeClose : true, // 点击遮罩关闭层
		area : [ '800px', '520px' ],
		content : prefix + '/edit/' + id // iframe的url
	});
}
function deployDept() {}
function deploySimu() {}
