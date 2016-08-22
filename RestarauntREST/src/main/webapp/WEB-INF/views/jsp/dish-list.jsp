<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>AngularJS $http Example</title>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
    <script src="<c:url value="/static/app.js" />"></script>
    <script src="<c:url value="/static/controllers/dish-controller.js" />"></script>
    <script src="<c:url value="/static/controllers/main-controller.js" />"></script>
    <link href="/static/main.css" rel="stylesheet"/>


</head>
<body ng-controller="DishController">
<div class="main-container">

    <button ng-click="refreshDishList()">
        Refresh
    </button>

    <table>
        <thead>
        <tr>

            <th>Dish name</th>
            <th>Dish category</th>

        </tr>
        </thead>
        <tbody>
        <tr ng-repeat="dish in dishesList">
            <td>{{dish.dishName}}</td>
            <td>{{dish.categoryDish.categoryName}}</td>


            <td>
                <button ng-click="deleteDish(dish.id)">
                    Delete
                </button>
            </td>
        </tr>
        </tbody>
    </table>
    <span ng-show="dishesList.length > 10"> There are more than 10 dish, please be carefull. </span>
</div>
<div class="form-container">
    <div class="form-row">
        <label>Name</label>
        <input type="text" ng-model = "dish.dishName"/>
    </div>
    <div class="form-row">
        <label>Price</label>
        <input type="text" ng-model = "dish.price"/>
    </div>
    <div class="form-row">
        <label>Weight</label>
        <input type="text" ng-model = "dish.weight"/>
    </div>
    <div class="form-row">
        <label>Category</label>
        <select ng-model = "dish.categoryId">
            <option value="1">SALAD</option>
            <option value="5">Soup</option>
        </select>
    </div>
    <button ng-click = "saveDish()">
        Save
    </button>
    <button ng-click = "clearFields()">
        Clear
    </button>

</div>


</body>
</html>
