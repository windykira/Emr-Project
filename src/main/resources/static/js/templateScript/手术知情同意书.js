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