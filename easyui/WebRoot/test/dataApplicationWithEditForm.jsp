<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="keywords" content="jquery,ui,easy,easyui,web">
	<meta name="description" content="easyui help you build your web page easily!">
	<title>上面表格，点击到某行可编辑</title>
	<link rel="stylesheet" type="text/css" href="../themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="../themes/icon.css">
	<link rel="stylesheet" type="text/css" href="demo.css">
	<script type="text/javascript" src="../jquery-1.7.1.min.js"></script>
	<script type="text/javascript" src="../jquery.easyui.min.js"></script>
	<script type="text/javascript" src="../js/datagrid-detailview.js"></script>
	
	
	<script type="text/javascript">
		$(function(){
			$("#dg").datagrid({
				view: detailview,
				detailFormatter:function(index,row){
					return "<div class='ddv'></div>";
				},
				onExpandRow: function(index,row){
					var ddv = $(this).datagrid("getRowDetail",index).find("div.ddv");
					ddv.panel({
						border:false,
						cache:true,
						href:"show_form.jsp?index="+index,
						onLoad:function(){
							$("#dg").datagrid("fixDetailRowHeight",index);
							$("#dg").datagrid("selectRow",index);
							$("#dg").datagrid("getRowDetail",index).find("form").form("load",row);
						}
					});
					$("#dg").datagrid("fixDetailRowHeight",index);
				}
			});
		});
		function saveItem(index){
			var row = $("#dg").datagrid("getRows")[index];
			var url = row.isNewRecord ? "<%=basePath%>/servlet/DataApplicationWithEditFormServlet?flag=addNew" : "<%=basePath%>/servlet/DataApplicationWithEditFormServlet?flag=edit&id="+row.id;
			$("#dg").datagrid("getRowDetail",index).find("form").form("submit",{
				url: url,
				onSubmit: function(){
					return $(this).form("validate");
				},
				success: function(data){
					data = eval("("+data+")");
					data.isNewRecord = false;
					$("#dg").datagrid("collapseRow",index);
					$("#dg").datagrid("updateRow",{
						index: index,
						row: data
					});
				}
			});
		}
		function cancelItem(index){
			var row = $("#dg").datagrid("getRows")[index];
			if (row.isNewRecord){
				$("#dg").datagrid("deleteRow",index);
			} else {
				$("#dg").datagrid("collapseRow",index);
			}
		}
		
		//删除一条记录
		function destroyItem(){
			var row = $("#dg").datagrid("getSelected");
			if (row){
				$.messager.confirm("Confirm","你确认要删除这条记录吗？",function(r){
					if (r){
						var index = $("#dg").datagrid("getRowIndex",row);
						$.post("<%=basePath%>/servlet/DataApplicationWithEditFormServlet?flag=remove",{id:row.id},function(){
							$("#dg").datagrid("deleteRow",index);
						});
					}
				});
			}
		}
		
		//新增一行
		function newItem(){
			$("#dg").datagrid("appendRow",{isNewRecord:true});
			var index = $("#dg").datagrid("getRows").length - 1;
			$("#dg").datagrid("expandRow", index);
		//	$("#dg").datagrid("selectRow", index);
		}
	</script>
</head>
<body>
	<h2>Edit form in expanded row details</h2>
	<div class="demo-info" style="margin-bottom:10px">
		<div class="demo-tip icon-tip">&nbsp;</div>
		<div>Click the expand button to expand a detail form.</div>
	</div>
	
	
	<table id="dg" title="用户信息" style="width:700px;height:250px"
			url="<%=basePath%>/servlet/DataApplicationWithEditFormServlet"
			toolbar="#toolbar" pagination="true"
			fitColumns="true" singleSelect="true">
		<thead>
			<tr>
				<th field="firstName" width="50">First Name</th>
				<th field="lastName" width="50">Last Name</th>
				<th field="phone" width="50">Phone</th>
				<th field="email" width="50">Email</th>
			</tr>
		</thead>
	</table>
	<div id="toolbar">
		<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newItem()">New</a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyItem()">Destroy</a>
	</div>
	
</body>
</html>