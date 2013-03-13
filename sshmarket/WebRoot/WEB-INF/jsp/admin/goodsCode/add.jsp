<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ include file="../../common/inc/tld.jsp"%>
<jsp:include page="../../common/inc/header.jsp">
    <jsp:param name="title" value="用户管理-新增"/>
</jsp:include>
<s:fielderror cssStyle="color:red"/>
<s:form action="/admin/goodsCode/add.action" method="POST" acceptcharset="UTF-8">
<s:token/>
<s:hidden name="goodsId" value="%{model.id}" />
<table border="1">
    <tr>
        <s:textfield label="所属商品" name="model.name" readonly="true"/>
    </tr>
    <tr>
        <s:textarea label="兑换码" name="codes" cols="20" rows="3"/>
    </tr>
    <tr>
       <td><input name="submit" type="submit" value="新增"/></td>
       <td><input name="cancel" type="button" onclick="javascript:window.location.href='${ctx}/admin/goodsCode/list.action?goodsId=<s:property value='%{model.id}'/>'" value="取消"/></td>
    </tr>    
</table>
</s:form>
<jsp:include page="../../common/inc/footer.jsp"/>