<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>demoString</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-3.3.1.js"></script>
<script type="text/javascript">
	$(function(){
		alert("静态资源可以出来了");
	});
</script>
</head>
<body>
	demoPost
	<form action="/spring-web/test/demoPost" method="post">
	姓名：<input id="demoPost_name" name="sname" type="text"/><br/>
	年龄：<input id="demoPost_age" name="sid" type="password"/><br/>
	<input type="submit" value="提交"/>
	</form>
	demoPostUser
	<form action="/spring-web/test/demoPostUser" method="post">
	姓名：<input id="demoPostUser_name" name="name" type="text"/><br/>
	年龄：<input id="demoPostUser_age" name="age" type="password"/><br/>
	<input type="submit" value="提交"/>
	</form>
	
	demoUpload
	<form action="/spring-web/test/demoUpload" method="post" enctype="multipart/form-data">
	<input type="file" name="file"/>
	<input type="submit" value="提交">
	</form>
	
</body>
</html>