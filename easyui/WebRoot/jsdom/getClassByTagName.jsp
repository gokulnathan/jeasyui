<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>getClassByTagName</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script  src="ADS.js"></script>

  </head>
  
  <body>
   <h1 class="findme"> ADS.getElementsByTagName() example</h1>
   <p class="findme"> this is just an <em class='a'> em=ample</em></p>
   <div id="theList">
   	<h2 class="findme"> a list!</h2>
   	<ol>
   		<li class="findme">Foo</li>
   		<li class="findme">Bar</li>
   	</ol>
   </div>
  </body>
  <script type="text/javascript">
	var found = ADS.getElementsByClassName("findme","*",document);
	alert(found);
</script>
</html>

