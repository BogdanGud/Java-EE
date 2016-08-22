angular.module('appModule.controllers', [])
    .controller('MainController', ['$scope', '$http', function ($scope, $http) {

        $scope.employeesList = [];
        $scope.employee = {
            "id": 0,
            "name": "",
            "surname": "",
            "birthDate": "",
            "phoneNumber": "",
            "positionId": 0,
            "salary": 0
        };
        $scope.refreshEmployeeList = function () {
            $http.get("/api/employees")
                .then(function (response) {
                    // $scope.products = response.data;
                    console.log(response);
                    $scope.employeesList = response.data;

                });
        };

        $scope.deleteEmployee = function (employeeId) {
            //console.log("removing ", employeeId);
            $http.delete("/api/employee/" + employeeId)
                .then(function (responce) {
                    console.log("Employee deleted");
                    $scope.refreshEmployeeList();
                }, function (response) {
                    console.log("Employee deleting failed!");
                });
        };

        $scope.saveEmployee = function () {
            console.log($scope.employee);
            $http.post("/api/employee/", $scope.employee)
                .then(
                    function(response){
                        console.log("Employee created successfully")
                        $scope.refreshEmployeeList();
                    },
                    function(response){
                        console.log("Employee creating failed!")

                    }
                );
        };

        $scope.clearFields = function () {

        };


    }]);