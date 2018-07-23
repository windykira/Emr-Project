var setting = {
	data: {
		simpleData: {
			enable: true
		}
	}
};

var zNodes =[
	{ id:1, pId:0, name:"字典库", open:true},	
	{ id:11, pId:1, name:"头晕", open:true},
	{ id:111, pId:11, name:"恶心", url:"#", target:"_self"},
	{ id:111, pId:11, name:"跌倒", url:"#", target:"_self"},
	{ id:12, pId:1, name:"心慌", open:true},
	{ id:121, pId:12, name:"发昏", open:true}
];

$(function(){
	$.fn.zTree.init($("#treeDemo"), setting, zNodes);
});


var treeObj = $.fn.zTree.getZTreeObj("tree");
treeObj.expandAll(true);