polytoDo.factory('userFactory', ['$http', function($http) {
    var factory = {};

    factory.addUser = function (user, callback) {
        $http({
            method: 'POST',
            url: '/addUser',
            data: user
        }).then(function successCallback(response) {
            callback(response);
        }, function errorCallback(err) {
            console.log('Error: ' + err.data.error);
            $(".display-error").html("<ul> <li> " + err.data.message + " </li> </ul>");
            $(".display-error").css("display", "block");
        });
    };

    return factory;
}]);