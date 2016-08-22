angular.module('dishModule.controllers', [])
    .controller('DishController', ['$scope', '$http', function ($scope, $http) {

        $scope.dishesList = [];
        $scope.dish = {
            "id": 0,
            "dishName": "",
            "price": 0,
            "weight": 0,
            "categoryId" : 0
        };
        $scope.refreshDishList = function () {
            $http.get("/api/dishes")
                .then(function (response) {
                    // $scope.products = response.data;
                    console.log(response);
                    $scope.dishesList = response.data;

                });
        };

        $scope.deleteDish = function (dishId) {
            console.log("removing ", dishId);
            $http.delete("/api/dish/" + dishId)
                .then(function (responce) {
                    console.log("Dish deleted");
                    $scope.refreshDishList();
                }, function (response) {
                    console.log("Dish deleting failed!");
                });
        };
        
        $scope.saveDish = function () {
            console.log($scope.dish);
            $http.post("/api/dish/", $scope.dish)
                .then(
                    function(response){
                        console.log("Dish created successfully")
                        $scope.refreshDishList();
                    },
                    function(response){
                        console.log("Dish creating failed!")
        
                    }
                );
        };
        
        $scope.clearFields = function () {
        
        };


    }]);