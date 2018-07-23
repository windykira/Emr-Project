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
function saveSub (pid){
    saveSubEmr(pid);
}

//----以下为实现----
function saveSubEmr(pid){
    saveSubEmrByType(pid,"体格检查","入院体格检查");
    saveSubEmrByType(pid,"入院诊断","入院诊断");
    saveSubEmrByType(pid,"入院诊断","诊断");
    saveSubEmrByType(pid,"诊断依据","诊断依据");
    saveSubEmrByType(pid,"鉴别诊断","鉴别诊断");
    saveSubEmrByType(pid,"诊疗计划","诊疗计划");
}
function saveSubEmrByType(pid,inputID,type){
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

        },
        error:function(){

        }
    })
}
function change(){

}
function getTimeString(){
    var c_time = new Date();
    var myDate = c_time.getDate();
    var myMonth = c_time.getMonth();
    var myHour = c_time.getHours();
    var myMin = c_time.getMinutes();

    if(myDate<10) myDate = "0"+myDate;
    if((myMonth+1)<10) myMonth = "0"+(myMonth+1);
    if(myHour<10) myHour = "0"+myHour;
    if(myMin<10) myMin = "0"+myMin;
    return c_time.getFullYear() + "-" + myMonth + "-" + myDate + " " + myHour + ":" + myMin ;
}
function click(eventSender,eventArgs){
    //点击 入院诊断 加载 诊断结果内容
    if(eventSender.CurrentInputField){
        if(eventSender.CurrentInputField.name=="DateTime"){
            eventSender.CurrentInputField.Text = getTimeString();

        }
        if (eventSender.CurrentInputField.name == "doctor") {
            eventSender.CurrentInputField.Text = document.getElementById("doc_name").innerHTML;
        }
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
        if(eventSender.CurrentInputField.ID=="依据-主诉"){
            var input = myWriter.Document.GetElementById("依据-主诉");
            if (input != null) {
                input = myWriter.ComConvertToXTextInputFieldElement(input);
                if (input != null) {
                    var p_input = myWriter.Document.GetElementById("主诉");
                    if (p_input != null) {
                        p_input = myWriter.ComConvertToXTextInputFieldElement(p_input);
                        if (input != null) {
                            var txt = p_input.Text;
                            var index1 = txt.indexOf("】");
                            txt = txt.substring(index1+2).replace(/【/g,"").replace(/】/g,"");
                            input.Text = txt;

                        }
                    }
                }
            }
        }
        if(eventSender.CurrentInputField.ID=="依据-既往史"){
            var input = myWriter.Document.GetElementById("依据-既往史");
            if (input != null) {
                input = myWriter.ComConvertToXTextInputFieldElement(input);
                if (input != null) {
                    var totalString="";
                    var descArr = ["高血压","糖尿病","肝炎病","结核病","预防接种","手术","外伤","食物药物过敏","输血","其他疾病"]
                    for(var i=0;i<descArr.length;i++){
                        totalString += getText(descArr[i]);
                    }
                    input.Text = totalString;
                }
            }
        }
        if(eventSender.CurrentInputField.ID=="依据-体格检查"){
            var input = myWriter.Document.GetElementById("依据-体格检查");
            if (input != null) {
                input = myWriter.ComConvertToXTextInputFieldElement(input);
                if (input != null) {
                    var p_input = myWriter.Document.GetElementById("体格检查");
                    if (p_input != null) {
                        p_input = myWriter.ComConvertToXTextInputFieldElement(p_input);
                        if (input != null) {
                            var txt = p_input.Text;
                            txt = txt.replace(/【/g,"").replace(/】/g,"");
                            input.Text = txt;

                        }
                    }
                }
            }
        }
        if(eventSender.CurrentInputField.ID=="依据-辅检"){
            var input = myWriter.Document.GetElementById("依据-辅检");
            if (input != null) {
                input = myWriter.ComConvertToXTextInputFieldElement(input);
                if (input != null) {
                    var p_input = myWriter.Document.GetElementById("辅检");
                    if (p_input != null) {
                        p_input = myWriter.ComConvertToXTextInputFieldElement(p_input);
                        if (input != null) {
                            var txt = p_input.Text;
                            txt = txt.replace("\r\n","");
                            input.Text = txt;
                        }
                    }
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

function getText(str){
    var input = myWriter.Document.GetElementById(str+"有无");
    if (input != null) {
        input = myWriter.ComConvertToXTextInputFieldElement(input);
        if(input.Text == '有'){
            alert('有'+str)
            var input1 = myWriter.Document.GetElementById(str+"描述");
            if (input1 != null) {
                input1 = myWriter.ComConvertToXTextInputFieldElement(input1);
                return input1.Text.replace(/【/g, "").replace(/】/g, "");
            }
        }else{
            alert('无'+str)
            return "";
        }
    }

}

function bindDataSource(data){
// 	var jsonstr2 = '{"NAME":"张冰心","SEX":"女","AGE":"30","MARITAL_STATUS":null,"AREA_NAME":"安徽省滁州市定远县","NATION":null,"OCCUPATION":null,"SERVICE_AGENCY":null,"MAILING_ADDRESS":"江苏省常州市武进区聚盛花园8幢甲单元202室","INDATE":"2018-05-14"}';
// 	var jsonstr = '{"NAME":"张三","career":"农民","gender":"女","careerAdress":"常州二院","age":"55","adress":"什么路多少号","marriage":"已婚","teller":"儿子","birthplace":"常州","inDate":"","nation":"","recDate":""}';
//     var jsonstr = JSON.stringify(data);
    //jsonstr = jsonstr.replace(/\"/g,"\\\"").replace(/\'/g,"\\\'");
    // var json = JSON.parse(jsonstr);
    var xml = JSON2XML(data);
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
        if(inputm) inputm.Visible=true;
        if(inputw) inputw.Visible=false;
    }else if(json.SEX=="女"){
        if(inputw) inputw.Visible=true;
        if(inputm) inputm.Visible=false;
    }
    //设置 患者/患儿
    var inputh = myWriter.Document.GetElementById("患者患儿");
    if (inputh != null) {
        inputh = myWriter.ComConvertToXTextInputFieldElement(inputh);
    }
    //设置婚育 月经
    if(json.AGE<=14){
        if(inputh) inputh.Text = "患儿";
        var row = myWriter.Document.GetElementById("婚育史行");
        if (row != null) {
            row = myWriter.ComConvertToXTextTableRowElement(row);
        }
        row.Visible = false;
    }else{
        if(inputh) inputh.Text = "患者";
        if(json.SEX!="女"){
            var row = myWriter.Document.GetElementById("月经史行");
            if (row != null) {
                row = myWriter.ComConvertToXTextTableRowElement(row);
                row.Visible = false;
            }
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
    var myTime = c_time.getFullYear() + "-" + myMonth + "-" + myDate + " " + myHour + ":" + myMin ;
    if(input_time) input_time.Text = myTime;

    //设置供事者默认本人
    var input_teller = myWriter.Document.GetElementById("patient_teller");
    if (input_teller != null) {
        input_teller = myWriter.ComConvertToXTextInputFieldElement(input_teller);
        input_teller.Text = "本人";
    }
    //设置婚姻状态
    var input_m = myWriter.Document.GetElementById("婚姻状况");
    if (input_m != null) {
        input_m = myWriter.ComConvertToXTextInputFieldElement(input_m);
        input_m.Text = json.MARITAL_STATUS;
    }
    myWriter.RefreshDocument();

}