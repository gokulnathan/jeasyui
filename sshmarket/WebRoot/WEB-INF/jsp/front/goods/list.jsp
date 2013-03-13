<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ include file="../../common/inc/tld.jsp"%>
<jsp:include page="../../common/inc/header.jsp">
    <jsp:param name="title" value="积分商城-商品列表"/>
</jsp:include>
<s:iterator value="page.items" status="status">
	<s:property value="#status.index + 1"/>.<s:property value="name"/>
	<a href="${ctx}/goods/buy.action?goodsId=<s:property value='id'/>">【购买】</a><br/>
	描述：<s:property value="description"/><br/>
	<S>需要积分<s:property value="originalPoint"/></S>&nbsp;&nbsp;现需积分：<B><s:property value="nowPoint"/></B><br/>
</s:iterator>
<!--<my:page url="${ctx}/goods/list.action" version="v2"/>-->
<jsp:include page="../../common/inc/footer.jsp"/>