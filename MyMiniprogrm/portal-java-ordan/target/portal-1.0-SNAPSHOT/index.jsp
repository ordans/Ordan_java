<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %></h1>
<br/>

<a href="user/add.mvc?realName=&Mobile=&sex=&Yzm=&school=&classList=&course=">发送Get请求</a>
<br>

<form method="post" action="user/add.mvc">

    <input name="realName" value="Ordan"> <br>
    <input name="Mobile" value="15220957111"> <br>
    <input name="sex" value="boy"> <br>
    <input name="Yzm" value="123456"> <br>
    <input name="school" value="广东理工学院"> <br>
    <input name="classList" value="6"> <br>
    <input name="course" value="JAVA"> <br>

    <input type="submit" value="提交">

</form>
</body>
</html>