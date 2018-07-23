//以下temp_开头的为固定function，
//初始化方法，模板加载后调用
function temp_init(data){
    bindDataSource(data);
    setTimeString()
}
//点击事件，编辑器中单击后调用
function temp_click(eventSender,eventArgs){
    click(eventSender,eventArgs)
}
//输入域修改事件，输入域内容修改后调用
function temp_field_change(eventSender,eventArgs){

}

function setTimeString(){
    var timeString = getNowFormatDate();
    var inputs = myWriter.Document.GetElementsByName("Date");
    for(var i = 0;i<inputs.Count;i++){
        inputs.GetItem(i).Text = timeString;
    }

}

function getNowFormatDate() {
    var date = new Date();
    var seperator1 = "-";
    var year = date.getFullYear();
    var month = date.getMonth() + 1;
    var strDate = date.getDate();
    if (month >= 1 && month <= 9) {
        month = "0" + month;
    }
    if (strDate >= 0 && strDate <= 9) {
        strDate = "0" + strDate;
    }
    var currentdate = year + seperator1 + month + seperator1 + strDate;
    return currentdate;
}


// function change(){
//
// }
// function click(eventSender,eventArgs){
//     if(eventSender.CurrentInputField){
//         if(eventSender.CurrentInputField.ID=="DOCNAME"){
//             var input = myWriter.Document.GetElementById("DOCNAME");
//             if (input != null) {
//                 input = myWriter.ComConvertToXTextInputFieldElement(input);
//                 if (input != null) {
//                     input.Text = document.getElementById("patient_docname").innerHTML;
//                 }
//             }
//         }
//
//     }

    // if(eventSender.CurrentInputField){
    //     if(eventSender.CurrentInputField.name=="检查按钮"){
    //         openReport('2');
    //     }
    //     if (eventSender.CurrentInputField.name=="检验按钮") {
    //         openReport('3');
    //     }
    //     if(eventSender.CurrentInputField.name=="检查按钮2"){
    //         openReport('9');
    //     }
    //     if(eventSender.CurrentInputField.name=="检验按钮2"){
    //         openReport('8');
    //     }
        // if(eventSender.CurrentInputField.name=="外院检查按钮2"){
        //     var input = myWriter.Document.GetElementById("外院检查2");
        //     if (input != null) {
        //         input = myWriter.ComConvertToXTextInputFieldElement(input);
        //         if (input != null) {
        //             input.focus();
        //         }
        //     }
        //     var dt = new Date().toLocaleDateString().replace("年","-").replace("月","-").replace("日","")
        //     myWriter.ExecuteCommand("InsertString" , false , "（");
        //     var inputt = myWriter.ComCreateXTextInputFieldElement();
        //     inputt.BackgroundText = "检查时间";
        //     inputt.startBorderText = "【";
        //     inputt.endBorderText = "】";
        //     inputt.FieldSettings = myWriter.ComCreateInputFieldSettings();
        //     inputt.FieldSettings.EditStyle = 4;
        //     myWriter.ExecuteCommand("InsertInputField", false, inputt);
        //     myWriter.ExecuteCommand("InsertString" , false , "，外院）查");
        //     myWriter.DocumentOptions.BehaviorOptions.AutoCreateInstanceInProperty = true;
        //     var input1 = myWriter.ComCreateXTextInputFieldElement();
        //     input1.BackgroundText = "检查项目";
        //     input1.startBorderText = "【";
        //     input1.endBorderText = "】";
        //     myWriter.ExecuteCommand("InsertInputField", false, input1);
        //     myWriter.ExecuteCommand("InsertString" , false , "示");
        //     var input2 = myWriter.ComCreateXTextInputFieldElement();
        //     input2.BackgroundText = "检查结果";
        //     input2.startBorderText = "【";
        //     input2.endBorderText = "】";
        //     myWriter.ExecuteCommand("InsertInputField", false, input2);
        //     myWriter.ExecuteCommand("InsertString" , false , "\r\n");
        // }
        // if(eventSender.CurrentInputField.name=="外院检验按钮2"){
        //     var input = myWriter.Document.GetElementById("外院检验2");
        //     if (input != null) {
        //         input = myWriter.ComConvertToXTextInputFieldElement(input);
        //         if (input != null) {
        //             input.focus();
        //         }
        //     }
        //     var dt = new Date().toLocaleDateString().replace("年","-").replace("月","-").replace("日","")
        //     myWriter.ExecuteCommand("InsertString" , false , "（");
        //     var inputt = myWriter.ComCreateXTextInputFieldElement();
        //     inputt.BackgroundText = "检验时间";
        //     inputt.startBorderText = "【";
        //     inputt.endBorderText = "】";
        //     inputt.FieldSettings = myWriter.ComCreateInputFieldSettings();
        //     inputt.FieldSettings.EditStyle = 4;
        //     myWriter.ExecuteCommand("InsertInputField", false, inputt);
        //     myWriter.ExecuteCommand("InsertString" , false , "，外院）查");
        //     myWriter.DocumentOptions.BehaviorOptions.AutoCreateInstanceInProperty = true;
        //     var input1 = myWriter.ComCreateXTextInputFieldElement();
        //     input1.BackgroundText = "检验项目";
        //     input1.startBorderText = "【";
        //     input1.endBorderText = "】";
        //     myWriter.ExecuteCommand("InsertInputField", false, input1);
        //     myWriter.ExecuteCommand("InsertString" , false , "示");
        //     var input2 = myWriter.ComCreateXTextInputFieldElement();
        //     input2.BackgroundText = "检验结果";
        //     input2.startBorderText = "【";
        //     input2.endBorderText = "】";
        //     myWriter.ExecuteCommand("InsertInputField", false, input2);
        //     myWriter.ExecuteCommand("InsertString" , false , "\r\n");
        // }

// }

function bindDataSource(data){
    alert(11);
// 	var jsonstr2 = '{"NAME":"张冰心","SEX":"女","AGE":"30","MARITAL_STATUS":null,"AREA_NAME":"安徽省滁州市定远县","NATION":null,"OCCUPATION":null,"SERVICE_AGENCY":null,"MAILING_ADDRESS":"江苏省常州市武进区聚盛花园8幢甲单元202室","INDATE":"2018-05-14"}';
// 	var jsonstr = '{"NAME":"张三","career":"农民","gender":"女","careerAdress":"常州二院","age":"55","adress":"什么路多少号","marriage":"已婚","teller":"儿子","birthplace":"常州","inDate":"","nation":"","recDate":""}';
//     var jsonstr = JSON.stringify(data);
//     jsonstr = jsonstr.replace(/\"/g,"\\\"").replace(/\'/g,"\\\'");
//     var json = JSON.parse(jsonstr);
    var xml = JSON2XML(data);
    myWriter.SetDocumentParameterValueXml("patient", xml);
    myWriter.WriteDataFromDataSourceToDocument();

}