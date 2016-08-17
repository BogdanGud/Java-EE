<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employees</title>
</head>
<body>
<table style="align-items: center">
    <tr>
        <th>First name</th>
        <th>Last name</th>

    </tr>
    <c:forEach var="employee" items="${employees}" >
        <tr>
            <td><a href="/employee?employeeName=${employee.name}">${employee.name}</a></td>
            <td>${employee.surname}</td>

        </tr>
    </c:forEach>


</table>
</body>
</html>
