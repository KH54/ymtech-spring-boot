var app = angular.module("app", []);

app.controller("controller", function ($scope, $http) {

    $scope.Users = [];
    $scope.User = {
        id: "",
        pwd: "",
        name: "",
        gender: "",
        age: ""
    };

    refreshUser();

    $scope.submitUser = function () {
        var method = "POST";
        var url = "users";


        $http({
            method: method,
            url: url,
            data: angular.toJson($scope.User),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(_success, _error);
    };

    $scope.createUser = function () {
        clearForm();
    }

    $scope.deleteUser = function (User) {
        $http({
            method: 'DELETE',
            url: '/user' + User.id
        }).then(_success, _error);
    }
});