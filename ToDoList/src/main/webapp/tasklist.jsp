<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <link href="css/styles.css" rel="stylesheet"/>
    <title>Task Manager</title>
</head>
<body>
<div class="main-container">
    <div class="header">
        My Tasks
    </div>
    <div id="todolist">
        TODO List
    </div>

    <hr>
    <div>
        <form action="taskServlet" method="post">
            <table class="task-list">
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
            <input type="submit" class="button" value="Update task">
        </form>
    </div>
    <hr>
    <div>
        <form action="taskServlet" method="post">
            <label>Task name</label><br>
            <input name="name" type="text" autofocus placeholder="Please enter task name">
            <br><br>
            <label>Task category</label><br>
            <input name="category" type="text" autofocus placeholder="Please enter task category">
            <br><br>
            <input type="hidden" name="action" value="add">
            <input type="submit" class="button" value="Add task">
        </form>
    </div>

</div>

<div>
    <h2>HTTP Header Request Example</h2>
    <table width="100%" border="1" align="center">
        <tr bgcolor="#949494">
            <th>Header Name</th>
            <th>Header Value(s)</th>
        </tr>
        <c:forEach items="${header.keySet()}" var="headerName">
            <tr>
                <td><c:out value="${headerName}"/></td>
                <td><c:out value="${header.get(headerName)}"/></td>
            </tr>
        </c:forEach>


    </table>
</div>
</body>
</html>