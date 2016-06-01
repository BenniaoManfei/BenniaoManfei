<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>这是一个介绍面试梵净冷杉了</h3>
	<img alt="" src="http-404.png">图片<br>
	<br>
	<h3>这是一个介绍面试梵净冷杉了</h3>
	<h3>这是一个介绍面试梵净冷杉了</h3>
	
	<h3>这是一个介绍面试梵净冷杉了</h3>
	<h3>这是一个介绍面试梵净冷杉了</h3><br><br>
	
	
	<img alt="" src="<%=request.getAttribute("newImg")%>">
</body>
</html>