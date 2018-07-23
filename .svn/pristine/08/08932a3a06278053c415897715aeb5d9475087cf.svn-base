$(function(){
    //医嘱
    $("#btnPop1").click(function(){

        var columns = [
            {
                checkbox: true
            },
            {
                field: 'patientId',
                title: '住院号',
                formatter: function (value, row, index) {
                    return index + 1;
                }
            },
            {
                field: 'orderText',
                title: '医嘱内容'
            },
            {
                field: 'freqDetail',
                title: '医嘱辅助信息'
            },
            {
                field: 'startDateTime',
                title: '医嘱开始日期'
            },
            {
                field: 'endDateTime',
                title: '医嘱停止日期'
            }
        ];
        var params = {
                hisCallType:"1",
                patientId:"343939"
            };
        initTable("/emr/emrwriting/listHisResponseDatas",$("#doctorAdvice"),columns,params);
        $("#boxPop1").slideDown("slow");
        $("#boxPop2,#boxPop3,#boxPop4,#boxPop5").slideUp(200);
    });

    //检查
    $("#btnPop2").click(function(){

        var columns = [
            {
                checkbox: true
            },
            {
                field: 'checkNo',
                title: '编号',
                formatter: function (value, row, index) {
                    return index + 1;
                }
            },
            {
                field: 'checkClass',
                title: '检查类型'
            },
            {
                field: 'applyTime',
                title: '时间'
            }
        ];
        var params = {
            hisCallType:"2",
            patientId:"852307"
        };
        initTable("/emr/emrwriting/listHisResponseDatas",$("#checkUp"),columns,params);
        $("#boxPop2").slideDown("slow");
        $("#boxPop1,#boxPop3,#boxPop4,#boxPop5").slideUp(200);
    });

    //检验
    $("#btnPop3").click(function(){

        var columns = [
            {
                checkbox: true
            },
            {
                field: 'checkNo',
                title: '编号',
                formatter: function (value, row, index) {
                    return index + 1;
                }
            },
            {
                field: 'checkClass',
                title: '检查类型'
            },
            {
                field: 'applyTime',
                title: '时间'
            }
        ];
        var params = {
            hisCallType:"3",
            patientId:"872745"
        };
        initTable("/emr/emrwriting/listHisResponseDatas",$("#inspect"),columns,params);
        $("#boxPop3").slideDown("slow");
        $("#boxPop1,#boxPop2,#boxPop4,#boxPop5").slideUp(200);
    });

    //处方
    $("#btnPop4").click(function(){
        var columns = [
            {
                checkbox: true
            },
            {
                field: 'patientId',
                title: '编号',
                formatter: function (value, row, index) {
                    return index + 1;
                }
            },
            {
                field: 'orderedBy',
                title: '科室'
            },
            {
                field: 'performedNameBy',
                title: '药房'
            },
            {
                field: 'prescriber',
                title: '姓名'
            }
        ];
        var params = {
            hisCallType:"4",
            patientId:"0002648607"
        };
        initTable("/emr/emrwriting/listHisResponseDatas",$("#prescription"),columns,params);
        $("#boxPop4").slideDown("slow");
        $("#boxPop1,#boxPop2,#boxPop3,#boxPop5").slideUp(200);
    });

    //手术
    $("#btnPop5").click(function(){
        $("#boxPop5").slideDown("slow");
        $("#boxPop1,#boxPop2,#boxPop3,#boxPop4").slideUp(200);
    });

    $(".pop-box .close").click(function(){
        $(this).parents(".pop-box").slideUp(200);
    });

})


function initTable(url,element,columns,params){

    element.bootstrapTable(
            {
                method: 'get', // 服务器数据的请求方式 get or post
                url: url, // 服务器数据的加载地址
                iconSize: 'outline',
                toolbar: '#exampleToolbar',
                striped: true, // 设置为true会有隔行变色效果
                dataType: "json", // 服务器返回的数据类型
                pagination: true, // 设置为true会在底部显示分页条
                singleSelect: false, // 设置为true将禁止多选
                pageSize: 10, // 如果设置了分页，每页数据条数
                pageNumber: 1, // 如果设置了分布，首页页码
                showColumns: false, // 是否显示内容下拉框（选择显示的列）
                sidePagination: "client", // 设置在哪里进行分页，可选值为"client" 或者 server
                sortable: true,                     //是否启用排序
                sortOrder: "asc",
                queryParams : params,
                /*queryParams: function (params) {
                    return {
                        //说明：传入后台的参数包括offset开始索引，limit步长，sort排序列，order：desc或者,以及所有列的键值对
                        limit: params.limit,
                        page:(params.offset / params.limit) + 1,
                        patientId:"343939"
                        sort: params.sort,      //排序列名
                         sortOrder: params.order, //排位命令（desc，asc）
                         name: $('#searchName').val(),
                         createStatus: $('input[name="status"]:checked').val()
                    };
                },*/
                columns: columns
            });
}