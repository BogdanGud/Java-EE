<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dishes</title>
</head>
<body>
<table style="align-items: center">
    <tr>
        <th>Dishes name</th>


    </tr>
    <c:forEach var="dish" items="${dishes}" >
        <tr>
            <td><a href="/restaurant/dish?dishName=${dish.dishName}">${dish.dishName}</a></td>


        </tr>
    </c:forEach>


</table>
</body>
</html>
