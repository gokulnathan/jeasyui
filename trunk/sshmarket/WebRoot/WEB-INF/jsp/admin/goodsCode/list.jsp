<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ include file="../../common/inc/tld.jsp"%>
<jsp:include page="../../common/inc/header.jsp">
    <jsp:param name="title" value="商品管理-商品兑换码列表"/>
</jsp:include>
<a href="${ctx}/admin/goodsCode/doAdd.action?goodsId=${model.id}">新增</a>|
<a href="${ctx}/admin/goods/list.action">返回商品列表</a><br/>
<table border="1">
    <tr>
        <th>ID</th>
        <th>所属商品</th>
        <th>兑换码</th>
        <th>购买人</th>
        <th>兑换时间</th>
        <th>是否已经兑换</th>
        <th></th>
    </tr>
    <s:iterator value="page.items">
    <tr>
        <td><s:property value="id"/></td>
        <td><s:property value="goods.name"/></td>
        <td><s:property value="code"/></td>
        <td><s:property value="username"/></td>
        <td><s:date name="exchangeTime" format="yyyy-MM-dd"/></td>
        <td><s:property value="exchanged"/></td>
        <td>删除</td>
    </tr>    
    </s:iterator>
</table>
<!--<my:page url="${ctx}/admin/goodsCode/list.action?goodsId=${model.id}" version="v1"/>-->
<jsp:include page="../../common/inc/footer.jsp"/>