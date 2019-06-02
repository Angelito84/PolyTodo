polytoDo.controller('userCtrl', ['$scope', '$http', '$window', '$timeout', '$location', 'userFactory', function ($scope, $http, $window, $timeout, $location, userFactory) {
    $scope.checkLogin = function(){
        if($location.absUrl().includes("?error")){
            $(".display-error").html("<ul> Incorrect IDs </ul>");
            $(".display-error").css("display", "block");      }
    };

    $scope.register = function (user) {
        if($('#password_check').val() == $scope.user.password ) {
            userFactory.addUser(user, function (response) {
                alert("Your account has been created ! You will be redirected to the login page.");
                $window.location.href = '/login';
            })
        } else {
            $(".display-error").html("<ul> <li> Passwords do not match.</li> </ul>");
            $(".display-error").css("display", "block");
        }
    };
}]);