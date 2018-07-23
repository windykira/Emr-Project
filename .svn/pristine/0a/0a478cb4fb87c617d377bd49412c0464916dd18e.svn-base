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
//保存病例子模板事件，点击保存病历后调用
function saveSub (pid){
    // saveSubEmr(pid);
}
//保存病历前测试是否更改
function isModified(){
    if(!inputIsModified("体格检查")) return false;
    if(!inputIsModified("诊断")) return false;
    return true;
}
//----以下为实现----
function inputIsModified(inputID){
    var input = myWriter.Document.GetElementById(inputID);//获取诊疗经过输入域
    if (input != null) {
        input = myWriter.ComConvertToXTextInputFieldElement(input);
        return input.modified;
    }
    return true;
}
function saveSubEmr(pid){
    saveSubEmrByType(pid,"诊断","诊断");
    saveSubEmrByType(pid,"诊断","出院诊断");
    saveSubEmrByType(pid,"体格检查","体格检查");
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
function click(eventSender,eventArgs){
    if(eventSender.CurrentInputField) {
        if (eventSender.CurrentInputField.name == "DateTime") {
            eventSender.CurrentInputField.Text = getTimeString();
        }
        if (eventSender.CurrentInputField.name == "doctor") {
            eventSender.CurrentInputField.Text = document.getElementById("doc_name").innerHTML;
        }
    }
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
function bindDataSource(data){
    //加载医生姓名、职称
    var inputs = myWriter.Document.GetElementsByName("doc_name");
    for(var i = 0;i<inputs.Count;i++){
        inputs.GetItem(i).Text = document.getElementById("doc_name").innerHTML+" "+document.getElementById("doc_role").innerHTML+" ";
    }
    //设置 患者/患儿
    var inputh = myWriter.Document.GetElementById("患者患儿");
    if (inputh != null) {
        inputh = myWriter.ComConvertToXTextInputFieldElement(inputh);
    }
    //设置婚育 月经
    if(data.AGE<=14) {
        if (inputh) inputh.Text = "患儿";
    }else{
        if (inputh) inputh.Text = "患者";
    }
//数据共享
    var id = data.PATIENT_ID;
    loadInputByType(id,"体格检查","体格检查");
    loadInputByType(id,"诊断","诊断");
    myWriter.RefreshDocument();

}

function loadInputByType(id,inputID,type){
    var input = myWriter.Document.GetElementById(inputID);
    if (input != null) {
        input = myWriter.ComConvertToXTextInputFieldElement(input);
        $.ajax({
            url:"/emr/dc/getSubXML",
            dataType:"text",
            data:{id:id,type:type},
            success:function(data){
                input.focus();
                myWriter.ExecuteCommand("InsertXML", false, data);
                input.modified = false;
            },
            error:function(){
            }
        })
    }
}