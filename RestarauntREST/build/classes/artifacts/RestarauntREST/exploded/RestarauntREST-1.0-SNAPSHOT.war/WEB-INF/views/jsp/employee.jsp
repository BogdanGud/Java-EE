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
        <th>Phone Number</th>

    </tr>
        <tr>
            <td>${employee.name}</td>
            <td>${employee.surname}</td>
            <td>${employee.phoneNumber}</td>

        </tr>


</table>
</body>
</html>
