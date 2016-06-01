<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
    This is my JSP page. <br><br>
    <a href="token" >获取token</a><br>
    <a href="getcallbackip" >获取微信服务器地址</a><br>
     <a href="createMenu" >创建自定义菜单</a><br>
     <a href="getMaterialcount" >获取永久素材状况</a><br>
     <a href="uploadMedia" >上传临时素材</a><br>
     <a href="uploadMaterial" >上传永久素材素材(图片、缩略图、音频)</a><br>
     <a href="uploadNewsImg" >上传图文素材的图片，并获取URL</a><br>
     <a href="uploadMaterialNews" >上传永久图文素材</a><br>
  </body>
</html>
