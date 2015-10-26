<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%String path = request.getContextPath(); 
      String basePath = request.getScheme()+"://"+ request.getServerName()+":"+request.getServerPort()+path+"/";%>
<base href="<%=basePath%>">
<head>
<link rel="stylesheet" type="text/css" href="themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="themes/icon.css">
<link rel="stylesheet" type="text/css" href="themes/demo.css">
<script type="text/javascript" src="jquery/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="jquery/jquery.easyui.min.js"></script>
<script type="text/javascript">
var editFlag = undefined;

$(function (){
	$("#dg").datagrid({
	url: "<%=basePath%>getDeviceByPager?pageSize=10&pageNumber=1", //指向一个一般处理程序或者一个控制器，返回数据要求是Json格式，直接赋值Json格式数据也可，我以demo中自带的Json数据为例，就不写后台代码了，但是我会说下后台返回的注意事项
	iconCls: "icon-add",
	fitColumns: false, //设置为true将自动使列适应表格宽度以防止出现水平滚动,false则自动匹配大小
	//toolbar设置表格顶部的工具栏，以数组形式设置
	striped : true,
	idField: 'id', //标识列，一般设为id，可能会区分大小写，大家注意一下
	loadMsg: "正在努力为您加载数据", //加载数据时向用户展示的语句
	pagination: true, //显示最下端的分页工具栏
	rownumbers: true, //显示行数 1，2，3，4...
	singleSelect:true,
	//pageSize: 10, //读取分页条数，即向后台读取数据时传过去的值
	//pageList: [10, 20, 30], //可以调整每页显示的数据，即调整pageSize每次向后台请求数据时的数据
	//由于datagrid的属性过多，我就不每个都介绍了，如有需要，可以看它的API
	sortName: "name", //初始化表格时依据的排序 字段 必须和数据库中的字段名称相同
	sortOrder: "asc", //正序
	columns: [[
	{
	field: 'brand', title: '品牌', width: 50,
	editor: {//设置其为可编辑
	type: 'validatebox',//设置编辑样式 自带样式有：text，textarea，checkbox，numberbox，validatebox，datebox，combobox，combotree 可自行扩展
	options: {}
	}
	},
	{
		field: 'type', title: '类型', width: 50,
		editor: {//设置其为可编辑
		type: 'validatebox',
		options: {
		required: true//设置编辑规则属性
		}
		}	
		
		
	},
	{
	field: 'modelNo', title: '型号', width: 80, sortable: true,
	editor: {//设置其为可编辑
	type: 'validatebox',//设置编辑格式
	options: {
	required: true//设置编辑规则属性
	}
	}
	},//sortable:true点击该列的时候可以改变升降序
	{
	field: 'seriesNo', title: '序列号', width: 90,
	editor: {//设置其为可编辑
	type: 'validatebox',//这里我们将进行一个datetimebox的扩展
	options: {
	required: true//设置编辑规则属性
	}
	}
	},

	{
		field: 'bDate', title: '采购时间', width: 80,
		editor: {//设置其为可编辑
		type: 'datebox',//这里我们将进行一个datetimebox的扩展
		options: {
		required: true//设置编辑规则属性
		}
		}		
		
		
	},
	{
		field: 'bCompany', title: '采购单位', width: 80,
		editor: {//设置其为可编辑
		type: 'validatebox',//这里我们将进行一个datetimebox的扩展
		options: {
		required: true//设置编辑规则属性
		}
		}		
		
		
	},
	{
		field: 'bPrice', title: '价格', width: 50,
		editor: {//设置其为可编辑
		type: 'validatebox',//这里我们将进行一个datetimebox的扩展
		options: {
		required: true//设置编辑规则属性
		}
		}		
		
		
	},
	{
		field: 'guaranteeDate', title: '质保期', width: 80,
		editor: {//设置其为可编辑
		type: 'datebox',//这里我们将进行一个datetimebox的扩展
		options: {
		required: true//设置编辑规则属性
		}
		}			
	},
	{
		field: 'expireDate', title: '报废日期', width: 80,
		editor: {//设置其为可编辑
		type: 'datebox',//这里我们将进行一个datetimebox的扩展
		options: {
		required: true//设置编辑规则属性
		}
		}			
	},
	{
		field: 'company', title: '维护单位', width: 150,
		editor: {//设置其为可编辑
		type: 'validatebox',
		options: {
		required: true//设置编辑规则属性
		}
		}			
	},
	{
		field: 'contract', title: '联系人', width: 50,
		editor: {//设置其为可编辑
		type: 'validatebox',
		options: {
		required: true//设置编辑规则属性
		}
		}			
	},
	{
		field: 'contractNo', title: '联系方式', width: 85,
		editor: {//设置其为可编辑
		type: 'validatebox',
		options: {
		required: true//设置编辑规则属性
		}
		}			
	},
	{
		field: 'loginName', title: '登录名', width: 80,
		editor: {//设置其为可编辑
		type: 'validatebox',
		options: {
		required: true//设置编辑规则属性
		}
		}			
	},
	{
		field: 'loginPwd', title: '密码', width: 80,
		editor: {//设置其为可编辑
		type: 'validatebox',
		options: {
		required: true//设置编辑规则属性
		}
		}			
	},
	{
		field: 'portNumber', title: '端口数', width: 50,
		editor: {//设置其为可编辑
		type: 'validatebox',
		options: {
		required: true//设置编辑规则属性
		}
		}			
	},
	{
		field: 'id', title: 'id', width: 50,
		formatter:  function(value,row,index) {
			return "<a href='javascript:void(0)' onclick=\"$('#configWin').window('open');\">操作</a>";
		}
	}
	]],//这里之所以有两个方括号，是因为可以做成水晶报表形式，具体可看demo
	toolbar: [
	{//在dategrid表单的头部添加按钮
	text: "添加",
	iconCls: "icon-add",
	handler: function () {
		$('#addNewDeviceWin').window('open');
		$('#addNewDeviceWin').window('refresh',"<%=basePath%>device/addDevice.jsp");
// 		$("#dg").datagrid('unselectAll');
// 		if (editFlag != undefined) {
// 			$("#dg").datagrid('endEdit', editFlag);//结束编辑，传入之前编辑的行
// 			}
// 		if (editFlag == undefined) {//防止同时打开过多添加行
// 			$("#dg").datagrid('insertRow', {//在指定行添加数据，appendRow是在最后一行添加数据
// 			index: 0, // 行数从0开始计算
// 			row: {
// 			brand: '',
// 			name: '请输入设备名称',
// 			seriesNo: '',
// 			orderDate: '',
// 			orderBy: '',
// 			price: '',
// 			expireDate: '',
// 			guaranteeDate:'',
// 			id:''
// 		}
// 	});
// 	$("#dg").datagrid('selectRow', 0); 
// 	$("#dg").datagrid('beginEdit', 0);//开启编辑并传入要编辑的行
// 	editFlag = 0;
// 	}
	}
	}, '-', {//'-'就是在两个按钮的中间加一个竖线分割，看着舒服
	text: "删除",
	iconCls: "icon-remove",
	handler: function () {
	//选中要删除的行
	$("#dg").datagrid('rejectChanges');
	var rows = $("#dg").datagrid('getSelections');
	if (rows.length < 0 || rows.length == 0) {
		 $.messager.alert('提示','请选择要删除的行','error');  
	} else if(rows.length > 1) {
		$.messager.alert('警告','不支持批量删除','error');  
	} else {
	//if (rows.length > 0) {//选中几行的话触发事件
		$.messager.confirm("提示", "您确定要删除吗？", function (res) {//提示是否删除
		if (res) {
			//var id = rows[0].id;
			//console.info(rows[0].id);
			//var codes = [];
			//for (var i = 0; i < rows.length; i++) {
			//codes.push(rows[i].id);
			//}
			
			//console.info(codes.join(','));//拼接字符串并传递到后台处理数据，循环删除，成功后刷新datagrid
		$.ajax({
			url:"<%=basePath%>deleteDevice?id="+rows[0].id,
			success:function(t) {
				if (t.success) {
					$("#dg").datagrid('acceptChanges'); 
					$.messager.show({
						msg : "删除成功",  
						title : '成功',
						showType: 'show',
						timeout: 2000
						});  
					$("#dg").datagrid('reload');  	
					$("#dg").datagrid('unselectAll'); 
				}
			},
			error:function() {
				 $.messager.alert('操作提示', '删除失败，请重试', 'error');
		}
	});
	}
		editFlag = undefined;
	});
	}
	}
	
	}, '-', {
	text: "修改",
	iconCls: "icon-edit",
	handler: function () {
		var rows = $("#dg").datagrid('getSelections');
		if (rows.length < 1) {
			$.messager.alert('操作提示', '请选择要修改的行', 'warning');
		} else {
			$('#updateDeviceWin').window('open');
			$('#updateDeviceWin').window('refresh',"<%=basePath%>device/updateDeviceWin.jsp");
		}

		
	//选中一行进行编辑
// 	$("#dg").datagrid('rejectChanges');
// 	var rows = $("#dg").datagrid('getSelections');
// 	if (rows.length == 1) {//选中一行的话触发事件
// 	if (editFlag != undefined) {
// 	$("#dg").datagrid('endEdit', editFlag);//结束编辑，传入之前编辑的行
// 	}
// 	if (editFlag == undefined) {
// 	var index = $("#dg").datagrid('getRowIndex', rows[0]);//获取选定行的索引
// 	$("#dg").datagrid('beginEdit', index);//开启编辑并传入要编辑的行
// 	editFlag = index;
// 	}
// 	} else if (rows.length > 1){
// 		$.messager.alert('操作提示', '不能选择多行进行修改', 'error');
// 	} else if (rows.length < 1) {
// 		$.messager.alert('操作提示', '请选择要修改的行', 'error');
// 	}
		}
	}, 
// 	'-', {
// 	text: "保存",
// 	iconCls: "icon-save",
// 	handler: function () {
// 	$("#dg").datagrid('endEdit', editFlag);

// 	}
// 	}, 
	'-', {
	text: "撤销",
	iconCls: "icon-redo",
	handler: function () {
	editFlag = undefined;
	$("#dg").datagrid('rejectChanges');
	}
	}, '-'],
	onAfterEdit: function (rowIndex, rowData, changes) {//在添加完毕endEdit，保存时触发
	console.info(rowData);
	var rows = $("#dg").datagrid('getSelected');
	var id;
	if (rows.id == "") {
		id=0;
	} else {
		id = rows.id;
	}
	console.info(rows.id);
	var data = encodeURI(JSON.stringify(rowData));
		$.ajax({
			type : "POST",
			dataType : "json",
			url : "<%=basePath%>addDevice?id=" + id,
			data : "jsonDate=" + data,
			success : function(data) {
				if(data) {
					 $.messager.alert("操作提示", "添加成功","warning");
					 $("#dg").datagrid('reload');
					 $("#dg").datagrid('unselectAll');
				}
			},
			error : function() {
				 $.messager.alert('操作提示', '添加设备失败，请重新操作', 'error');
				 $("#dg").datagrid('loaded');
			}

		});
	editFlag = undefined;//重置
	}
//	,onDblClickCell: function(rowIndex, field, value){//双击该行修改内容
// 	 	if (editFlag != undefined) {
// 			$("#dg").datagrid('endEdit', editFlag);//结束编辑，传入之前编辑的行
// 			}
// 		if (editFlag == undefined) {
// 			$("#dg").datagrid('beginEdit', rowIndex);//开启编辑并传入要编辑的行
// 			editFlag = rowIndex;
// 			}
//		 var rows = $("#dg").datagrid('getSelected');
//		 var id = rows.id;
	//	 $('#updateDeviceWin').window('open');
//		 $('#updateDeviceWin').window('refresh',"<%=basePath%>device/maintain_detail.jsp?id="+ id);
			
	//}
	});

	$("#dg").datagrid('hideColumn','id');
	var pager = $("#dg").datagrid('getPager');
	pager.pagination({
		pageSize:3,
		beforePageText: '第',//页数文本框前显示的汉字  
		afterPageText: '页    共 {pages} 页',
		displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录', 
		onBeforeRefresh:function(){
			
		},
		onSelectPage:function(pageNumber,pageSize) {
			find(pageNumber,pageSize);
		}
		
	});
	function find(pageNumber,pageSize) {
		$("#dg").datagrid('getPager').pagination({pageSize : pageSize, pageNumber : pageNumber});//reset
		$("#dg").datagrid("loading"); 
		$.ajax({
			type:"post",
			url:"<%=basePath%>getDeviceByPager?pageSize=" + pageSize + "&pageNumber=" + pageNumber,
			success:function(data) {
			 	$("#dg").datagrid('loadData',pageData(data.rows,data.total));//加载数据
			 	$("#dg").datagrid("loaded"); 
			}
		});
	}
	function pageData(list,total){
	     var obj=new Object(); 
	     obj.total=total; 
	     obj.rows=list; 
	     return obj; 
	 }
	
		addNewDeviceWin();
		updateDeviceWin();

	});	

	function addNewDeviceWin() {
		$('#addNewDeviceWin').window({
			title : '新增设备',
			width : 800,
			modal : true,
			shadow : true,
			closed : true,
			height : 250,
			resizable : false,
			onBeforeOpen : function() {
				
			}
		});
	}
	function updateDeviceWin() {
		$('#updateDeviceWin').window({
			title : '设备运行参数',
			width : 800,
			modal : true,
			shadow : true,
			closed : true,
			height : 250,
			resizable : false,
			onBeforeOpen : function() {
				
			}
		});
	}
    function closeLogin() {
        close();
    }
    function close() {
    	$('#addNewDeviceWin').window('close');
    	$('#updateDeviceWin').window('close');
    }

	function doSearch(value,name) {
		alert(value);
	}
</script>

<body>
	<div data-options="region:'north',split:false">
		<input id="search" class="easyui-searchbox" searcher="doSearch" prompt="请输入序列号查询">
	</div>
	<div data-options="region:'center',split:false">
		<table id="dg">
		</table>
	</div>
<!-- 	<div id="w" class="easyui-window" title="运行信息" collapsible="false" minimizable="false" -->
<!--         maximizable="false" icon="icon-save"  style="width: 300px; height: 150px; padding: 5px; -->
<!--         background: #fafafa;"> -->
<!--         <div class="easyui-layout" fit="true"> -->
<!--             <div region="center" border="false" style="padding: 10px; background: #fff; border: 1px solid #ccc;"> -->
                 
<!--             </div> -->
<!--         </div> -->
<!--     </div> -->
    <div id="addNewDeviceWin" class="easyui-window" title="新增设备" collapsible="false" minimizable="false"
        maximizable="false" icon="icon-save"  style="width: 300px; height: 150px; padding: 5px;
        background: #fafafa;">
        <div class="easyui-layout" fit="true">
            <div region="center" border="false" style="padding: 10px; background: #fff; border: 1px solid #ccc;">
                 
            </div>
        </div>
    </div>
    <div id="updateDeviceWin" class="easyui-window" title="修改设备参数" collapsible="false" minimizable="false"
        maximizable="false" icon="icon-save"  style="width: 300px; height: 150px; padding: 5px;
        background: #fafafa;">
        <div class="easyui-layout" fit="true">
            <div region="center" border="false" style="padding: 10px; background: #fff; border: 1px solid #ccc;">
                 
            </div>
        </div>
    </div>
</body>
</html>