<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录成功</title>
</head>
<body>
    <h3>用户登录成功页面</h3>
    欢迎用户:${user.username}<br>
    <a href="${ctx}/user/admin">admin页面</a><br/>
    <a href="${ctx}/user/student">student页面</a><br/>
    <a href="${ctx}/user/teacher">teacher页面</a><br/>
    <a href="${ctx}/user/logout">退出登录</a>

</body>
</html>
