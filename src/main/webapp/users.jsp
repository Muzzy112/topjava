<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Users</title>
</head>
<body>
<h3><a href="index.html">Home</a></h3>
<hr>
<h2>Users</h2>
<p>
    <form action="users" method="post">
        <button type="submit" name="userId" value="1">Admin</button>
        <button type="submit" name="userId" value="2">User</button>
    </form>
</p>
</body>
</html>