<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<style type="text/css">
	
</style>
</head>
<body>
	<h1 align="center">修改页面</h1>
	<form action="update.do" method="post">
		<table align="center" border="1px" cellpadding="0" cellspacing="0">
		<input type="hidden" name="id" value="${u.id }" />	
			<tr>
				<td width="30px">id</td>
				<td>姓名</td>
			</tr>
			<tr>
				<td>${u.id}</td>
				<td><input type="text" name="name" value="${u.name }"/></td>
			</tr>
			<tr>
				<td colspan="2" align="right"><input type="submit" value="提交"/></td>
			</tr>
		</table>
	</form>

</body>
</html>