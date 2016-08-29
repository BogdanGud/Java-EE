<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>AngularJS $http Example</title>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
    <script src="<c:url value="/static/app.js" />"></script>
    <script src="<c:url value="/static/controllers/main-controller.js" />"></script>
    <script src="<c:url value="/static/controllers/dish-controller.js" />"></script>
    <link href="/static/main.css" rel="stylesheet"/>


</head>
<body ng-controller="MainController">
<div class="main-container">

    <button ng-click="refreshEmployeeList()">
        Refresh
    </button>

    <table>
        <thead>
        <tr>
            <th>Employee name</th>
            <th>Employee surname</th>
            <th>Phone number</th>
            <th>salary</th>
            <th>position</th>
        </tr>
        </thead>
        <tbody>
        <tr ng-repeat="employee in employeesList">
            <td>{{employee.name}}</td>
            <td>{{ employee.surname }}</td>
            <td>{{ employee.phoneNumber }}</td>
            <td>$ {{ employee.salary }}</td>
            <td> {{ employee.positionId }}</td>
            <td>
                <button ng-click="deleteEmployee(employee.id)">
                    Delete
                </button>
                <button ng-click="editEmployee(employee)">
                    Edit
                </button>
            </td>
        </tr>
        </tbody>
    </table>
    <span ng-show="employeesList.length > 10"> There are more than 10 employee, please be carefull. </span>
</div>
<div class="form-container">
    <div class="form-row">
        <label>Name</label>
        <input type="text" ng-model = "employee.name"/>
    </div>
    <div class="form-row">
        <label>Surname</label>
        <input type="text" ng-model = "employee.surname"/>
    </div>
    <div class="form-row">
        <label>Phone number</label>
        <input type="text" ng-model = "employee.phoneNumber"/>
    </div>
    <div class="form-row">
        <label>Birth date</label>
        <input type="text" ng-model = "employee.birthDateEmployee"/>
    </div>
    <div class="form-row">
        <label>Position</label>
        <select ng-model = "employee.positionId">
            <option value="1">Waiter</option>
            <option value="2">Cook</option>
        </select>
    </div>
    <div class="form-row">
        <label>Salary</label>
        <input type="text" ng-model = "employee.salary"/>
    </div>
    <button ng-click = "saveEmployee()">
        Save
    </button>
    <button ng-click = "clearFields()">
        Clear
    </button>

</div>


</body>
</html>
