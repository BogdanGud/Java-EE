angular.module('appModule.controllers', [])
    .controller('MainController', ['$scope', '$http', function ($scope, $http) {

        $scope.employeesList = [];
        $scope.birthDateEmployee = new Date();
        $scope.employee = {
            "id": 0,
            "name": "",
            "surname": "",
            "birthDateEmployee": "",
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
        
        $scope.editEmployee = function (editEmployee) {
            $scope.employee.id = editEmployee.id;
            $scope.employee.name = editEmployee.name;
            $scope.employee.surname = editEmployee.surname;
            $scope.employee.phoneNumber = editEmployee.phoneNumber;
            $scope.employee.birthDateEmployee = editEmployee.birthDateEmployee;
            $scope.employee.positionId = editEmployee.positionId;
            $scope.employee.salary = editEmployee.salary;
            console.log($scope.employee);
        }

        $scope.clearFields = function () {

        };


    }]);