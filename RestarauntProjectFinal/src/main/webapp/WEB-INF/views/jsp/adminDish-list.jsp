<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>AngularJS $http Example</title>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
    <script src="<c:url value="/static/app.js" />"></script>
    <script src="<c:url value="/static/controllers/dish-controller.js" />"></script>
    <script src="<c:url value="/static/controllers/main-controller.js" />"></script>
    <script src="<c:url value="/static/jquery/dist/jquery.js" />"></script>
    <script src="<c:url value="/static/jquery/dist/jquery.min.js" />"></script>
    <script src="<c:url value="/static/bootstrap/dist/js/bootstrap.min.js" />"></script>
    <link href="${pageContext.request.contextPath}/static/main.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/static/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet"/>

</head>
<body ng-controller="DishController">
<div class=" container">
 <div class="main-container">
     <button type="button" class="btn btn-primary" ng-click="refreshDishList()">
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
                 <button  class="btn btn-default" ng-click="deleteDish(dish.id)">
                 Delete
                 </button>
             </td>
             <td>
                 <button  class="btn btn-default" type="submit" ng-click="editDish(dish)">
                     Edit
                 </button>
             </td>
         </tr>
         </tbody>
     </table>
     <span ng-show="dishesList.length > 10"> There are more than 10 dish, please be carefull. </span>
 </div>
    <div class="form-container">
    <form class="form-horizontal">
        <div class="form-group">
            <label for="inputEmail3" class="col-sm-2 control-label">Email</label>
            <div class="col-sm-10">
                <input type="email" class="form-control" id="inputEmail3" placeholder="Email">
            </div>
        </div>
        <div class="form-group">
            <label for="inputPassword3" class="col-sm-2 control-label">Password</label>
            <div class="col-sm-10">
                <input type="password" class="form-control" id="inputPassword3" placeholder="Password">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <div class="checkbox">
                    <label>
                        <input type="checkbox"> Remember me
                    </label>
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-default">Sign in</button>
            </div>
        </div>
    </form>
</div>





    <div class="form-container">
        <div class="form-row">
            <label>Name</label>
            <input id="form-row-name" type="text" ng-model="dish.dishName"/>
        </div>
        <div class="form-row">
            <label>Price</label>
            <input id="form-row-price" type="text" ng-model="dish.price"/>
        </div>
        <div class="form-row">
            <label>Weight</label>
            <input id="form-row-weight" type="text" ng-model="dish.weight"/>
        </div>
        <div class="form-row">
            <label>Category</label>
            <select id="form-row-category" ng-model="dish.categoryId">
                <option selected value="1">SALAD</option>
                <option value="5">Soup</option>
            </select>
        </div>
        <input hidden id="form-row-id" type="text" ng-model="dish.id"/>
        <button type="button" class="btn btn-success" ng-click="saveDish()">
            Save
        </button>
        <button type="button" class="btn btn-warning" ng-click="clearFields()">
            Clear
        </button>


    </div>

</div>


</body>
</html>
