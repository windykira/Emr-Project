$(function(){

    initTable($("#hisCallType").val());
})

function cancel(){

    var index = parent.layer.getFrameIndex(window.name);
    parent.layer.close(index);
}
var element = "";

function initTable(hisCallType){
    if(hisCallType=="1"){//检查
        initTableJc();
    }
    if(hisCallType=="2"){//检验
        initTableJy();
    }
}
function initTableJc(){
    $("#checkUp").bootstrapTable(
        {
            method: 'get', // 服务器数据的请求方式 get or post
            url: "/template/temp/getHisInfoByUrlParam/HIS_PATIENT_IN_CHECKUP", // 服务器数据的加载地址
            iconSize: 'outline',
            toolbar: '#exampleToolbar',
            /*onCheck:function(row,$element){
                //$element.children().toggleClass("rowChecked");
                $(element).parent().parent().children().addClass("rowChecked");
            },*/
            striped: true, // 设置为true会有隔行变色效果
            dataType: "json", // 服务器返回的数据类型
            // pagination: true, // 设置为true会在底部显示分页条
            singleSelect: false, // 设置为true将禁止多选
            // pageSize: 10, // 如果设置了分页，每页数据条数
            // pageNumber: 1, // 如果设置了分布，首页页码
            showColumns: false, // 是否显示内容下拉框（选择显示的列）
            // sidePagination: "client", // 设置在哪里进行分页，可选值为"client" 或者 server
            sortable: true,                     //是否启用排序
            sortOrder: "asc",
            queryParams : function (params){
                return {
                    as_patientId: '0008032316',//parent.document.getElementById("patient_patientId").innerHTML
                    }
            },
            columns: [
                {
                    checkbox: true
                },
                {
                    field: 'REPORT_DATE_TIME',
                    title: '报告日期'
                },
                {
                    field: 'EXAM_NO',
                    title: '检查单号'
                },
                {
                    field: 'EXAM_ITEM',
                    title: '检查项目'
                },
                {
                    field: 'DESCRIPTION',
                    title: '印象可见'
                },
                {
                    field: 'IMPRESSION',
                    title: '检查结论'
                }
            ]
        });
}


    function initTableJy(hisCallType){
        element = $("#inspect");
        var columns = [
            //{
            //    checkbox: true
            //},
            {
                field: 'RESULT_DATE_TIME',
                title: '报告日期'
            },
            {
                field: 'TEST_NO',
                title: '检验单号'
            },
            {
                field: 'SPECIMEN',
                title: '检验项目名称'
            },
            {
                field: '',
                title: '操作',
                formatter:function(value, row, index){
                    return '<a style="color:black;text-decoration:underline;cursor: pointer" onclick=jyDetail("'+row.TEST_NO+'",this)>查看检验明细</a>';
                }
            }
        ];
        element.bootstrapTable(
            {
                method: 'get', // 服务器数据的请求方式 get or post
                url: "/template/temp/getHisInfoByUrlParam/HIS_PATIENT_IN_COLLECTINSPECT",  // 服务器数据的加载地址
                iconSize: 'outline',
                //toolbar: '#exampleToolbar',
                /*onCheck:function(row,$element){
                 //$element.children().toggleClass("rowChecked");
                 $(element).parent().parent().children().addClass("rowChecked");
                 },*/
                striped: true, // 设置为true会有隔行变色效果
                dataType: "json", // 服务器返回的数据类型
                //pagination: true, // 设置为true会在底部显示分页条
                singleSelect: false, // 设置为true将禁止多选
                //pageSize: 10, // 如果设置了分页，每页数据条数
                //pageNumber: 1, // 如果设置了分布，首页页码
                showColumns: false, // 是否显示内容下拉框（选择显示的列）
                //sidePagination: "client", // 设置在哪里进行分页，可选值为"client" 或者 server
                //sortable: true,                     //是否启用排序
                //sortOrder: "asc",
                uniqueId : 'TEST_NO',
                queryParams : {
                    as_patientId: '0008032316',//parent.document.getElementById("patient_patientId").innerHTML
                },
                columns: columns
            });
    }

    function jyDetail(no,item){
        if($("#son_"+no).length>0){
            $("#tr_"+no).toggle();
        }else{

            $(item).parent().parent().after("<tr id='tr_"+no+"'><td colspan='4' style='padding:0'><table id='son_"+no+"' class='son_table'></table></td></tr>");
            $("#son_"+no).bootstrapTable(
                {
                    method: 'get', // 服务器数据的请求方式 get or post
                    url: "/template/temp/getHisInfoByUrlParam/HIS_PATIENT_IN_DETAILINSPECT",  // 服务器数据的加载地址
                    queryParams : {
                        as_test_no:no,
                        as_patientId: '0008032316',//parent.document.getElementById("patient_patientId").innerHTML
                    },
                    iconSize: 'outline',
                    //toolbar: '#exampleToolbar',
                    /*onCheck:function(row,$element){
                     //$element.children().toggleClass("rowChecked");
                     $(element).parent().parent().children().addClass("rowChecked");
                     },*/
                    striped: true, // 设置为true会有隔行变色效果
                    dataType: "json", // 服务器返回的数据类型
                    //pagination: true, // 设置为true会在底部显示分页条
                    singleSelect: false, // 设置为true将禁止多选
                    //pageSize: 10, // 如果设置了分页，每页数据条数
                    //pageNumber: 1, // 如果设置了分布，首页页码
                    showColumns: false, // 是否显示内容下拉框（选择显示的列）
                    //sidePagination: "client", // 设置在哪里进行分页，可选值为"client" 或者 server
                    //sortable: true,                     //是否启用排序
                    //sortOrder: "asc",
                    uniqueId : 'checkNo',
                    //queryParams : params,
                    columns: [
                        {
                            checkbox: true
                        },
                        {
                            field: 'REPORT_ITEM_CODE',
                            title: '报告项目代码'
                        },
                        {
                            field: 'REPORT_ITEM_NAME',
                            title: '报告项目名称'
                        },
                        {
                            field: 'RESULT',
                            title: '结果'
                        },
                        {
                            field: 'ABNORMAL_INDICATOR',
                            title: '异常'
                        },
                        {
                            field: 'UNITS',
                            title: '单位'
                        },
                        {
                            field: 'TEXT_RANGE',
                            title: '正常参考值'
                        },
                    ]
                });
        }

    }

    function importReport(){

        switch ($("#hisCallType").val()) {
            case "11"://检查
                var rows = element.bootstrapTable('getSelections');
                if(rows.length==0){
                    var index = parent.layer.getFrameIndex(window.name);
                    parent.layer.close(index);
                    return;
                }
                var reportContent = "";
                var count = 0;
                var myWriter = parent.myWriter;
                var old = "";
                var input = myWriter.Document.GetElementById("jcxx");
                if (input != null) {
                    input = myWriter.ComConvertToXTextInputFieldElement(input);
                    if (input != null) {
                        old = input.Text;
                        input.Text = "";
                        input.focus();
                    }
                }
                $.each(rows, function (i, row) {
                    count++;
                    if(old.indexOf(row.EXAM_ITEM)<0){
                        old += "\r\n查 " + row.EXAM_ITEM + "，示 " + row.IMPRESSION.replace(/\s/g,"");
                    }
                });
                input.Text = old;
                var index = parent.layer.getFrameIndex(window.name);
                parent.layer.close(index);
                break;
            case "22"://检验
                var all = "";
                var reportContent = "";
                var old = "";
                var myWriter = parent.myWriter;
                var input = myWriter.Document.GetElementById("jyxx");
                if (input != null) {
                    input = myWriter.ComConvertToXTextInputFieldElement(input);
                    if (input != null) {
                        old = input.Text;
                        input.focus();
                    }
                }

                for(var i= 0;i<$(".son_table").length;i++){
                    var tb = $(".son_table")[i];
                    var rows = $(tb).bootstrapTable('getSelections');
                    if(rows.length==0){
                        continue;
                    }
                    var no = tb.id.replace("son_","");
                    var f_row = $('#inspect').bootstrapTable('getRowByUniqueId', no);
                    var name =  f_row.SPECIMEN;
                    if(old.indexOf("【"+name+"】")<0) {//没有检验大项
                        var resultItem = "\r\n查【" + name + "】：示【";
                        var count = 0;

                        //var myWriter = parent.myWriter;
                        $.each(rows, function (i, row) {
                            var punc = "，";
                            if (i == rows.length - 1) {
                                punc = "";
                            }
                            count++;
                            resultItem += row.REPORT_ITEM_NAME + " " + row.RESULT + row.UNITS + punc;
                        });
                        resultItem += "】";
                        reportContent += resultItem;
                    }else{//已有检验大项
                        var old_rec_index = old.indexOf("查【"+name+"】")
                        var old_rec_end_index = old.indexOf("】",old.indexOf("【",old_rec_index+2)+1);
                        var old_rec = old.substring(old_rec_index, old_rec_end_index);
                        $.each(rows, function (i, row) {
                            if(old_rec.indexOf(row.REPORT_ITEM_NAME)<0){//检验小项新增
                                old_rec += "，"+ row.REPORT_ITEM_NAME + " " + row.RESULT + row.UNITS;
                            }
                        });
                        reportContent += "\r\n" + old_rec + "】";
                    }
                }
                //console.log(reportContent);
                if(reportContent==""){
                    var index = parent.layer.getFrameIndex(window.name);
                    parent.layer.close(index);
                    return;
                }

                //myWriter.ExecuteCommand("InsertString", false, reportContent);
                input.Text = reportContent;
                var index = parent.layer.getFrameIndex(window.name);
                parent.layer.close(index);

                //var rows = element.bootstrapTable('getSelections');
                //var reportContent = "\r\n检验：";
                //var count = 0;
                //var myWriter = parent.myWriter;
                //$.each(rows, function (i, row) {
                //    count++;
                //    reportContent += "\r\n" + count + "." + row.REPORT_ITEM_NAME + " " + row.RESULT + row.UNITS ;
                //});
                //var input = myWriter.Document.GetElementById("jyxx");
                //if (input != null) {
                //    input = myWriter.ComConvertToXTextInputFieldElement(input);
                //    if (input != null) {
                //        input.Text = "";
                //        input.focus();
                //    }
                //}
                //myWriter.ExecuteCommand("InsertString", false, reportContent);
                //var index = parent.layer.getFrameIndex(window.name);
                //parent.layer.close(index);
                break;
            case "1"://器械检查
                var rows = element.bootstrapTable('getSelections');
                if(rows.length==0){
                    var index = parent.layer.getFrameIndex(window.name);
                    parent.layer.close(index);
                    return;
                }
                var reportContent = "";
                var count = 0;
                var myWriter = parent.myWriter;
                var old = "";
                var input = myWriter.Document.GetElementById("jcxx2");
                if (input != null) {
                    input = myWriter.ComConvertToXTextInputFieldElement(input);
                    if (input != null) {
                        input.Text="";
                        input.focus();
                    }
                }
                $.each(rows, function (i, row) {
                    var input_reason = myWriter.ComCreateXTextInputFieldElement();
                    input_reason.name = "原因分析";
                    input_reason.BackgroundText = "原因分析";
                    input_reason.startBorderText = "【";
                    input_reason.endBorderText = "】";
                    var input_act = myWriter.ComCreateXTextInputFieldElement();
                    input_act.name = "处理措施";
                    input_act.BackgroundText = "处理措施";
                    input_act.startBorderText = "【";
                    input_act.endBorderText = "】";
                    var str =  "（ " + row.REPORT_DATE_TIME + "，我院门诊） 查" + row.EXAM_ITEM + "示" + row.IMPRESSION.replace(/\s/g,"") + "\r\n";
                    myWriter.ExecuteCommand("InsertString", false, str);
                    myWriter.ExecuteCommand("InsertInputField", false, input_reason);
                    myWriter.ExecuteCommand("InsertInputField", false, input_act);
                });
                // input.Text = old;
                var index = parent.layer.getFrameIndex(window.name);
                parent.layer.close(index);
                break;
            case "2"://器械检验
                var all = "";
                var reportContent = "";
                var old = "";
                var myWriter = parent.myWriter;
                var input = myWriter.Document.GetElementById("jyxx2");
                if (input != null) {
                    input = myWriter.ComConvertToXTextInputFieldElement(input);
                    if (input != null) {
                        input.Text="";
                        input.focus();
                    }
                }

                for(var i= 0;i<$(".son_table").length;i++){
                    var tb = $(".son_table")[i];
                    var rows = $(tb).bootstrapTable('getSelections');
                    if(rows.length==0){
                        continue;
                    }
                    var no = tb.id.replace("son_","");
                    var f_row = $('#inspect').bootstrapTable('getRowByUniqueId', no);
                    var name =  f_row.SPECIMEN;
                    // if(old.indexOf("【"+name+"】")<0) {//没有检验大项
                        var resultItem = "（" + f_row.RESULT_DATE_TIME + "，我院门诊）查【" + name + "】：示【";
                        var count = 0;

                        //var myWriter = parent.myWriter;
                    $.each(rows, function (i, row) {
                        var punc = "，";
                        if (i == rows.length - 1) {
                            punc = "";
                        }
                        count++;
                        resultItem += row.REPORT_ITEM_NAME + " " + row.RESULT + row.UNITS + punc;
                    });
                    resultItem += "】";

                    var input_reason = myWriter.ComCreateXTextInputFieldElement();
                    input_reason.name = "原因分析";
                    input_reason.BackgroundText = "原因分析";
                    input_reason.startBorderText = "【";
                    input_reason.endBorderText = "】";
                    var input_act = myWriter.ComCreateXTextInputFieldElement();
                    input_act.name = "处理措施";
                    input_act.BackgroundText = "处理措施";
                    input_act.startBorderText = "【";
                    input_act.endBorderText = "】";
                    myWriter.ExecuteCommand("InsertString", false, resultItem);
                    myWriter.ExecuteCommand("InsertInputField", false, input_reason);
                    myWriter.ExecuteCommand("InsertInputField", false, input_act);
                        // reportContent += resultItem;
                    // }else{//已有检验大项
                    //     var old_rec_index = old.indexOf("查【"+name+"】")
                    //     var old_rec_end_index = old.indexOf("】",old.indexOf("【",old_rec_index+2)+1);
                    //     var old_rec = old.substring(old_rec_index, old_rec_end_index);
                    //     $.each(rows, function (i, row) {
                    //         if(old_rec.indexOf(row.REPORT_ITEM_NAME)<0){//检验小项新增
                    //             old_rec += "，"+ row.REPORT_ITEM_NAME + " " + row.RESULT + row.UNITS;
                    //         }
                    //     });
                    //     reportContent += "\r\n" + old_rec + "】\r\n";
                    // }
                }
                var index = parent.layer.getFrameIndex(window.name);
                parent.layer.close(index);

                //var rows = element.bootstrapTable('getSelections');
                //var reportContent = "\r\n检验：";
                //var count = 0;
                //var myWriter = parent.myWriter;
                //$.each(rows, function (i, row) {
                //    count++;
                //    reportContent += "\r\n" + count + "." + row.REPORT_ITEM_NAME + " " + row.RESULT + row.UNITS ;
                //});
                //var input = myWriter.Document.GetElementById("jyxx");
                //if (input != null) {
                //    input = myWriter.ComConvertToXTextInputFieldElement(input);
                //    if (input != null) {
                //        input.Text = "";
                //        input.focus();
                //    }
                //}
                //myWriter.ExecuteCommand("InsertString", false, reportContent);
                //var index = parent.layer.getFrameIndex(window.name);
                //parent.layer.close(index);
                break;
        }

    }
