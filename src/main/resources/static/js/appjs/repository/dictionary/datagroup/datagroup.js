$(function(){
    loadDataGroup();
});

function loadDataGroup(){

    $(".data-group").bootstrapTable('destroy');
    $('.data-group')
        .bootstrapTable(
            {
                method: 'get', // 服务器数据的请求方式 get or post
                url: "/repository/datagroup/list/", // 服务器数据的加载地址
                striped: true, // 设置为true会有隔行变色效果
                dataType: "json", // 服务器返回的数据类型
                pagination: true, // 设置为true会在底部显示分页条
                // queryParamsType : "limit",
                // //设置为limit则会发送符合RESTFull格式的参数
                singleSelect: false, // 设置为true将禁止多选
                iconSize: 'outline',
                toolbar: '#exampleToolbar',
                // contentType : "application/x-www-form-urlencoded",
                // //发送到服务器的数据编码类型
                pageSize: 10, // 如果设置了分页，每页数据条数
                pageNumber: 1, // 如果设置了分布，首页页码
                //search: true, // 是否显示搜索框
                //showColumns: true, // 是否显示内容下拉框（选择显示的列）
                sidePagination: "server", // 设置在哪里进行分页，可选值为"client" 或者"server"
                queryParams: function (params) {
                    return {
                        // 说明：传入后台的参数包括offset开始索引，limit步长，sort排序列，order：desc或者,以及所有列的键值对
                        limit: params.limit,
                        page:(params.offset / params.limit) + 1,
                        queryParam: $('#queryParam').val()
                    };
                },
                columns: [
                    {
                        field: 'ID',
                        title: '序号',
                        formatter: function (value, row, index) {
                            return index + 1;
                        }
                    },
                    {
                        field: 'codeDg',
                        title: '数据组编码'
                    },
                    {
                        field: 'nameDg',
                        title: '数据组名称'
                    },
                    {
                        field: 'describe',
                        title: '说明'
                    }]
            });
}