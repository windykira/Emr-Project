$(function () {
    loadDataElement();
});

function loadDataElement() {

    $('.data-element')
        .bootstrapTable(
            {
                method: 'get', // 服务器数据的请求方式 get or post
                url: "/repository/dataelement/list", // 服务器数据的加载地址
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
                        page: (params.offset / params.limit) + 1,
                        queryParam: $('#queryParam').val()
                    };
                },
                columns: [
                    {
                        field: 'pkDataElemt',
                        title: '序号',
                        formatter: function (value, row, index) {
                            return index + 1;
                        }
                    },
                    {
                        field: 'nameDe',
                        title: '数据元名称'
                    },
                    {
                        field: 'codeDe',
                        title: '数据元编码'
                    },
                    {
                        field: 'codeDe',
                        title: '数据元编码'
                    },
                    {
                        field: 'definition',
                        title: '数据元定义'
                    },
                    {
                        field: 'deValsType',
                        title: '数据元值的数据类型'
                    },
                    {
                        field: 'repFmt',
                        title: '数据元表示格式'
                    },
                    {
                        title: '操作',
                        field: 'pkDataElemt',
                        align: 'center',
                        formatter: function (value, row, index) {
                            var e = '<button  class="btn btn-primary' + '" href="#"  onclick="showElenentValues(\''
                                + value
                                + '\')">查看值域</button> ';
                            return e;
                        }
                    }]
            });
}

function showElenentValues(dataElementId) {

    layer.open({
        type: 2,
        title: "数据元值域查看",
        shadeClose: true,
        area: ['850px', '550px'],
        skin: 'layui-layer-molv',
        offset: 't',
        content: "/repository/dataelementvalues/" + dataElementId
    })
}