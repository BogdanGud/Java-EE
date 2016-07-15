<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Task Manager</title>
</head>
<body>
<div>
    <h3>My Tasks</h3>
</div>

<h1>TODO List</h1>
<hr>

<div>
    <form action="taskServlet" method="post">
        <table>
            <tr>
                <th>Name</th>
                <th>Category</th>
                <th>Complete</th>
            </tr>
            <c:set var="count" value="0"/>
            <c:forEach items="${tasks}" var="task" varStatus="taskLoop">
                <tr>
                    <td><c:out value="${task.name}"/></td>
                    <td><c:out value="${task.category}"/></td>
                    <td><input name="status" type="checkbox" value="${taskLoop.index}" autofocus></td>
                </tr>
            </c:forEach>
        </table>
        <br><br>
        <input type="hidden" name="action" value="update">
        <input type="submit" value="Update task">
    </form>
</div>
<hr>
<div>
    <form action="taskServlet" method="post">
        <label>Task name</label>
        <input name="name" type="text" autofocus placeholder="Please enter task name">
        <br><br>
        <label>Task category</label>
        <input name="category" type="text" autofocus placeholder="Please enter task category">
        <br><br>
        <input type="hidden" name="action" value="add">
        <input type="submit" value="Add task">
    </form>
</div>
</body>
</html>