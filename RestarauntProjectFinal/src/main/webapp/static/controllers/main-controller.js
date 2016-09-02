angular.module('appModule.controllers', [])
    .controller('MainController', ['$scope', '$http', function ($scope, $http) {

        $scope.employeesList = [];
        $scope.birthDate = new Date();
        $scope.employee = {
            "id": 0,
            "name": "",
            "surname": "",
            "birthDate": 0,
            "phoneNumber": "",
            "positionId": 0,
            "salary": 0
        };
        $scope.refreshEmployeeList = function () {
            $http.get("/restaurant/api/employees")
                .then(function (response) {
                    // $scope.products = response.data;
                    console.log(response);
                    $scope.employeesList = response.data;

                });
        };

        $scope.deleteEmployee = function (employeeId) {
            //console.log("removing ", employeeId);
            $http.delete("/restaurant/api/employee/" + employeeId)
                .then(function (responce) {
                    console.log("Employee deleted");
                    $scope.refreshEmployeeList();
                }, function (response) {
                    console.log("Employee deleting failed!");
                });
        };

        $scope.saveEmployee = function () {
            if ($scope.employee.id != 0 ) {
                var birthDate = new Date($scope.employee.birthDate);
                var day = birthDate.getDate();
                var month = birthDate.getMonth();
                var year = birthDate.getFullYear();
                $scope.employee.birthDate = year + '-' + month + '-' + day;
                console.log($scope.employee);
                $http.put("/restaurant/api/employee/", $scope.employee)
                    .then(
                        function (response) {
                            console.log("Employee created successfully")
                            $scope.refreshEmployeeList();
                        },
                        function (response) {
                            console.log("Employee creating failed!")

                        }
                    );
            }
            if ($scope.employee.id == 0 ) {
                var birthDate = new Date($scope.employee.birthDate);
                var day = birthDate.getDate();
                var month = birthDate.getMonth();
                var year = birthDate.getFullYear();
                $scope.employee.birthDate = year + '-' + month + '-' + day;
                console.log($scope.employee);
                $http.post("/restaurant/api/employee/", $scope.employee)
                    .then(
                        function (response) {
                            console.log("Employee created successfully")
                            $scope.refreshEmployeeList();
                        },
                        function (response) {
                            console.log("Employee creating failed!")

                        }
                    );
            }
        };
        
        $scope.editEmployee = function (editEmployee) {
            $scope.employee.id = editEmployee.id;
            $scope.employee.name = editEmployee.name;
            $scope.employee.surname = editEmployee.surname;
            $scope.employee.phoneNumber = editEmployee.phoneNumber;
            $scope.employee.birthDate = (new Date(editEmployee.birthDate)).toLocaleDateString();
            $scope.employee.positionId = editEmployee.positionId;
            $scope.employee.salary = editEmployee.salary;
            console.log($scope.employee);
            console.log($scope.stringBirthDate);
        }

        $scope.clearFields = function () {

        };


    }]);