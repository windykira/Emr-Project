var setting = {
	data: {
		simpleData: {
			enable: true}
	}
};

var zNodes =[
	{ id:1, pId:0, name:"病程", open:true},	
	{ id:11, pId:1, name:"病案首页", open:true},
	{ id:12, pId:1, name:"入院记录", open:true},
	
	{ id:121, pId:12, name:"内科入院记录 2017-06-13 14:30:11", url:"#", target:"_self"},
	
	{ id:13, pId:1, name:"病程记录", open:true},
	{ id:131, pId:13, name:"首次病程记录 2017-06-13 17:00:00", url:"#", target:"_self"},

	{ id:131, pId:13, name:"郑正主治医师查房记录 2017-06-14 17:00:00", url:"#", target:"_self"},

	{ id:131, pId:13, name:"温小兵医师查房记录 2017-06-15 17:00:00", url:"#", target:"_self"},

	{ id:131, pId:13, name:"出院小结 2017-6-26 20:30:00", url:"#", target:"_self"},
	
	{ id:14, pId:1, name:"会诊记录", open:true},
	{ id:141, pId:14, name:"会诊记录 2017-6-15 9:30:00", url:"#", target:"_self"},
	
	{ id:15, pId:1, name:"出院记录", open:true},
	{ id:151, pId:15, name:"出院记录 2017-6-15 9:30:00", url:"#", target:"_self"},
	
	/*{ id:16, pId:1, name:"医嘱", url:"#", target:"_self"},
	{ id:17, pId:1, name:"检查", url:"#", target:"_self"},
	{ id:18, pId:1, name:"检验", url:"#", target:"_self"},
	{ id:19, pId:1, name:"处方", url:"#", target:"_self"},
	{ id:20, pId:1, name:"手术", url:"#", target:"_self"},
	{ id:21, pId:1, name:"护理", url:"#", target:"_self"},
	{ id:22, pId:1, name:"费用", url:"#", target:"_self"},*/
];

$(function(){
	$.fn.zTree.init($("#treeDemo"), setting, zNodes);
});


var treeObj = $.fn.zTree.getZTreeObj("tree");
treeObj.expandAll(true);