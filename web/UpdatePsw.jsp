<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/21
  Time: 16:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="UpdatePsw.do" method="post">
        用户名：<input type="text" name="username"/>
        <br/>
        密码：<input type="password" name="psw"/>
        <br/>
        新密码：<input type="password" name="newPsw"/>
        <br/>
        <input type="submit" value="确认修改"/>
    </form>
</body>
</html>
