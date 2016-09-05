<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employees</title>
</head>
<body>
<table style="align-items: center">
    <tr>
        <th>Dish name</th>
        <th>Dish category</th>
        <th>Dish price</th>
        <th>Dish weight</th>

    </tr>
    <tr>
        <td>${dish.dishName}</td>
        <td>${dish.categoryDish.categoryName}</td>
        <td>${dish.price}</td>
        <td>${dish.weight}</td>

    </tr>


</table>
</body>
</html>
