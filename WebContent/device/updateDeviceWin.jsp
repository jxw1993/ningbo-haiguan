<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<%String path = request.getContextPath(); 
      String basePath = request.getScheme()+"://"+ request.getServerName()+":"+request.getServerPort()+path+"/";%>
<base href="<%=basePath%>">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title></title>
</head>
<script type="text/javascript">
$(function(){
	   var rows = $("#dg").datagrid('getSelections');
	   var id = rows[0].id;
	  $('#type').combobox({   

		      url:'<%=basePath%>getDeviceType',

		      valueField:'id',   

		      textField:'name',
		      
		      editable : false,
		      
		      method : 'get',
		      
		      onLoadSuccess : function() {
		    	  $('#type').combobox('setValue',rows[0].type);
		      }

		  }); 
	  
	  $('#company').combobox({   

	      url:'<%=basePath%>getCompany',

	      valueField:'id',   

	      textField:'name',
	      
	      method : 'get',
	      
	      panelWidth : 150,
	      
	      onLoadSuccess : function() {
	    	  $('#company').combobox('setValue',rows[0].company);
	      }

	  });
	
  	$('#updateForm').form('load',rows[0]);
  	
  	$('#btnUpdate').click(function(){
  	  	$('#updateForm').form("submit",{
  			url : "<%=basePath%>updateDeviceInfo?id=" + id,
  			onSubmit: function(){
  				return $('#updateForm').form('validate');
  			},
  			success : function(data) {
  				 var res = jQuery.parseJSON(data);
  				 if (res.result) {
  					 $.messager.alert("操作提示", res.msg,"info");
  					 $('#updateDeviceWin').window('close');
  					 $("#dg").datagrid('reload');
  				 } else {
  					 $.messager.alert("操作提示", res.msg,"error");
  				 }
  			}
  	  		
  	  		
  	  	});
  	});
});

</script>
	<form id="updateForm" method="post" enctype="multipart/form-data"> 
	 <div region="center" border="false" style="padding: 10px; background: #fff; border: 1px solid #ccc;">
               <table cellpadding=3>
                    <tr>
                        <td>品牌：</td>
                        <td><input id="brand" type="text" name="brand" class="easyui-validatebox" required="true" disabled="disabled"/></td>
                    	<td>类型：</td>
                        <td><input id="type" name="type" type="text" class="easyui-combobox" required="true" disabled="disabled"/></td>
                    	<td>型号：</td>
                    	<td><input id="modelNo" name="modelNo" type="text"class="easyui-validatebox" required="true" disabled="disabled"/></td>
                    </tr>
                    <tr>
                    	<td>序列号：</td>
                        <td><input id="seriesNo" name="seriesNo" type="text" class="easyui-validatebox" required="true" disabled="disabled"/></td>
                        <td>采购时间：</td>
                        <td><input id="bDate" name="bDate" type="text" class="easyui-datebox" /></td>
                        <td>采购单位：</td>
                        <td><input id="bCompany" name="bCompany" type="text" class="easyui-validatebox"/></td>
                    
                    </tr>
                    <tr>
                    	<td>价格：</td>
                        <td><input id="bPrice" name="bPrice" type="text" class="easyui-validatebox" /></td>
                        <td>保修至：</td>
                        <td><input id="guaranteeDate" name="guaranteeDate" type="text" class="easyui-datebox" /></td>
                        <td>报废时间：</td>
                        <td><input id="expireDate" name="expireDate" type="text" class="easyui-datebox"/></td>
                    
                    </tr>
                    <tr>
                    	<td>维护单位：</td>
                        <td><input id="company" name="company" type="text" class="easyui-combobox" required="true"/></td>
                        <td>登录名：</td>
                        <td><input id="loginName" name="loginName" type="text" class="easyui-validatebox" /></td>
                   	    <td>登录密码：</td>
                        <td><input id="loginPwd" name="loginPwd" type="text" class="easyui-validatebox"/></td>        
                   		
                    </tr>
                    <tr>
                        <td>端口数：</td>
                        <td><input id="portNumber" name="portNumber" type="text" class="easyui-validatebox"/></td>        
<!--                         <td id="td_config">上传配置文件：</td> -->
<!--                         <td><input id="configFile" name="configFile" class="easyui-validatebox" type="text" style="width: 126px; " required="true"/><input id="file" name="file" type="file" style="width: 60px;" onchange="document.getElementById('configFile').value=this.value"/> -->
                     	
                    </tr>
                </table>
                </div>
             <div region="south" border="false" style="text-align: right; height: 30px; line-height: 30px;">
             	
                <a id="btnUpdate" class="easyui-linkbutton" icon="icon-ok" href="javascript:void(0);" >
                    保存</a> <a id="cancel" class="easyui-linkbutton" icon="icon-cancel" href="javascript:void(0);"
                        onclick="closeLogin()">取消</a>
            </div>
	</form>
</html>