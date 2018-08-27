<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询商品列表</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.4.2.js"></script>
<script type="text/javascript">
	function sendJson(){
		alert(222);
		var url="${pageContext.request.contextPath}/items/transJson.action";
		var params={
				"id":20,
				"name":"笔记本电脑",
				"price":30000,
				"detail":"这个笔记本很不错",
				"pic":"14.png",
				"createtime":"2014-11-11 22:22:22"
		};
		alert(params);
		$.post(url,params,function(data){
			alert(333);
			alert(data);
		},"json");
		alert(4444);
	}
</script>
</head>
<body> 
<button  onclick="sendJson()">发送json</button>
<form action="${pageContext.request.contextPath }/items/deleteItemsByIds" method="post">
查询条件：
<table width="100%" border=1>
<tr>
<td><input type="submit" value="查询"/></td>
<td><input type="submit" value="批量删除"/></td>
</tr>
</table>
商品列表：
<table width="100%" border=1>
<tr>
	<td>商品名称</td>
	<td>商品价格</td>
	<td>生产日期</td>
	<td>商品描述</td>
	<td>操作</td>
</tr>
<c:forEach items="${itemsList }" var="item">
<tr>
	<td><input type="checkbox" name="ids" value="${item.id}"/></td>
	<td>${item.name }</td>
	<td>${item.price }</td>
	<td><fmt:formatDate value="${item.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
	<td>${item.detail }</td>
	<td><a href="${pageContext.request.contextPath }/items/itemEdit/${item.id}">修改</a></td>
</tr>
</c:forEach>

</table>
</form>
</body>

</html>