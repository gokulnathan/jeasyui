<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="keywords" content="jquery,ui,easy,easyui,web">
	<meta name="description" content="easyui help you build your web page easily!">
	<title>第一个可行内编辑的dataGrid</title>
	<link rel="stylesheet" type="text/css" href="../themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="../themes/icon.css">
	<link rel="stylesheet" type="text/css" href="demo.css">
	<script type="text/javascript" src="../jquery-1.7.1.min.js"></script>
	<script type="text/javascript" src="../jquery.easyui.min.js"></script>
	<!-- 注意引入相关的JS包 -->
	<script type="text/javascript" src="../plugins/jquery.edatagrid.js"></script>
	<script type="text/javascript">
		$(function(){
			$("#dg").edatagrid({
				url: "<%=basePath%>/servlet/DataGridServlet",
				saveUrl: "<%=basePath%>/servlet/DataGridServlet?flag=addNew",
				updateUrl: "<%=basePath%>/servlet/DataGridServlet?flag=edit",
				destroyUrl: "<%=basePath%>/servlet/DataGridServlet?flag=remove"
			});
		});
	</script>
</head>
<body>
	<h2>可行内编辑的DataGrid</h2>
	<div class="demo-info" style="margin-bottom:10px">
		<div class="demo-tip icon-tip">&nbsp;</div>
		<div>Double click the row to begin editing.</div>
	</div>
	
	<table id="dg" title="用户信息" style="width:700px;height:250px"
			toolbar="#toolbar" pagination="true"
			rownumbers="true" fitColumns="true" singleSelect="true">
		<thead>
			<tr>
				<th field="firstName" width="50" editor="{type:'validatebox',options:{required:true}}">First Name</th>
				<th field="lastName" width="50" editor="{type:'validatebox',options:{required:true}}">Last Name</th>
				<th field="phone" width="50" editor="text">Phone</th>
				<th field="email" width="50" editor="{type:'validatebox',options:{validType:'email'}}">Email</th>
			</tr>
		</thead>
	</table>
	<div id="toolbar">
		<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="javascript:$('#dg').edatagrid('addRow')">New</a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="javascript:$('#dg').edatagrid('destroyRow')">Destroy</a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-save" plain="true" onclick="javascript:$('#dg').edatagrid('saveRow')">Save</a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-undo" plain="true" onclick="javascript:$('#dg').edatagrid('cancelRow')">Cancel</a>
	</div>
	
</body>
</html>