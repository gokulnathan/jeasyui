<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>Js Dom 高级程序设计</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script src="chapter1/popup/popupLoadEvent.js"></script>
<style type="text/css">
	.popup {
		padding-right: 25px;
		background: transparent url(chapter1/images/popup.png) no-repeat right center;
	}
</style>

<script type="text/javascript">
	function pop(url) {
		alert("jerry");
		window.open(url);
	}
	
	//包围函数的第一对括号向脚本返回未命名的函数，随后的一对空括号立即执行返回的未命名函数。
	(function(){
		
	})();//自执行的匿名函数
	
	/**
	使用这种伪命名空间可以封装并保护自己的所有函数，对象和变量。而且，由于他们处于同一函数中，
	所以他们之间可以相互访问。不过，脚本中的其他代码不能使用你的函数。
	为了对受保护的部分代码进行全局化，随后 一对括号告诉浏览器立即执行返回的匿名函数，而且在执行期间，
	最后几行代码将alertNodeName()赋值给了window的一个方法 window['myNamespace']['showNodeName']
	myNamespace.showNodeName("hello").调用时，这个方法是在你的匿名函数的命名空间中执行的，因此它
	仍然能够访问你专用的$()函数和该命名空间中的其他对象，以及作用域链中位于这个包装外部的所有对象
	
	**/
	(function(){
		function $(id) {
			return document.getElementById(id);
		}
		function alertNodeName(id) {
			//alert(id);
			alert($(id).nodeName);
		}
		
		window['myNamespace'] = {};
		window['myNamespace']['showNodeName'] = alertNodeName;
	})();
	
	myNamespace.showNodeName("hello");
	
	
</script>
</head>

<body>
	Js Dom 高级程序设计
	<!-- <a href="http://www.baidu.com" onclick="pop(this.href);return false;">click me</a>-->
	<a href="http://www.baidu.com" class="popup">click me</a>
	<br>
</body>
</html>
