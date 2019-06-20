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
    <form action=meals method="post">
        <p>
            <select size="10">
                <c:forEach var="usr" items="${users}">
                    <option value="${usr}">${usr}</option>
                </c:forEach>
            </select>
        </p>
        <p>
            <input type="submit" value="go">
        </p>
    </form>
</body>
</html>