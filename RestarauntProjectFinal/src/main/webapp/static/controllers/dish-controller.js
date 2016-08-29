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
            if ($scope.dish.id != 0) {
                
                console.log($scope.dish);
                $http.put("/api/dish/", $scope.dish)
                    .then(
                        function(response){
                            console.log("Dish updated successfully")
                            $scope.refreshDishList();
                        },
                        function(response){
                            console.log("Dish updating failed!")
                        }
                    );
            }
            if ($scope.dish.id == 0) {
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
            }
        };

        $scope.editDish = function (editDish) {
            $scope.dish.dishName = editDish.dishName;
            $scope.dish.price = editDish.price;
            $scope.dish.weight = editDish.weight;
            $scope.dish.categoryId = editDish.categoryId;
            $scope.dish.id = editDish.id;
        }

        $scope.clearFields = function () {
            $scope.dish = {
                "id": 0,
                "dishName": "",
                "price": 0,
                "weight": 0,
                "categoryId" : 0
            };
        };


    }]);