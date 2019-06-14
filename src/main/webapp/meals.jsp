<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: superpony
  Date: 14.06.2019
  Time: 13:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Meals</title>

    <style type="text/css">
        table{
            text-align: center;
        }

        .green{
            color: green;
        }
        .red{
            color: red;
        }

    </style>
</head>
<body>

<h3><a href="index.html">Home</a></h3>

<table class = "table1">
    <tr>
        <th>Дата\Время</th>
        <th>Дескрипшн</th>
        <th>Калорийность</th>
    </tr>

    <c:forEach var="meal" items="${meals}">
        <c:if test="${meal.get(3) eq false}">
            <tr class = "green">
        </c:if>
        <c:if test="${meal.get(3) eq true}">
            <tr class = "red">
        </c:if>

            <td>${meal.get(0)}</td>
            <td>${meal.get(1)}</td>
            <td>${meal.get(2)}</td>
        </tr>
    </c:forEach>

</table>

</body>
</html>
