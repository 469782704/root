<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>demoString</title>
</head>
<body>
	demoPost
	<form action="/spring-web/test/demoPost" method="post">
	姓名：<input id="name" name="sname" type="text"/><br/>
	年龄：<input id="age" name="sid" type="password"/><br/>
	<input type="submit" value="提交"/>
	</form>
	demoPostUser
	<form action="/spring-web/test/demoPostUser" method="post">
	姓名：<input id="name" name="name" type="text"/><br/>
	年龄：<input id="age" name="age" type="password"/><br/>
	<input type="submit" value="提交"/>
	</form>
	
	demoUpload
	<form action="/spring-web/test/demoUpload" method="post" enctype="multipart/form-data">
	<input type="file" name="file"/>
	<input type="submit" value="提交">
	</form>
	
</body>
</html>