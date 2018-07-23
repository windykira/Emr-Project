//以下temp_开头的为固定function，
//初始化方法，模板加载后调用
function temp_init(data){
    bindDataSource(data);
}
//点击事件，编辑器中单击后调用
function temp_click(eventSender,eventArgs){
    click(eventSender,eventArgs)
}
//输入域修改事件，输入域内容修改后调用
function temp_field_change(eventSender,eventArgs){

}
//保存子模板事件，点击保存病历后调用
function saveSub (){
    saveSubEmr();
}

//----以下为实现----
function saveSubEmr(pid){
    var inputID = "既往史";
    var input = myWriter.Document.GetElementById(inputID);//获取诊疗经过输入域
    var xml = "";
    if (input != null) {
        input = myWriter.ComConvertToXTextInputFieldElement(input);
        xml = input.innerXML;
    }
    $.ajax({
        url:'/emr/dc/saveSub',
        type : "POST",
        data : {pid:pid,xml:xml,type:type},
        dataType :"json",
        success:function(data){
            if (data.code == 1) {
                window.opener.layer.msg("操作成功");
                window.opener.reLoad();
//					var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
//					parent.layer.close(index);
                window.close();

            } else {
                window.opener.layer.alert(data.msg)
            }
        },
        error:function(){
            alert("读取出错");
        }
    })
}

function change(){

}
function click(eventSender,eventArgs){
    //点击 入院诊断 加载 诊断结果内容
    if(eventSender.CurrentInputField){
        if(eventSender.CurrentInputField.name=="入院诊断"){
            var input = myWriter.Document.GetElementById("ryzd");
            if (input != null) {
                input = myWriter.ComConvertToXTextInputFieldElement(input);
                if (input != null) {
                    input.Text = document.getElementById("patient_diagnosis").innerHTML;
                }
            }
        }
        if(eventSender.CurrentInputField.name=="入院诊断2"){
            var input = myWriter.Document.GetElementById("ryzd2");
            if (input != null) {
                input = myWriter.ComConvertToXTextInputFieldElement(input);
                if (input != null) {
                    input.Text = document.getElementById("patient_diagnosis").innerHTML;
                }
            }
        }
    }

    if(eventSender.CurrentInputField){
        if(eventSender.CurrentInputField.name=="检查按钮"){
            openReport('2');
        }
        if (eventSender.CurrentInputField.name=="检验按钮") {
            openReport('3');
        }
        if(eventSender.CurrentInputField.name=="检查按钮2"){
            openReport('9');
        }
        if(eventSender.CurrentInputField.name=="检验按钮2"){
            openReport('8');
        }
        if(eventSender.CurrentInputField.name=="外院检查按钮2"){
            var input = myWriter.Document.GetElementById("外院检查2");
            if (input != null) {
                input = myWriter.ComConvertToXTextInputFieldElement(input);
                if (input != null) {
                    input.focus();
                }
            }
            var dt = new Date().toLocaleDateString().replace("年","-").replace("月","-").replace("日","")
            myWriter.ExecuteCommand("InsertString" , false , "（");
            var inputt = myWriter.ComCreateXTextInputFieldElement();
            inputt.BackgroundText = "检查时间";
            inputt.startBorderText = "【";
            inputt.endBorderText = "】";
            inputt.FieldSettings = myWriter.ComCreateInputFieldSettings();
            inputt.FieldSettings.EditStyle = 4;
            myWriter.ExecuteCommand("InsertInputField", false, inputt);
            myWriter.ExecuteCommand("InsertString" , false , "，外院）查");
            myWriter.DocumentOptions.BehaviorOptions.AutoCreateInstanceInProperty = true;
            var input1 = myWriter.ComCreateXTextInputFieldElement();
            input1.BackgroundText = "检查项目";
            input1.startBorderText = "【";
            input1.endBorderText = "】";
            myWriter.ExecuteCommand("InsertInputField", false, input1);
            myWriter.ExecuteCommand("InsertString" , false , "示");
            var input2 = myWriter.ComCreateXTextInputFieldElement();
            input2.BackgroundText = "检查结果";
            input2.startBorderText = "【";
            input2.endBorderText = "】";
            myWriter.ExecuteCommand("InsertInputField", false, input2);
            myWriter.ExecuteCommand("InsertString" , false , "\r\n");
        }
        if(eventSender.CurrentInputField.name=="外院检验按钮2"){
            var input = myWriter.Document.GetElementById("外院检验2");
            if (input != null) {
                input = myWriter.ComConvertToXTextInputFieldElement(input);
                if (input != null) {
                    input.focus();
                }
            }
            var dt = new Date().toLocaleDateString().replace("年","-").replace("月","-").replace("日","")
            myWriter.ExecuteCommand("InsertString" , false , "（");
            var inputt = myWriter.ComCreateXTextInputFieldElement();
            inputt.BackgroundText = "检验时间";
            inputt.startBorderText = "【";
            inputt.endBorderText = "】";
            inputt.FieldSettings = myWriter.ComCreateInputFieldSettings();
            inputt.FieldSettings.EditStyle = 4;
            myWriter.ExecuteCommand("InsertInputField", false, inputt);
            myWriter.ExecuteCommand("InsertString" , false , "，外院）查");
            myWriter.DocumentOptions.BehaviorOptions.AutoCreateInstanceInProperty = true;
            var input1 = myWriter.ComCreateXTextInputFieldElement();
            input1.BackgroundText = "检验项目";
            input1.startBorderText = "【";
            input1.endBorderText = "】";
            myWriter.ExecuteCommand("InsertInputField", false, input1);
            myWriter.ExecuteCommand("InsertString" , false , "示");
            var input2 = myWriter.ComCreateXTextInputFieldElement();
            input2.BackgroundText = "检验结果";
            input2.startBorderText = "【";
            input2.endBorderText = "】";
            myWriter.ExecuteCommand("InsertInputField", false, input2);
            myWriter.ExecuteCommand("InsertString" , false , "\r\n");
        }

    }
}

function bindDataSource(data){
// 	var jsonstr2 = '{"NAME":"张冰心","SEX":"女","AGE":"30","MARITAL_STATUS":null,"AREA_NAME":"安徽省滁州市定远县","NATION":null,"OCCUPATION":null,"SERVICE_AGENCY":null,"MAILING_ADDRESS":"江苏省常州市武进区聚盛花园8幢甲单元202室","INDATE":"2018-05-14"}';
// 	var jsonstr = '{"NAME":"张三","career":"农民","gender":"女","careerAdress":"常州二院","age":"55","adress":"什么路多少号","marriage":"已婚","teller":"儿子","birthplace":"常州","inDate":"","nation":"","recDate":""}';
    var jsonstr = JSON.stringify(data);
    //jsonstr = jsonstr.replace(/\"/g,"\\\"").replace(/\'/g,"\\\'");
    var json = JSON.parse(jsonstr);
    var xml = JSON2XML(json);
    myWriter.SetDocumentParameterValueXml("patient", xml);
    myWriter.WriteDataFromDataSourceToDocument();
    //手动设置可见性 -生殖检查部分
    var inputm = myWriter.Document.GetElementById("生殖-男");
    if (inputm != null) {
        inputm = myWriter.ComConvertToXTextInputFieldElement(inputm);
    }
    var inputw = myWriter.Document.GetElementById("生殖-女");
    if (inputw != null) {
        inputw = myWriter.ComConvertToXTextInputFieldElement(inputw);
    }
    if(json.SEX=="男"){
        inputm.Visible=true;
        inputw.Visible=false;
    }else if(json.SEX=="女"){
        inputw.Visible=true;
        inputm.Visible=false;
    }
    //设置 患者/患儿
    var inputh = myWriter.Document.GetElementById("患者患儿");
    if (inputh != null) {
        inputh = myWriter.ComConvertToXTextInputFieldElement(inputh);
    }
    //设置婚育 月经
    if(json.AGE<=14){
        inputh.Text = "患儿";
        var row = myWriter.Document.GetElementById("婚育史行");
        if (row != null) {
            row = myWriter.ComConvertToXTextTableRowElement(row);
        }
        row.Visible = false;
    }else{
        inputh.Text = "患者";
        if(json.SEX!="女"){
            var row = myWriter.Document.GetElementById("月经史行");
            if (row != null) {
                row = myWriter.ComConvertToXTextTableRowElement(row);
            }
            row.Visible = false;
        }
    }
    //设置默认记录时间为当前时间
    var input_time = myWriter.Document.GetElementById("patient_recdate");
    if (input_time != null) {
        input_time = myWriter.ComConvertToXTextInputFieldElement(input_time);
    }
    var c_time = new Date();
    var myDate = c_time.getDate();
    var myMonth = c_time.getMonth();
    var myHour = c_time.getHours();
    var myMin = c_time.getMinutes();

    if(myDate<10) myDate = "0"+myDate;
    if((myMonth+1)<10) myMonth = "0"+(myMonth+1);
    if(myHour<10) myHour = "0"+myHour;
    if(myMin<10) myMin = "0"+myMin;
    input_time.Text = c_time.getFullYear() + "-" + myMonth + "-" + myDate + " " + myHour + ":" + myMin ;
    //设置供事者默认本人
    var input_teller = myWriter.Document.GetElementById("patient_teller");
    if (input_teller != null) {
        input_teller = myWriter.ComConvertToXTextInputFieldElement(input_teller);
    }
    input_teller.Text = "本人";
    //设置婚姻状态
    var input_m = myWriter.Document.GetElementById("婚姻状况");
    if (input_m != null) {
        input_m = myWriter.ComConvertToXTextInputFieldElement(input_m);
    }
    input_m.Text = json.MARITAL_STATUS;
    myWriter.RefreshDocument();

}