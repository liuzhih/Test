<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style type="text/css">
	table{
		border-right:1px solid red;
		border-bottom:1px solid red;
	}
	table td{
		border-left:1px solid red;
		border-top:1px solid red;
		width: 100px;
	}

</style>
<body>	
	<h1 align="center">表单管理</h1>
	<table align="center" class="ta" cellspacing="0" cellpadding="0">
		<tr>
			<td>ID</td>
			<td>姓名</td>
			<td colspan=2>操作</td>
		</tr>
		<c:forEach items="${list}" var="l">
		
			<tr>
				<td>${l.id}</td>
				<td>${l.name}</td>
				<td><input type="button" onclick="window.location.href='delete.do?id=${l.id}'" value="删除"></td>
				<td><input type="button" onclick="window.location.href='search.do?id=${l.id}'" value="修改"></td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan=4 align="right"><input type="button" value="新增" onclick="window.location.href='/new.jsp'"/></td>
		</tr>
	</table>
</body>
</html>